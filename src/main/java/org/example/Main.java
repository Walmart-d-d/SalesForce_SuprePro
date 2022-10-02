package org.example;

import org.example.classes.Account;
import org.example.classes.Contact;
import org.example.classes.Lead;
import org.example.classes.Opportunity;
import org.example.enums.IndustryOption;
import org.example.enums.OppStatus;
import org.example.enums.ProductType;

import java.util.*;

public class Main {
    private static Map<Integer, Lead> leadMap = new HashMap<>();
    private static Map<Integer, Opportunity> oppMap = new HashMap<>();
    private static Map<Integer, Account> accountMap = new HashMap<>();

    public static void main(String[] args) {
        createLead();
        createLead();
        showLeadMap();
    }






    public static void createLead(){
        Scanner input = new Scanner (System.in);
        System.out.println("Introduce name:");
        String name = input.nextLine();
        System.out.println("Introduce telephone number:"); //hay que hacer catch
        String phone = input.nextLine();
        while (phone.contains("a") || phone.contains("b") || phone.contains("c") || phone.contains("d") || phone.contains("e") || phone.contains("f") || phone.contains("g") || phone.contains("h") || phone.contains("i") || phone.contains("j") || phone.contains("k") || phone.contains("l") || phone.contains("m") || phone.contains("n") || phone.contains("o") || phone.contains("p") || phone.contains("q") || phone.contains("r") || phone.contains("s") || phone.contains("t") || phone.contains("u") || phone.contains("v") || phone.contains("w") || phone.contains("x") || phone.contains("y") || phone.contains("z") || phone.contains("A") || phone.contains("B") || phone.contains("C") || phone.contains("D") || phone.contains("E") || phone.contains("F") || phone.contains("G") || phone.contains("H") || phone.contains("I") || phone.contains("J") || phone.contains("K") || phone.contains("L") || phone.contains("M") || phone.contains("N") || phone.contains("O") || phone.contains("P") || phone.contains("Q") || phone.contains("R") || phone.contains("S") || phone.contains("T") || phone.contains("U") || phone.contains("V") || phone.contains("W") || phone.contains("X") || phone.contains("Y") || phone.contains("Z")){
            System.err.println("Must enter a phone number.");
            System.out.println("Please, introduce telephone number:");
            phone = input.nextLine();
        }
        int phoneNumber = Integer.parseInt(phone);
        System.out.println("Introduce email address:"); //podria hacerse catch
        String email = input.nextLine();
        System.out.println("Introduce the name of the company:");
        String companyName = input.nextLine();
        Lead lead = new Lead (name, phoneNumber, email, companyName);
        leadMap.put(lead.getId(), lead);
    }

    public static void showLeadMap(){
           for(Map.Entry<Integer, Lead> leadEntry : leadMap.entrySet()){
               System.out.println(leadEntry.getValue());
           }
    }

    public static void createOpportunityAndAccount(){
        Scanner input = new Scanner (System.in);
        System.out.println("Enter the identification number of the lead you want to convert:"); //hay que hacer catch
        String idString = input.nextLine();
        while (idString.contains("a") || idString.contains("b") || idString.contains("c") || idString.contains("d") || idString.contains("e") || idString.contains("f") || idString.contains("g") || idString.contains("h") || idString.contains("i") || idString.contains("j") || idString.contains("k") || idString.contains("l") || idString.contains("m") || idString.contains("n") || idString.contains("o") || idString.contains("p") || idString.contains("q") || idString.contains("r") || idString.contains("s") || idString.contains("t") || idString.contains("u") || idString.contains("v") || idString.contains("w") || idString.contains("x") || idString.contains("y") || idString.contains("z") || idString.contains("A") || idString.contains("B") || idString.contains("C") || idString.contains("D") || idString.contains("E") || idString.contains("F") || idString.contains("G") || idString.contains("H") || idString.contains("I") || idString.contains("J") || idString.contains("K") || idString.contains("L") || idString.contains("M") || idString.contains("N") || idString.contains("O") || idString.contains("P") || idString.contains("Q") || idString.contains("R") || idString.contains("S") || idString.contains("T") || idString.contains("U") || idString.contains("V") || idString.contains("W") || idString.contains("X") || idString.contains("Y") || idString.contains("Z")){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the identification number:");
            idString = input.nextLine();
        }
        int idInt = Integer.parseInt(idString);
        Lead lead = leadMap.get(idInt);
        Contact decisionMaker = new Contact(lead.getName(),lead.getPhoneNumber(),lead.getEmail(),lead.getCompanyName());
        leadMap.remove(idInt);
        System.out.println("Choose product type:");
        System.out.println("1. Hybrid");
        System.out.println("2. Flatbed");
        System.out.println("3. Box");
        String productKey = input.nextLine();
        while (productKey!="1" && productKey!="2" && productKey!="3"){
            System.err.println("Invalid option.");
            System.out.println("Choose product type:");
            System.out.println("1. Hybrid");
            System.out.println("2. Flatbed");
            System.out.println("3. Box");
            productKey = input.nextLine();
        }
        ProductType productType;
        switch(productKey){
            case "1":
            productType = ProductType.HYBRID;
            break;
            case "2":
            productType = ProductType.FLATBED;
            break;
            case "3":
            productType = ProductType.BOX;
            break;
            default:
            throw new IllegalArgumentException("Not a valid option."); //hay que devolver la pregunta
        }
        System.out.println("Number of products:"); //hay que hacer catch
        String numberOfProducts = input.nextLine();
        while (numberOfProducts.contains("a") || numberOfProducts.contains("b") || numberOfProducts.contains("c") || numberOfProducts.contains("d") || numberOfProducts.contains("e") || numberOfProducts.contains("f") || numberOfProducts.contains("g") || numberOfProducts.contains("h") || numberOfProducts.contains("i") || numberOfProducts.contains("j") || numberOfProducts.contains("k") || numberOfProducts.contains("l") || numberOfProducts.contains("m") || numberOfProducts.contains("n") || numberOfProducts.contains("o") || numberOfProducts.contains("p") || numberOfProducts.contains("q") || numberOfProducts.contains("r") || numberOfProducts.contains("s") || numberOfProducts.contains("t") || numberOfProducts.contains("u") || numberOfProducts.contains("v") || numberOfProducts.contains("w") || numberOfProducts.contains("x") || numberOfProducts.contains("y") || numberOfProducts.contains("z") || numberOfProducts.contains("A") || numberOfProducts.contains("B") || numberOfProducts.contains("C") || numberOfProducts.contains("D") || numberOfProducts.contains("E") || numberOfProducts.contains("F") || numberOfProducts.contains("G") || numberOfProducts.contains("H") || numberOfProducts.contains("I") || numberOfProducts.contains("J") || numberOfProducts.contains("K") || numberOfProducts.contains("L") || numberOfProducts.contains("M") || numberOfProducts.contains("N") || numberOfProducts.contains("O") || numberOfProducts.contains("P") || numberOfProducts.contains("Q") || numberOfProducts.contains("R") || numberOfProducts.contains("S") || numberOfProducts.contains("T") || numberOfProducts.contains("U") || numberOfProducts.contains("V") || numberOfProducts.contains("W") || numberOfProducts.contains("X") || numberOfProducts.contains("Y") || numberOfProducts.contains("Z")){
            System.err.println("The quantity must be written in numbers.");
            System.out.println("Please, enter the number of products:");
            numberOfProducts = input.nextLine();
        }
        int quantity = Integer.parseInt(numberOfProducts);
        OppStatus status = OppStatus.OPEN;
        Opportunity opportunity = new Opportunity(productType, decisionMaker, quantity, status);
        oppMap.put(opportunity.getId(), opportunity);

        System.out.println("Choose the company's sector:");
        System.out.println("1. Produce");
        System.out.println("2. E-Commerce");
        System.out.println("3. Manufacturing");
        System.out.println("4. Medical");
        System.out.println("5. Other");
        String industryKey = input.nextLine();
        while (industryKey!="1" && industryKey!="2" && industryKey!="3" && industryKey!="4" && industryKey!="5"){
            System.err.println("Invalid option.");
            System.out.println("Please, choose the company's sector:");
            System.out.println("1. Produce");
            System.out.println("2. E-Commerce");
            System.out.println("3. Manufacturing");
            System.out.println("4. Medical");
            System.out.println("5. Other");
            industryKey = input.nextLine();
        }
        IndustryOption industryOption;
       /* if (industryKey == "1"){
            industryOption = IndustryOption.PRODUCE;
        } else if(industryKey=="2"){
            industryOption = IndustryOption.ECOMMERCE;
        } else if(industryKey=="3") {
            industryOption = IndustryOption.MANUFACTURING;
        } else if(industryKey=="4") {
            industryOption = IndustryOption.MEDICAL;
        } else if(industryKey=="5"){
            industryOption = IndustryOption.OTHER;
        } else {
            throw new IllegalArgumentException("Not valid option.");
        }*/
        switch (industryKey){
            case "1":
                industryOption = IndustryOption.PRODUCE;
                break;
            case "2":
                industryOption = IndustryOption.ECOMMERCE;
                break;
            case "3":
                industryOption = IndustryOption.MANUFACTURING;
                break;
            case "4":
                industryOption = IndustryOption.MEDICAL;
                break;
            case "5":
                industryOption = IndustryOption.OTHER;
                break;
            default:
                throw new IllegalArgumentException("Invalid option.");
        }
        System.out.println("Number of employees:");
        String numEmployees = input.nextLine();
        while (numEmployees.contains("a") || numEmployees.contains("b") || numEmployees.contains("c") || numEmployees.contains("d") || numEmployees.contains("e") || numEmployees.contains("f") || numEmployees.contains("g") || numEmployees.contains("h") || numEmployees.contains("i") || numEmployees.contains("j") || numEmployees.contains("k") || numEmployees.contains("l") || numEmployees.contains("m") || numEmployees.contains("n") || numEmployees.contains("o") || numEmployees.contains("p") || numEmployees.contains("q") || numEmployees.contains("r") || numEmployees.contains("s") || numEmployees.contains("t") || numEmployees.contains("u") || numEmployees.contains("v") || numEmployees.contains("w") || numEmployees.contains("x") || numEmployees.contains("y") || numEmployees.contains("z") || numEmployees.contains("A") || numEmployees.contains("B") || numEmployees.contains("C") || numEmployees.contains("D") || numEmployees.contains("E") || numEmployees.contains("F") || numEmployees.contains("G") || numEmployees.contains("H") || numEmployees.contains("I") || numEmployees.contains("J") || numEmployees.contains("K") || numEmployees.contains("L") || numEmployees.contains("M") || numEmployees.contains("N") || numEmployees.contains("O") || numEmployees.contains("P") || numEmployees.contains("Q") || numEmployees.contains("R") || numEmployees.contains("S") || numEmployees.contains("T") || numEmployees.contains("U") || numEmployees.contains("V") || numEmployees.contains("W") || numEmployees.contains("X") || numEmployees.contains("Y") || numEmployees.contains("Z")){
            System.err.println("Must be a number.");
            System.out.println("Please, enter the number of employees in the company:");
            numEmployees = input.nextLine();
        }
        int employeeCount = Integer.parseInt(numEmployees);
        System.out.println("City:");
        String city = input.nextLine();
        System.out.println("Country:");
        String country = input.nextLine();
        List<Opportunity> oppList = new ArrayList<>();
        oppList.add(opportunity);
        List<Contact> contactList = new ArrayList<>();
        contactList.add(decisionMaker);
        Account account = new Account(industryOption, employeeCount, city, country, oppList, contactList);
        accountMap.put(account.getId(), account);
    }
    public static void createOpportunity() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the identification number of the company account this opportunity is attached to:");
        String idAccString = input.nextLine();
        while (idAccString.contains("a") || idAccString.contains("b") || idAccString.contains("c") || idAccString.contains("d") || idAccString.contains("e") || idAccString.contains("f") || idAccString.contains("g") || idAccString.contains("h") || idAccString.contains("i") || idAccString.contains("j") || idAccString.contains("k") || idAccString.contains("l") || idAccString.contains("m") || idAccString.contains("n") || idAccString.contains("o") || idAccString.contains("p") || idAccString.contains("q") || idAccString.contains("r") || idAccString.contains("s") || idAccString.contains("t") || idAccString.contains("u") || idAccString.contains("v") || idAccString.contains("w") || idAccString.contains("x") || idAccString.contains("y") || idAccString.contains("z") || idAccString.contains("A") || idAccString.contains("B") || idAccString.contains("C") || idAccString.contains("D") || idAccString.contains("E") || idAccString.contains("F") || idAccString.contains("G") || idAccString.contains("H") || idAccString.contains("I") || idAccString.contains("J") || idAccString.contains("K") || idAccString.contains("L") || idAccString.contains("M") || idAccString.contains("N") || idAccString.contains("O") || idAccString.contains("P") || idAccString.contains("Q") || idAccString.contains("R") || idAccString.contains("S") || idAccString.contains("T") || idAccString.contains("U") || idAccString.contains("V") || idAccString.contains("W") || idAccString.contains("X") || idAccString.contains("Y") || idAccString.contains("Z")){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the account identification number:");
            idAccString = input.nextLine();
        }
        int idAccInt = Integer.parseInt(idAccString);
        Account account = accountMap.get(idAccInt);
        System.out.println("Enter the identification number of the lead you want to convert:"); //hay que hacer catch
        String idString = input.nextLine();
        while (idString.contains("a") || idString.contains("b") || idString.contains("c") || idString.contains("d") || idString.contains("e") || idString.contains("f") || idString.contains("g") || idString.contains("h") || idString.contains("i") || idString.contains("j") || idString.contains("k") || idString.contains("l") || idString.contains("m") || idString.contains("n") || idString.contains("o") || idString.contains("p") || idString.contains("q") || idString.contains("r") || idString.contains("s") || idString.contains("t") || idString.contains("u") || idString.contains("v") || idString.contains("w") || idString.contains("x") || idString.contains("y") || idString.contains("z") || idString.contains("A") || idString.contains("B") || idString.contains("C") || idString.contains("D") || idString.contains("E") || idString.contains("F") || idString.contains("G") || idString.contains("H") || idString.contains("I") || idString.contains("J") || idString.contains("K") || idString.contains("L") || idString.contains("M") || idString.contains("N") || idString.contains("O") || idString.contains("P") || idString.contains("Q") || idString.contains("R") || idString.contains("S") || idString.contains("T") || idString.contains("U") || idString.contains("V") || idString.contains("W") || idString.contains("X") || idString.contains("Y") || idString.contains("Z")){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the lead identification number:");
            idString = input.nextLine();
        }
        int idInt = Integer.parseInt(idString);
        Lead lead = leadMap.get(idInt);
        Contact decisionMaker = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
        leadMap.remove(idInt);
        System.out.println("Choose product type:");
        System.out.println("1. Hybrid");
        System.out.println("2. Flatbed");
        System.out.println("3. Box");
        String productKey = input.nextLine();
        while (productKey!="1" && productKey!="2" && productKey!="3"){
            System.err.println("Invalid option.");
            System.out.println("Choose product type:");
            System.out.println("1. Hybrid");
            System.out.println("2. Flatbed");
            System.out.println("3. Box");
            productKey = input.nextLine();
        }
        ProductType productType;
        switch(productKey){
            case "1":
                productType = ProductType.HYBRID;
                break;
            case "2":
                productType = ProductType.FLATBED;
                break;
            case "3":
                productType = ProductType.BOX;
                break;
            default:
                throw new IllegalArgumentException("Not a valid option."); //hay que devolver la pregunta
        }
        System.out.println("Number of products:"); //hay que hacer catch
        String numberOfProducts = input.nextLine();
        int quantity = Integer.parseInt(numberOfProducts);
        OppStatus status = OppStatus.OPEN;
        Opportunity opportunity = new Opportunity(productType, decisionMaker, quantity, status);
        oppMap.put(opportunity.getId(), opportunity);
        account.addContactList(decisionMaker);
        account.addOpportunityList(opportunity);
    }

    public static void showAllOpportunities(){
        for(Map.Entry<Integer, Opportunity> opportunityEntry : oppMap.entrySet()){
            System.out.println(opportunityEntry.getValue());
        }
    }

    public static void showOpportunityList(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the identification number of the account you want to see the list of opportunities of:");
        String accString = input.nextLine();
        while (accString.contains("a") || accString.contains("b") || accString.contains("c") || accString.contains("d") || accString.contains("e") || accString.contains("f") || accString.contains("g") || accString.contains("h") || accString.contains("i") || accString.contains("j") || accString.contains("k") || accString.contains("l") || accString.contains("m") || accString.contains("n") || accString.contains("o") || accString.contains("p") || accString.contains("q") || accString.contains("r") || accString.contains("s") || accString.contains("t") || accString.contains("u") || accString.contains("v") || accString.contains("w") || accString.contains("x") || accString.contains("y") || accString.contains("z") || accString.contains("A") || accString.contains("B") || accString.contains("C") || accString.contains("D") || accString.contains("E") || accString.contains("F") || accString.contains("G") || accString.contains("H") || accString.contains("I") || accString.contains("J") || accString.contains("K") || accString.contains("L") || accString.contains("M") || accString.contains("N") || accString.contains("O") || accString.contains("P") || accString.contains("Q") || accString.contains("R") || accString.contains("S") || accString.contains("T") || accString.contains("U") || accString.contains("V") || accString.contains("W") || accString.contains("X") || accString.contains("Y") || accString.contains("Z")){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the account identification number:");
            accString = input.nextLine();
        }
        int accInt = Integer.parseInt(accString);
        Account account = accountMap.get(accInt);
        List<Opportunity> opportunityList = account.getOpportunityList();
        for (Opportunity opportunity : opportunityList){
            System.out.println(opportunity.toString());
        }
    }

    public static void showContactList(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the identification number of the account you want to see the list of opportunities of:");
        String accString = input.nextLine();
        while (accString.contains("a") || accString.contains("b") || accString.contains("c") || accString.contains("d") || accString.contains("e") || accString.contains("f") || accString.contains("g") || accString.contains("h") || accString.contains("i") || accString.contains("j") || accString.contains("k") || accString.contains("l") || accString.contains("m") || accString.contains("n") || accString.contains("o") || accString.contains("p") || accString.contains("q") || accString.contains("r") || accString.contains("s") || accString.contains("t") || accString.contains("u") || accString.contains("v") || accString.contains("w") || accString.contains("x") || accString.contains("y") || accString.contains("z") || accString.contains("A") || accString.contains("B") || accString.contains("C") || accString.contains("D") || accString.contains("E") || accString.contains("F") || accString.contains("G") || accString.contains("H") || accString.contains("I") || accString.contains("J") || accString.contains("K") || accString.contains("L") || accString.contains("M") || accString.contains("N") || accString.contains("O") || accString.contains("P") || accString.contains("Q") || accString.contains("R") || accString.contains("S") || accString.contains("T") || accString.contains("U") || accString.contains("V") || accString.contains("W") || accString.contains("X") || accString.contains("Y") || accString.contains("Z")){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the account identification number:");
            accString = input.nextLine();
        }
        int accInt = Integer.parseInt(accString);
        Account account = accountMap.get(accInt);
        List<Contact> contactList = account.getContactList();
        for (Contact contact : contactList){
            System.out.println(contact.toString());
        }
    }
    public static void showAccounts(){
        for(Map.Entry<Integer, Account> accountEntry : accountMap.entrySet()){
            System.out.println(accountEntry.getValue());
        }
    }

    public static void showLeadById() throws NoSuchFieldException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the identification number of the Lead you want to see:"); //hay que hacer catch
        String idString = input.nextLine();
        while (idString.contains("a") || idString.contains("b") || idString.contains("c") || idString.contains("d") || idString.contains("e") || idString.contains("f") || idString.contains("g") || idString.contains("h") || idString.contains("i") || idString.contains("j") || idString.contains("k") || idString.contains("l") || idString.contains("m") || idString.contains("n") || idString.contains("o") || idString.contains("p") || idString.contains("q") || idString.contains("r") || idString.contains("s") || idString.contains("t") || idString.contains("u") || idString.contains("v") || idString.contains("w") || idString.contains("x") || idString.contains("y") || idString.contains("z") || idString.contains("A") || idString.contains("B") || idString.contains("C") || idString.contains("D") || idString.contains("E") || idString.contains("F") || idString.contains("G") || idString.contains("H") || idString.contains("I") || idString.contains("J") || idString.contains("K") || idString.contains("L") || idString.contains("M") || idString.contains("N") || idString.contains("O") || idString.contains("P") || idString.contains("Q") || idString.contains("R") || idString.contains("S") || idString.contains("T") || idString.contains("U") || idString.contains("V") || idString.contains("W") || idString.contains("X") || idString.contains("Y") || idString.contains("Z")){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the lead identification number:");
            idString = input.nextLine();
        }
        int idInt = Integer.parseInt(idString);
        if (idInt>0 && idInt<leadMap.size()){
            System.out.println(leadMap.containsKey(idInt));
        } else {
            throw new NoSuchFieldException("Lead does not exist.");
        }
    }
}