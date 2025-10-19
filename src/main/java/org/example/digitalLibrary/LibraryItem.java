package org.example.digitalLibrary;

public interface LibraryItem {
    String getTitle();

    boolean isAvailable();

    String borrowItem();

    String returnItem();
}
