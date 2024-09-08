package com.benjacksondev.springbootcodegen;

public class StringExtensions {

    public static String studlyCapsToCamelCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        // Convert the first character to lowercase
        StringBuilder camelCase = new StringBuilder();
        camelCase.append(Character.toLowerCase(str.charAt(0)));

        // Append the rest of the string as is
        camelCase.append(str.substring(1));

        return camelCase.toString();
    }
}
