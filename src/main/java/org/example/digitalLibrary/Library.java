package org.example.digitalLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, List<LibraryItem>> items = new HashMap<>();

    public Library() {
    }

    public String addItem(LibraryItem item) {
        if(!items.containsKey(item.getTitle())) {
            List<LibraryItem> list = new ArrayList<>();
            list.add(item);
            items.put(item.getTitle(), list);
        }
        else {
            items.get(item.getTitle()).add(item);
        }
        return "Item " + item.getTitle() + " was successfully added. ";
    };

    public String borrowItem(String title) {
        if(items.containsKey(title)) {
            for(LibraryItem item: items.get(title)) {
                if(item.isAvailable()) {
                    return item.borrowItem();
                }
            }
            return "All items with the title " + title + " were already borrowed.";
        }
        return "The library contains no items with the title " + title + ".";
    };

    public String returnItem(String title) {
        if(items.containsKey(title)) {
            for(LibraryItem item: items.get(title)) {
                if(!item.isAvailable()) {
                    return item.returnItem();
                }
            }
            return "All items with the title " + title + " were already returned. You can't return an extra item.";
        }
        return "The library contains no items with the title " + title + ". You can't return the item that doesn't belong to library.";
    };

    public void printAvailableItems() {
        System.out.println("Next items are available in the library:");
        for(Map.Entry<String, List<LibraryItem>> entry: items.entrySet()) {
            for(LibraryItem item: entry.getValue()) {
                if(item.isAvailable()) {
                    System.out.println(item.getTitle());
                }
            }
        }
    };
}
