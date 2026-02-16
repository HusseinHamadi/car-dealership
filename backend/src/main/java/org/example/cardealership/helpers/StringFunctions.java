package org.example.cardealership.helpers;

public class StringFunctions {

    private StringFunctions() {

    }

    public static boolean notNullAndNotEmpty(String str) {
        return str != null && !str.isEmpty();
    }

}
