package com.joe.joepetitions.controller;

import com.joe.joepetitions.service.PetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PetitionController {

    //Autowired gives access of positionService to PetitionController
    @Autowired
    private PetitionService petitionService;

    @GetMapping("/petitions")
    public String listPetitions(Model model) {
        model.addAttribute("petitions", petitionService.getAllPetitions());
        return "petitions";
    }
}
