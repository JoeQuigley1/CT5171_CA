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
    // Think about removing this / as there is a lot of repition in the deployed url jospetitions/petition/petitions
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

    @GetMapping("/create")
    public String getPetitionForm(Model model) {
        model.addAttribute("petition", new Petition());
        return "/createPetition";
    }
}
