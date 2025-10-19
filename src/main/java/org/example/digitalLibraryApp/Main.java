package org.example.digitalLibraryApp;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book bookOne = new Book("Alphabet", "Joe Harrison");
        Book bookTwo = new Book("Math", "Joe Mathematician");
        Book bookThree = new Book("Alchemy", "Joe Alchemist");
        Magazine magazineOne = new Magazine("Pony cars", 1);
        Magazine magazineTwo = new Magazine("Pony cars", 2);
        Magazine magazineThree = new Magazine("Trucks", 1);
        Magazine magazineFour = new Magazine("Trucks", 1);
        Magazine magazineFive = new Magazine("Trucks", 1);


        System.out.println(library.addItem(bookOne));
        System.out.println(library.addItem(bookTwo));
        System.out.println(library.addItem(bookThree));
        System.out.println(library.addItem(magazineOne));;
        System.out.println(library.addItem(magazineTwo));
        System.out.println(library.addItem(magazineThree));
        System.out.println(library.addItem(magazineFour));
        System.out.println(library.addItem(magazineFive));

        library.printAvailableItems();

        System.out.println(library.borrowItem("Alphabet"));

        library.printAvailableItems();

        System.out.println(library.borrowItem("Alphabet"));

        library.printAvailableItems();

        System.out.println(library.returnItem("Alphabet"));

        library.printAvailableItems();

        System.out.println(library.borrowItem("Pony cars"));

        library.printAvailableItems();

        System.out.println(library.borrowItem("Pony cars"));

        library.printAvailableItems();

        System.out.println(library.borrowItem("Pony cars"));

        library.printAvailableItems();

        System.out.println(library.returnItem("Pony cars"));

        library.printAvailableItems();

        System.out.println(library.returnItem("Pony cars"));

        library.printAvailableItems();

        System.out.println(library.returnItem("Pony cars"));

        library.printAvailableItems();
    }
}
