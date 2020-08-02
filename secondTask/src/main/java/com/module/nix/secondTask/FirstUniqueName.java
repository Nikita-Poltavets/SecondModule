package com.module.nix.secondTask;

import java.util.Collections;
import java.util.List;

public class FirstUniqueName {

    public static String getFirstUniqueName(List<String> list){

        return list
               .stream()
               .filter(s -> Collections.frequency(list, s) == 1)
               .findFirst()
               .get();
    }
}
