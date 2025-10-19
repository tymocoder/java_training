package org.example.digitalLibraryApp;

public class Book extends AbstractLibraryItem {

    private final String author;

    public Book(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public String borrowItem() {
        if(isAvailable()) {
            setAvailable(false);
            return "\nThe book " + getTitle() + " of the author " + author + " was given to the reader.";
        }
        else {
            return String.format("\nThe book %s of the author %s is not available", getTitle(), author);
        }
    }

    @Override
    public String returnItem() {
        if(!isAvailable()) {
            setAvailable(true);
            return String.format("\nThe book %s of the author %s was returned successfully.", getTitle(), author);
        }
        else {
            return "\nYou can't return the book " + getTitle() + " of the author " + author + " because it was not borrowed yet";
        }
    }
}
