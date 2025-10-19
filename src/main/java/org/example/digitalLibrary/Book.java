package org.example.digitalLibrary;

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
            return "The book " + getTitle() + " of the author " + author + " was given to the reader.";
        }
        else {
            return "The book " + getTitle() + " of the author " + author + " is not available";
        }
    }

    @Override
    public String returnItem() {
        if(!isAvailable()) {
            setAvailable(true);
            return "Book " + getTitle() + " of the author " + author + " was returned successfully.";
        }
        else {
            return "You can't return the book " + getTitle() + " of the author " + author + " because it was not borrowed yet";
        }
    }
}
