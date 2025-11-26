package com.joe.joepetitions.controller;

import com.joe.joepetitions.model.Petition;
import com.joe.joepetitions.service.PetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/petitions/{id}")
    public String showPetition(@PathVariable int id, Model model) {
        Petition petition = petitionService.getPetitionById(id);
        model.addAttribute("petition", petition);

        return "petitionDetail";
    }
}
