package com.joe.joepetitions.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetitionTest {

    @Test
    public void testPetitionFields() {
        Petition p = new Petition(1, "Save the Planet", "Cycle to the Univeristy of Galway", "Joe");

        assertEquals(1, p.getId());
        assertEquals("Save the Planet", p.getTitle());
        assertEquals("Cycle to the Univeristy of Galway", p.getDescription());
        assertEquals("Joe", p.getAuthor());
    }
}
