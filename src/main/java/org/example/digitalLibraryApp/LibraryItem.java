package org.example.digitalLibraryApp;

public interface LibraryItem {
    String getTitle();

    boolean isAvailable();

    String borrowItem();

    String returnItem();
}
