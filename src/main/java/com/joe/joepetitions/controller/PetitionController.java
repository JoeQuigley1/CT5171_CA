package com.joe.joepetitions.controller;

import com.joe.joepetitions.model.Petition;
import com.joe.joepetitions.model.Signature;
import com.joe.joepetitions.service.PetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PetitionController {

    //Autowired gives access of positionService to PetitionController
    @Autowired
    private PetitionService petitionService;
    // Think about removing this / as there is a lot of repition in the deployed url jospetitions/petition/petitions
    @GetMapping("/petitions")
    public String listPetitions(
            @RequestParam(value = "keyword", required = false) String keyword,
            Model model) {

        var petitions = petitionService.searchPetitions(keyword);
        model.addAttribute("petitions", petitions);
        model.addAttribute("keyword", keyword);
        return "petitions";
    }

    @GetMapping("/petitions/{id}")
    public String showPetition(@PathVariable int id, Model model) {
        Petition petition = petitionService.getPetitionById(id);
        model.addAttribute("petition", petition);

        model.addAttribute("signature", new Signature());

        return "petitionDetail";
    }

    @GetMapping("/create")
    public String getPetitionForm(Model model) {
        model.addAttribute("petition", new Petition());
        return "createPetition";
    }

    @PostMapping("/create")
    public String submitPetition(Petition petition) {
        petitionService.CreatePetition(petition);
        return "redirect:/petitions";
    }

    @PostMapping("/petitions/{id}/sign")
    public String savePetitionSignature(@PathVariable int id, Signature signature) {
        Petition petition =petitionService.getPetitionById(id);

        if (petition != null) {
            petition.addSignature(signature);
        }

        return "redirect:/petitions/" + id;
    }
}

