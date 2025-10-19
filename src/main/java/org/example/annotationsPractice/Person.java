package org.example.annotationsPractice;

import lombok.Data;

//@Data generates getters for all fields and setters for non-final fields. A required arguments constructor generated for final and @NonNull fields
@Data
public class Person {
    private static final String species = "HUMAN";
    private String name;
    private int age;
    private String email;
}
