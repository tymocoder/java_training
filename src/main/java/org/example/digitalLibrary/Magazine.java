package org.example.digitalLibrary;

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
            return "The magazine " + getTitle() + " issue number: " + issueNumber + " was given to the reader.";
        }
        else {
            return "The magazine " + getTitle() + " issue number: " + issueNumber + " is not available";
        }
    }

    @Override
    public String returnItem() {
        if(!isAvailable()) {
            setAvailable(true);
            return "Magazine " + getTitle() + " issue number: " + issueNumber + " was returned successfully.";
        }
        else {
            return "You can't return the magazine " + getTitle() + " issue number: " + issueNumber + " because it was not borrowed yet";
        }
    }
}
