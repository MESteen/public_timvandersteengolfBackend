package com.martijn.timvandersteenBackend.controller;

import com.martijn.timvandersteenBackend.exception.ResourceNotFoundException;
import com.martijn.timvandersteenBackend.model.Game;
import com.martijn.timvandersteenBackend.dao.GameDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameDao gameDao;

    @GetMapping("/all")
    public String getAllGames() throws JsonProcessingException {
        List<Game> list = gameDao.findAll();
        String gson = new Gson().toJson(list);
        return gson;
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable(value = "id") int wedstrijdId) {
        Game returnVal = gameDao.findById(wedstrijdId)
                .orElseThrow(() -> new ResourceNotFoundException("Game", "id", wedstrijdId));
        return returnVal;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public Game createGame(@Validated @RequestBody String game) {
        Game addGame = new Gson().fromJson( game, Game.class );
        return gameDao.save(addGame);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/edit/{id}")
    public Game updateGame(@PathVariable(value = "id") int wedstrijdId,
                           @Validated @RequestBody Game gameDetails) {

        Game game = gameDao.findById(wedstrijdId)
                .orElseThrow(() -> new ResourceNotFoundException("Game", "id", wedstrijdId));

        game.setCourseNaam(gameDetails.getCourseNaam());
        game.setWedstrijdNaam(gameDetails.getWedstrijdNaam());
        game.setAantalDagen(gameDetails.getAantalDagen());
        game.setWedstrijdBaanImage(gameDetails.getWedstrijdBaanImage());
        game.setWedstrijdLink(gameDetails.getWedstrijdLink());
        game.setBaanLogo(gameDetails.getBaanLogo());
        game.setDatum(gameDetails.getDatum());
        game.setGespeeld(gameDetails.getGespeeld());

        Game updatedGame = gameDao.save(game);
        return updatedGame;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable(value = "id") int wedstrijdId) {
        Game game = gameDao.findById(wedstrijdId)
                .orElseThrow(() -> new ResourceNotFoundException("Game", "id", wedstrijdId));

        gameDao.delete(game);
        return ResponseEntity.ok().build();
    }
}

