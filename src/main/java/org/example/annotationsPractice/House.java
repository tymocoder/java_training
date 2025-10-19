package org.example.annotationsPractice;

import lombok.Builder;
import lombok.Getter;

// @Getter generates getter methods at compile time
// @Builder allows to create objects using set-like chained methods
@Getter
@Builder
public class House {
    private String address;
    private int rooms;
    private double area;
    private double price;
}
