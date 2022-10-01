package org.example.classes;

public class Lead extends Person{
    private static int counter=0;
    private int id;

    public Lead(String name, int phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
        counter++;
        this.id = counter;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Lead " +this.getId()+": \n" +
                "Contact name: " + this.getName() + '\n' +
                "Telephone number: " + this.getPhoneNumber() + '\n'+
                "E-mail address: " + this.getEmail() + '\n' +
                "Company: " + this.getCompanyName() + '\n' +
                "==========================================";
    }
}
