package org.example.classes;

public class Lead extends Person{
    private static int counter=0;
    private int id;

    public Lead(String name, int phoneNumber, String email, String companyName, int id) {
        super(name, phoneNumber, email, companyName);
        counter++;
        this.id = counter;
    }

    public int getId() {
        return id;
    }
}
