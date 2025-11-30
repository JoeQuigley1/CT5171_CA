package com.joe.joepetitions.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
