package org.example;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// @Getter generates getter methods at compile time
// @RequiredArgsConstructor generates a constructor only for final and @NonNull anotated fields
@Getter
@RequiredArgsConstructor
public class Car {
    private final String brand;
    // @NonNull forces non-final field to be required
    @NonNull private String model;
    private String trim;
}
