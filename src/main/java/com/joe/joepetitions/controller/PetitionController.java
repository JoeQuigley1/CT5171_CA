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
    //Display all petitions or search petitions and display search results page
    @GetMapping("/petitions")
    public String listPetitions(
            @RequestParam(value = "keyword", required = false) String keyword,
            Model model) {

        var petitions = petitionService.searchPetitions(keyword);
        model.addAttribute("petitions", petitions);
        model.addAttribute("keyword", keyword);

        if (keyword !=null && !keyword.isEmpty()) {
            return "searchResult";
        }

        return "petitions";
    }
    // Display petition Detail based on the petition id and the signatures
    @GetMapping("/petitions/{id}")
    public String showPetition(@PathVariable int id, Model model) {
        Petition petition = petitionService.getPetitionById(id);
        model.addAttribute("petition", petition);

        model.addAttribute("signature", new Signature());

        return "petitionDetail";
    }

    // Gets the create a petition form
    @GetMapping("/create")
    public String getPetitionForm(Model model) {
        model.addAttribute("petition", new Petition());
        return "createPetition";
    }

    //After petition is created return to all petitions view
    @PostMapping("/create")
    public String submitPetition(Petition petition) {
        petitionService.CreatePetition(petition);
        return "redirect:/petitions";
    }

    // Handle adding a signature to a petition and  redirects to detail page
    @PostMapping("/petitions/{id}/sign")
    public String savePetitionSignature(@PathVariable int id, Signature signature) {
        Petition petition =petitionService.getPetitionById(id);

        if (petition != null) {
            petition.addSignature(signature);
        }

        return "redirect:/petitions/" + id;
    }
}

