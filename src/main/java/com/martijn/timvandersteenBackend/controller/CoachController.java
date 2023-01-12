package com.martijn.timvandersteenBackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.martijn.timvandersteenBackend.dao.CoachDao;
import com.martijn.timvandersteenBackend.model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    CoachDao coachDao;

    @GetMapping("/all")
    public String getAllCoach() throws JsonProcessingException {
        List<Coach> list = coachDao.findAll();
        String gson = new Gson().toJson(list);
        return gson;
    }
}
