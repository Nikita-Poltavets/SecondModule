package com.module.nix.secondTask;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FirstUniqueNameTest {

    @Test
    void getFirstUniqueName() {
        List<String> listName = new ArrayList<>();

        listName.add("John");
        listName.add("Adam");
        listName.add("Adam");
        listName.add("Ben");
        listName.add("Jennifer");
        listName.add("Ben");
        listName.add("John");

        assertEquals("Jennifer", FirstUniqueName.getFirstUniqueName(listName));
    }
}