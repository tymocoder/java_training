package org.example.annotationsPractice;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        HelloWorld helloworld = new HelloWorld();
        helloworld.printToConsole();

        Person person = new Person();
        person.setName("Joe");
        person.setAge(33);
        person.setEmail("joe@google.com");

        System.out.println(person.getName());
        System.out.println(person.getEmail());

        Car car = new Car("Mercedes", "Benz");
        System.out.println(car.getBrand());

        Book book = new Book("MyBook", "Bob", 200, 20.20);
        System.out.println(book.getAuthor());

        House house = House.builder()
                .address("Some address")
                .area(99.99)
                .rooms(10)
                .price(999.99)
                .build();
        System.out.println(house.getAddress());

        Product product = new Product();
        product.setName("Meat");
        System.out.println(product.getName());
        System.out.println(product.getSort());

        //Here I used the method with a checked exception
        Date date = DateUtils.parseDate("2024-01-01");
        System.out.println(date);

        Configuration configuration = new Configuration()
                .setHost("localhost")
                .setPort(3030)
                .setSecure(true);
        System.out.println("Host: " + configuration.getHost() + " | " + "Port: " + configuration.getPort() + " | "
        + "Secure: " + configuration.isSecure());
    }
}
