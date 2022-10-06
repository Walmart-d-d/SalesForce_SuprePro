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
    private static Lead lead;



    public static void main(String[] args) throws NoSuchFieldException {
    mainMenu();
    }
    public static void mainMenu() throws NoSuchFieldException {
        System.out.println("1. Leads and opportunities");
        System.out.println("2. Accounts");
        System.out.println("3. Exit");
        String option = input.nextLine();
        switch (option){
            case "1":
                leadMenu();
                break;
            case "2":
                accountMenu();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.err.println("Invalid option");
                System.out.println("Please, enter a valid option");
                mainMenu();
        }
    }
    public static void leadMenu() throws NoSuchFieldException {
        System.out.println("1. Create Lead");
        System.out.println("2. Show all Leads");
        System.out.println("3. Show Lead by Identification Number");
        System.out.println("4. Show all Opportunities");
        System.out.println("5. Convert Lead into Opportunity");
        System.out.println("6. Change status of an Opportunity");
        System.out.println("7. Go back");
        String option = input.nextLine();
        switch (option){
            case "1":
                Map<String, String> leadInfo = getLeadInfo();
                Lead lead = createLead(leadInfo);
                leadMap.put(lead.getId(), lead);
                System.out.println("A new Lead has been created:");
                System.out.println(lead.toString());
                leadMenu();
                break;
            case "2":
                showLeadMap();
                leadMenu();
                break;
            case "3":
                showLeadById();
                leadMenu();
                break;
            case "4":
                showAllOpportunities();
                leadMenu();
                break;
            case "5":
                createOppMenu();
                break;
            case "6":
                changeStatus(oppMap);
                leadMenu();
                break;
            case "7":
                mainMenu();
                break;
            default:
                System.err.println("Invalid option");
                System.out.println("Please, enter a valid option");
                leadMenu();
        }
    }

    public static void createOppMenu() throws NoSuchFieldException {
        System.out.println("1. Create a new Opportunity in a new Account");
        System.out.println("2. Show all Accounts");
        System.out.println("3. Create a new Opportunity in an existing Account");
        System.out.println("4. Go back");
        String option = input.nextLine();
        switch(option) {
            case "1":
                getLeadToConvert(leadMap);
                createDecisionMaker(lead);
                createOpportunity(oppMap);
                mainMenu();
                break;
            case "2":
                showAccounts();
                createOppMenu();
                break;
            case "3":
                getLeadToConvert(leadMap);
                createDecisionMaker(lead);
                createOpportunityInAccount(accountMap);
                createOppInAccount(account);
                mainMenu();
                break;
            case "4":
                leadMenu();
                break;
            default:
                System.err.println("Invalid option");
                System.out.println("Please, enter a valid option");
                createOppMenu();
        }
    }

    public static void accountMenu() throws NoSuchFieldException {
        System.out.println("1. Show all Accounts");
        System.out.println("2. Show list of Opportunities in an Account");
        System.out.println("3. Show list of Contacts in an Account");
        System.out.println("4. Go back");
        String option = input.nextLine();
        switch (option){
            case "1":
                showAccounts();
                accountMenu();
                break;
            case "2":
                showOpportunityList();
                accountMenu();
                break;
            case "3":
                showContactList();
                accountMenu();
                break;
            case "4":
                mainMenu();
            default:
                System.err.println("Invalid option");
                System.out.println("Please, enter a valid option");
                accountMenu();
        }
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


    public static void showLeadMap(){
           for(Map.Entry<Integer, Lead> leadEntry : leadMap.entrySet()){
               System.out.println(leadEntry.getValue());
           }
    }

    public static Lead getLeadToConvert(Map<Integer, Lead> leadMap) {
        System.out.println("Enter the identification number of the lead you want to convert:");
        String idString = input.nextLine();

        while (!NumberUtils.isParsable(idString)) {
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the identification number:");
            idString = input.nextLine();
        }
        int idInt = Integer.parseInt(idString);

        while (!leadMap.containsKey(idInt)) {
            System.err.println("Lead not found.");
            System.out.println("Enter the identification number of the lead you want to convert:");
            idString = input.nextLine();
            while (!NumberUtils.isParsable(idString)) {
                System.err.println("The identification must be a number.");
                System.out.println("Please, enter the identification number:");
                idString = input.nextLine();
            }
            idInt = Integer.parseInt(idString);
        }
        lead = leadMap.get(idInt);
        leadMap.remove(idInt);
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
       createAccount(accountMap);
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

    public static void changeStatus(Map<Integer, Opportunity> oppMap) {
        System.out.println("Select opportunity by identification number:");
        String oppId = input.nextLine();
        while(!NumberUtils.isParsable(oppId)){
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the opportunity's identification number:");
            oppId = input.nextLine();
        }
        int oppIdInt = Integer.parseInt(oppId);
        if (!oppMap.containsKey(oppIdInt)) {
            System.err.println("Opportunity not found.");
            changeStatus(oppMap);
        }
        System.out.println("Choose new status:");
        System.out.println("1. OPEN");
        System.out.println("2. CLOSED_WON");
        System.out.println("3. CLOSED_LOST");
        String status = input.nextLine();
        switch (status) {
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
        System.out.println("New status is "+oppMap.get(oppIdInt).getStatus());
    }
}