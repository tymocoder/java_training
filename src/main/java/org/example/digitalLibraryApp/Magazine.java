package org.example.digitalLibraryApp;

public class Magazine extends AbstractLibraryItem {

    private final int issueNumber;

    public Magazine(String title, int issueNumber) {
        super(title);
        this.issueNumber = issueNumber;
    }

    @Override
    public String borrowItem() {
        if(isAvailable()) {
            setAvailable(false);
            return "\nThe magazine " + getTitle() + " issue number: " + issueNumber + " was given to the reader.";
        }
        else {
            return String.format("\nThe magazine %s issue number: %s is not available", getTitle(), issueNumber);
        }
    }

    @Override
    public String returnItem() {
        if(!isAvailable()) {
            setAvailable(true);
            return "\nMagazine " + getTitle() + " issue number: " + issueNumber + " was returned successfully.";
        }
        else {
            return "\nYou can't return the magazine " + getTitle() + " issue number: " + issueNumber + " because it was not borrowed yet";
        }
    }
}
