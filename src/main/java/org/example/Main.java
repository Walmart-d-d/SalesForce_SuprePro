package org.example;

import org.example.classes.Contact;
import org.example.classes.Lead;
import org.example.classes.Opportunity;
import org.example.enums.OppStatus;
import org.example.enums.ProductType;

import java.util.*;

public class Main {

    private static List<Contact> contactList = new ArrayList<>();
    private static Map<Integer, Lead> leadMap = new HashMap<>();
    private static Map<Integer, Opportunity> oppMap = new HashMap<>();

    public static void main(String[] args) {
        createLead();
        createLead();
        showLeadMap();
    }
    public static void createLead(){
        Scanner input = new Scanner (System.in);
        System.out.println("Introduce name:");
        String name = input.nextLine();
        System.out.println("Introduce telephone number:");
        String phone = input.nextLine();
        int phoneNumber = Integer.parseInt(phone);
        System.out.println("Introduce email address:");
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

    public void createOpportunity(Lead lead){
        Contact decisionMaker = new Contact(lead.getName(),lead.getPhoneNumber(),lead.getEmail(),lead.getCompanyName());
        Scanner input = new Scanner (System.in);
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
            throw new IllegalArgumentException("Not valid option.");
        }
        System.out.println("Number of products:");
        String numberOfProducts = input.nextLine();
        int quantity = Integer.parseInt(numberOfProducts);
        OppStatus status = OppStatus.OPEN;
        Opportunity opportunity = new Opportunity(productType, decisionMaker, quantity, status);
        oppMap.put(opportunity.getId(), opportunity);
    }

}