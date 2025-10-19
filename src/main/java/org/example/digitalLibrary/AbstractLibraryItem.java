package org.example.digitalLibrary;

public abstract class AbstractLibraryItem implements LibraryItem{

    private String title;

    private boolean available = true;

    public AbstractLibraryItem(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
