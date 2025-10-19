package org.example.annotationsPractice;

import lombok.AllArgsConstructor;
import lombok.Getter;

// @Getter generates getter methods at compile time
// @AllArgsConstructor generates a constructor with parameter for each field of the class incl final fields
@Getter
@AllArgsConstructor
public class Book {
    private String title;
    private String author = "Someone";
    private int pages;
    private double price;
}
