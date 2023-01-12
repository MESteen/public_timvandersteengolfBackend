package com.martijn.timvandersteenBackend.controller;

import com.martijn.timvandersteenBackend.config.TokenProvider;
import com.martijn.timvandersteenBackend.exception.ResourceNotFoundException;
import com.martijn.timvandersteenBackend.model.*;
import com.martijn.timvandersteenBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") long userId) {
        User returnVal =userService.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return returnVal;
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/username", method = RequestMethod.POST) //moet op basis van username && password worden
    public User getUserByUsername(@RequestBody LoginUser loginUser) {
        User returnVal =userService.findOne(loginUser.getUsername());
        return returnVal;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/adminping", method = RequestMethod.GET)
    public String adminPing(){
        return "Only Admins Can Read This";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/userping", method = RequestMethod.GET)
    public String userPing(){
        return "Any User Can Read This";
    }

}
