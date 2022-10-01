package org.example.classes;

public class Contact extends Person {
    private static int counter = 0;
    private int id;


    public Contact(String name, int phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
        counter++;
        this.id = counter;
    }

    public int getId() {
        return id;
    }
}
