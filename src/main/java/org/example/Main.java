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
        int idInt = Integer.parseInt(idString);
        Lead lead = leadMap.get(idInt);
        Contact decisionMaker = new Contact(lead.getName(),lead.getPhoneNumber(),lead.getEmail(),lead.getCompanyName());
        System.out.println("Choose product type:");
        System.out.println("1. Hybrid");
        System.out.println("2. Flatbed");
        System.out.println("3. Box");
        String productKey = input.nextLine();
        ProductType productType;
        if (productKey == "1"){
            productType = ProductType.HYBRID;
        } else if(productKey=="2"){
            productType = ProductType.FLATBED;
        } else if(productKey=="3"){
            productType = ProductType.BOX;
        } else {
            throw new IllegalArgumentException("Not a valid option."); //hay que devolver la pregunta
        }
        System.out.println("Number of products:"); //hay que hacer catch
        String numberOfProducts = input.nextLine();
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
                throw new IllegalArgumentException("Not valid option."); //hay que devolver la pregunta
        }
        System.out.println("Number of employees:"); //hay que hacer catch
        String numEmployees = input.nextLine();
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
        System.out.println("Enter the identification number of the company account this opportunity is attached to:"); // hay que hacer catch
        String idAccString = input.nextLine();
        int idAccInt = Integer.parseInt(idAccString);
        Account account = accountMap.get(idAccInt);
        System.out.println("Enter the identification number of the lead you want to convert:"); //hay que hacer catch
        String idString = input.nextLine();
        int idInt = Integer.parseInt(idString);
        Lead lead = leadMap.get(idInt);
        Contact decisionMaker = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
        System.out.println("Choose product type:");
        System.out.println("1. Hybrid");
        System.out.println("2. Flatbed");
        System.out.println("3. Box");
        String productKey = input.nextLine();
        ProductType productType;
        if (productKey == "1") {
            productType = ProductType.HYBRID;
        } else if (productKey == "2") {
            productType = ProductType.FLATBED;
        } else if (productKey == "3") {
            productType = ProductType.BOX;
        } else {
            throw new IllegalArgumentException("Not valid option."); //hay que devolver la pregunta
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
        for(Map.Entry<Integer, Opportunity> leadEntry : oppMap.entrySet()){
            System.out.println(leadEntry.getValue());
        }
    }

    public static void showOpportunityList(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the identification number of the account you want to see the list of opportunities of:"); //hay que hacer catch
        String accString = input.nextLine();
        int accInt = Integer.parseInt(accString);
        Account account = accountMap.get(accInt);
        List<Opportunity> opportunityList = account.getOpportunityList();
        for (Opportunity opportunity : opportunityList){
            System.out.println(opportunity.toString());
        }
    }

    public static void showContactList(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the identification number of the account you want to see the list of opportunities of:"); //hay que hacer catch
        String accString = input.nextLine();
        int accInt = Integer.parseInt(accString);
        Account account = accountMap.get(accInt);
        List<Contact> contactList = account.getContactList();
        for (Contact contact : contactList){
            System.out.println(contact.toString());
        }
    }
}