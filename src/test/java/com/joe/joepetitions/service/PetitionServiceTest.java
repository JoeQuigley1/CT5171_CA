package com.joe.joepetitions.service;

import com.joe.joepetitions.model.Petition;
import com.joe.joepetitions.model.Signature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PetitionServiceTest {

    @Test
    void searchPetitionTitle() {
        PetitionService service = new PetitionService();

        var results = service.searchPetitions("roads");

        assertEquals(1, results.size());
        assertEquals("Fix the roads", results.get(0).getTitle());
    }

    @Test
    void searchPetitionDescription() {
        PetitionService service = new PetitionService();

        var results = service.searchPetitions("November");

        assertEquals(3, results.size());
        assertEquals("It's only November and the potholes are massive.", results.get(0).getDescription());
    }

    @Test
    void petitionDetails() {
        PetitionService service = new PetitionService();

        Petition petition = service.getPetitionById(1);

        assertNotNull(petition);
        assertEquals("Fix the roads", petition.getTitle());
        assertEquals("It's only November and the potholes are massive.", petition.getDescription());
        assertEquals("John", petition.getAuthor());


        Signature signature = petition.getSignatures().get(0);
        assertNotNull(signature);
        assertEquals("Alice Doe", signature.getName());
        assertEquals("alice@example.com", signature.getEmail());
        assertEquals(12345678, signature.getPhoneNumber());
    }

}
