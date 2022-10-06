package org.example;
import org.apache.commons.lang3.math.NumberUtils;
import org.example.classes.Account;
import org.example.classes.Contact;
import org.example.classes.Lead;
import org.example.classes.Opportunity;
import org.example.enums.IndustryOption;
import org.example.enums.OppStatus;
import org.example.enums.ProductType;

import javax.swing.*;
import java.util.*;

public class Main {
    private static Map<Integer, Lead> leadMap = new HashMap<>();
    private static Map<Integer, Opportunity> oppMap = new HashMap<>();
    private static Map<Integer, Account> accountMap = new HashMap<>();
    private static Scanner input = new Scanner (System.in);
    private static Contact decisionMaker;
    private static Opportunity opportunity;
    private static Account account;

    public static void main(String[] args){

    }


    public static Map<String, String> getLeadInfo(){
        Map<String, String> leadInfo = new HashMap<>();

        System.out.println("Introduce name:");
        String name = input.nextLine();

        System.out.println("Introduce telephone number:");
        String phone = input.nextLine();
        while(!NumberUtils.isParsable(phone)){
            System.err.println("Must enter a phone number.");
            System.out.println("Please, introduce telephone number:");
            phone = input.nextLine();
        }

        System.out.println("Introduce email address:");
        String email = input.nextLine();

        System.out.println("Introduce the name of the company:");
        String companyName = input.nextLine();

        leadInfo = Map.of(
                "name", name,
                "phone", phone,
                "email", email,
                "companyName", companyName
                );

        return leadInfo;
    }

    public static Lead createLead(Map<String, String> leadInfo){
        return new Lead (leadInfo.get("name"), Integer.parseInt(leadInfo.get("phone")), leadInfo.get("email"), leadInfo.get("companyName"));
    }

    //leadMap.put(lead.getId(), lead); --> pending

    public static void showLeadMap(){
           for(Map.Entry<Integer, Lead> leadEntry : leadMap.entrySet()){
               System.out.println(leadEntry.getValue());
           }
    }

    //REVIEW CODE - POSSIBLE BUG
    public static Lead getLeadToConvert(Map<Integer, Lead> leadMap) {
        System.out.println("Enter the identification number of the lead you want to convert:");
        String idString = input.nextLine();

        while (!NumberUtils.isParsable(idString)) {
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the identification number:");
            idString = input.nextLine();
        }
        int idInt = Integer.parseInt(idString);

        if (!leadMap.containsKey(idInt)) {
            System.err.println("Lead not found.");
            getLeadToConvert(leadMap);
        }
        Lead lead = leadMap.get(idInt);
        return lead;
    }

    public static void createDecisionMaker(Lead lead){
        decisionMaker = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
    }

    public static void removeFromLeadMap(int idInt){
        leadMap.remove(idInt);
    }

   public static void createOpportunity(Map<Integer, Opportunity> oppMap) {
       System.out.println("Choose product type:");
       System.out.println("1. Hybrid");
       System.out.println("2. Flatbed");
       System.out.println("3. Box");
       String productKey = input.nextLine();
       ProductType productType = null;
       switch (productKey) {
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
               System.err.println("Invalid option.");
               createOpportunity(oppMap);
       }
       System.out.println("Number of products:");
       String numberOfProducts = input.nextLine();
       while (!NumberUtils.isParsable(numberOfProducts)) {
           System.err.println("The quantity must be written in numbers.");
           System.out.println("Please, enter the number of products:");
           numberOfProducts = input.nextLine();
       }
       int quantity = Integer.parseInt(numberOfProducts);
       OppStatus status = OppStatus.OPEN;
       opportunity = new Opportunity(productType, decisionMaker, quantity, status);
       oppMap.put(opportunity.getId(), opportunity);
   }



public static void createAccount(Map<Integer, Account> accountMap){
        System.out.println("Choose the company's sector:");
        System.out.println("1. Produce");
        System.out.println("2. E-Commerce");
        System.out.println("3. Manufacturing");
        System.out.println("4. Medical");
        System.out.println("5. Other");
        String industryKey = input.nextLine();
        IndustryOption industryOption = null;
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
                System.err.println("Invalid option.");
                createAccount(accountMap);
        }
        System.out.println("Number of employees:");
        String numEmployees = input.nextLine();
            while(!NumberUtils.isParsable(numEmployees)){
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

    public static Account createOpportunityInAccount(Map<Integer, Account> accountMap){
        System.out.println("Enter the identification number of the company account this opportunity is attached to:");
        String idAccString = input.nextLine();
        while (!NumberUtils.isParsable(idAccString)) {
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the account identification number:");
            idAccString = input.nextLine();
        }
        int idAccInt = Integer.parseInt(idAccString);
        if (!accountMap.containsKey(idAccInt)) {
            System.err.println("Account not found.");
            createOpportunityInAccount(accountMap);
        }
        account = accountMap.get(idAccInt);
        return account;
    }

        public static Contact createDecisionMakerInAccount(Map<Integer, Lead> leadMap) {
            System.out.println("Enter the identification number of the lead you want to convert:");
            String idString = input.nextLine();
            while (!NumberUtils.isParsable(idString)) {
                System.err.println("The identification must be a number.");
                System.out.println("Please, enter the lead identification number:");
                idString = input.nextLine();
            }
            System.out.println(idString);
            int idInt = Integer.parseInt(idString);
            if (!leadMap.containsKey(idInt)) {
                System.err.println("Lead not found.");
                createDecisionMakerInAccount(leadMap);
            }
            Lead lead = leadMap.get(idInt);
            decisionMaker = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
            System.out.println(decisionMaker);
            return decisionMaker;
        }

        //leadMap.remove(idInt); -- PENDING



        public static Opportunity createOppInAccount(Account account){
        System.out.println("Choose product type:");
        System.out.println("1. Hybrid");
        System.out.println("2. Flatbed");
        System.out.println("3. Box");
        String productKey = input.nextLine();
        ProductType productType = null;
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
                System.err.println("Not a valid option.");
                createOppInAccount(account);
        }
        System.out.println("Number of products:");
        String numberOfProducts = input.nextLine();
            while (!NumberUtils.isParsable(numberOfProducts)) {
                System.err.println("Invalid value.");
                System.out.println("Please, enter the quantity of products in numbers:");
                numberOfProducts = input.nextLine();
            }
        int quantity = Integer.parseInt(numberOfProducts);
        OppStatus status = OppStatus.OPEN;
        opportunity = new Opportunity(productType, decisionMaker, quantity, status);
        oppMap.put(opportunity.getId(), opportunity);
        account.addContactList(decisionMaker);
        account.addOpportunityList(opportunity);
        return opportunity;
    }


    public static void showAllOpportunities(){
        for(Map.Entry<Integer, Opportunity> opportunityEntry : oppMap.entrySet()){
            System.out.println(opportunityEntry.getValue());
        }
    }

    public static void showOpportunityList() throws NoSuchFieldException {
        System.out.println("Enter the identification number of the account you want to see the list of opportunities of:");
        String accString = input.nextLine();
   /*     while (accString.contains("a") || accString.contains("b") || accString.contains("c") || accString.contains("d") || accString.contains("e") || accString.contains("f") || accString.contains("g") || accString.contains("h") || accString.contains("i") || accString.contains("j") || accString.contains("k") || accString.contains("l") || accString.contains("m") || accString.contains("n") || accString.contains("o") || accString.contains("p") || accString.contains("q") || accString.contains("r") || accString.contains("s") || accString.contains("t") || accString.contains("u") || accString.contains("v") || accString.contains("w") || accString.contains("x") || accString.contains("y") || accString.contains("z") || accString.contains("A") || accString.contains("B") || accString.contains("C") || accString.contains("D") || accString.contains("E") || accString.contains("F") || accString.contains("G") || accString.contains("H") || accString.contains("I") || accString.contains("J") || accString.contains("K") || accString.contains("L") || accString.contains("M") || accString.contains("N") || accString.contains("O") || accString.contains("P") || accString.contains("Q") || accString.contains("R") || accString.contains("S") || accString.contains("T") || accString.contains("U") || accString.contains("V") || accString.contains("W") || accString.contains("X") || accString.contains("Y") || accString.contains("Z")){*/
        while(!NumberUtils.isParsable(accString)){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the account identification number:");
            accString = input.nextLine();
        }
        int accInt = Integer.parseInt(accString);
        if(accountMap.containsKey(accInt)) {
            Account account = accountMap.get(accInt);
            List<Opportunity> opportunityList = account.getOpportunityList();
            for (Opportunity opportunity : opportunityList) {
                System.out.println(opportunity.toString());
            }
        }else{
            throw new NoSuchFieldException("Account not found.");
        }
    }

    public static void showContactList() throws NoSuchFieldException {
        System.out.println("Enter the identification number of the account you want to see the list of contacts of:");
        String accString = input.nextLine();
        /*  while (accString.contains("a") || accString.contains("b") || accString.contains("c") || accString.contains("d") || accString.contains("e") || accString.contains("f") || accString.contains("g") || accString.contains("h") || accString.contains("i") || accString.contains("j") || accString.contains("k") || accString.contains("l") || accString.contains("m") || accString.contains("n") || accString.contains("o") || accString.contains("p") || accString.contains("q") || accString.contains("r") || accString.contains("s") || accString.contains("t") || accString.contains("u") || accString.contains("v") || accString.contains("w") || accString.contains("x") || accString.contains("y") || accString.contains("z") || accString.contains("A") || accString.contains("B") || accString.contains("C") || accString.contains("D") || accString.contains("E") || accString.contains("F") || accString.contains("G") || accString.contains("H") || accString.contains("I") || accString.contains("J") || accString.contains("K") || accString.contains("L") || accString.contains("M") || accString.contains("N") || accString.contains("O") || accString.contains("P") || accString.contains("Q") || accString.contains("R") || accString.contains("S") || accString.contains("T") || accString.contains("U") || accString.contains("V") || accString.contains("W") || accString.contains("X") || accString.contains("Y") || accString.contains("Z")){*/
        while(!NumberUtils.isParsable(accString)){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the account identification number:");
            accString = input.nextLine();
        }
        int accInt = Integer.parseInt(accString);
        if (accountMap.containsKey(accInt)) {
            Account account = accountMap.get(accInt);
            List<Contact> contactList = account.getContactList();
            for (Contact contact : contactList) {
                System.out.println(contact.toString());
            }
        }else{
            throw new NoSuchFieldException("Account not found.");
        }
    }
    public static void showAccounts(){
        for(Map.Entry<Integer, Account> accountEntry : accountMap.entrySet()){
            System.out.println(accountEntry.getValue());
        }
    }

    public static void showLeadById() throws NoSuchFieldException {
        System.out.println("Enter the identification number of the Lead you want to see:"); //hay que hacer catch
        String idString = input.nextLine();
    /*    while (idString.contains("a") || idString.contains("b") || idString.contains("c") || idString.contains("d") || idString.contains("e") || idString.contains("f") || idString.contains("g") || idString.contains("h") || idString.contains("i") || idString.contains("j") || idString.contains("k") || idString.contains("l") || idString.contains("m") || idString.contains("n") || idString.contains("o") || idString.contains("p") || idString.contains("q") || idString.contains("r") || idString.contains("s") || idString.contains("t") || idString.contains("u") || idString.contains("v") || idString.contains("w") || idString.contains("x") || idString.contains("y") || idString.contains("z") || idString.contains("A") || idString.contains("B") || idString.contains("C") || idString.contains("D") || idString.contains("E") || idString.contains("F") || idString.contains("G") || idString.contains("H") || idString.contains("I") || idString.contains("J") || idString.contains("K") || idString.contains("L") || idString.contains("M") || idString.contains("N") || idString.contains("O") || idString.contains("P") || idString.contains("Q") || idString.contains("R") || idString.contains("S") || idString.contains("T") || idString.contains("U") || idString.contains("V") || idString.contains("W") || idString.contains("X") || idString.contains("Y") || idString.contains("Z")){*/
        while(!NumberUtils.isParsable(idString)){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the lead identification number:");
            idString = input.nextLine();
        }
        int idInt = Integer.parseInt(idString);
        if (leadMap.containsKey(idInt)){
            System.out.println(leadMap.get(idInt));
        } else {
            throw new NoSuchFieldException("Lead does not exist.");
        }
    }

    public static void changeStatus( Map<Integer, Opportunity> oppMap) {
        System.out.println("Select opportunity by identification number:");
        String oppId = input.nextLine();
        while(!NumberUtils.isParsable(oppId)){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the opportunity's identification number:");
            oppId = input.nextLine();
        }
        int oppIdInt = Integer.parseInt(oppId);
        if (!oppMap.containsKey(oppIdInt)) {
            System.err.println("Lead not found.");
            changeStatus(oppMap);
        }
        System.out.println("Choose new status:");
        System.out.println("1. OPEN");
        System.out.println("2. CLOSED_WON");
        System.out.println("3. CLOSED_LOST");
        String status = input.nextLine();
        switch (status){
            case "1":
                oppMap.get(oppIdInt).setStatus(OppStatus.OPEN);
            break;
            case "2":
                oppMap.get(oppIdInt).setStatus(OppStatus.CLOSED_WON);
            break;
            case "3":
                oppMap.get(oppIdInt).setStatus(OppStatus.CLOSED_LOST);
                break;
            default:
                System.err.println("Please, enter a valid option.");
                changeStatus(oppMap);
        }
    }

    public class DropDown {
        public static void main(String[] args) {
            String[] optionsToChoose = {"Account", "Contact", "Lead", "Opportunity"};

            String getOption = (String) JOptionPane.showInputDialog(
                    null,
                    "What do you want to do?",
                    "Choose Option",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsToChoose,
                    optionsToChoose[4]);

            System.out.println("Your chosen option: " + getOption);
        }
    }
}
