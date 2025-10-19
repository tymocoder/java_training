package org.example.annotationsPractice;

import lombok.Getter;
import lombok.Setter;

// @Getter generates getter methods at compile time
// @Setter generates setter methods at compile time
@Getter
@Setter
public class Product {
    public static final String sort = "food";
    private String name;
    private double price;

    public String getSort() {
        return sort;
    }
}
