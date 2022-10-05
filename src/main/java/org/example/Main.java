package org.example;
import org.apache.commons.lang3.math.NumberUtils;
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
    private static Scanner input = new Scanner (System.in);
    private static Contact decisionMaker;
    private static Opportunity opportunity;
    private static Account account;

    public static void main(String[] args){

    }



    public static Map<String, String> getLeadInfo(){
        Map<String, String> leadInfo = new HashMap<String, String>();

        System.out.println("Introduce name:");
        String name = input.nextLine();
        leadInfo.put("name", name);
        System.out.println("Introduce telephone number:"); //hay que hacer catch
        String phone = input.nextLine();
 /*       while (phone.contains("a") || phone.contains("b") || phone.contains("c") || phone.contains("d") || phone.contains("e") || phone.contains("f") || phone.contains("g") || phone.contains("h") || phone.contains("i") || phone.contains("j") || phone.contains("k") || phone.contains("l") || phone.contains("m") || phone.contains("n") || phone.contains("o") || phone.contains("p") || phone.contains("q") || phone.contains("r") || phone.contains("s") || phone.contains("t") || phone.contains("u") || phone.contains("v") || phone.contains("w") || phone.contains("x") || phone.contains("y") || phone.contains("z") || phone.contains("A") || phone.contains("B") || phone.contains("C") || phone.contains("D") || phone.contains("E") || phone.contains("F") || phone.contains("G") || phone.contains("H") || phone.contains("I") || phone.contains("J") || phone.contains("K") || phone.contains("L") || phone.contains("M") || phone.contains("N") || phone.contains("O") || phone.contains("P") || phone.contains("Q") || phone.contains("R") || phone.contains("S") || phone.contains("T") || phone.contains("U") || phone.contains("V") || phone.contains("W") || phone.contains("X") || phone.contains("Y") || phone.contains("Z")){*/
        while(!NumberUtils.isParsable(phone)){
            System.err.println("Must enter a phone number.");
            System.out.println("Please, introduce telephone number:");
            phone = input.nextLine();
        }
        leadInfo.put("phone", phone);
        //int phoneNumber = Integer.parseInt(phone);
        System.out.println("Introduce email address:");
        String email = input.nextLine();
        leadInfo.put("email", email);
        System.out.println("Introduce the name of the company:");
        String companyName = input.nextLine();
        leadInfo.put("companyName", companyName);

        return leadInfo;

        //Lead lead = new Lead (name, phoneNumber, email, companyName);
        //leadMap.put(lead.getId(), lead);
    }

    public static void createLead(Map<String, String> leadInfo){
        Lead lead = new Lead (leadInfo.get("name"), Integer.parseInt(leadInfo.get("phone")), leadInfo.get("email"), leadInfo.get("companyName"));
        leadMap.put(lead.getId(), lead);
    }

    public static void showLeadMap(){
           for(Map.Entry<Integer, Lead> leadEntry : leadMap.entrySet()){
               System.out.println(leadEntry.getValue());
           }
    }

    public static void createDecisionMaker() {
        System.out.println("Enter the identification number of the lead you want to convert:"); //hay que hacer catch
        String idString = input.nextLine();
        /* while (idString.contains("a") || idString.contains("b") || idString.contains("c") || idString.contains("d") || idString.contains("e") || idString.contains("f") || idString.contains("g") || idString.contains("h") || idString.contains("i") || idString.contains("j") || idString.contains("k") || idString.contains("l") || idString.contains("m") || idString.contains("n") || idString.contains("o") || idString.contains("p") || idString.contains("q") || idString.contains("r") || idString.contains("s") || idString.contains("t") || idString.contains("u") || idString.contains("v") || idString.contains("w") || idString.contains("x") || idString.contains("y") || idString.contains("z") || idString.contains("A") || idString.contains("B") || idString.contains("C") || idString.contains("D") || idString.contains("E") || idString.contains("F") || idString.contains("G") || idString.contains("H") || idString.contains("I") || idString.contains("J") || idString.contains("K") || idString.contains("L") || idString.contains("M") || idString.contains("N") || idString.contains("O") || idString.contains("P") || idString.contains("Q") || idString.contains("R") || idString.contains("S") || idString.contains("T") || idString.contains("U") || idString.contains("V") || idString.contains("W") || idString.contains("X") || idString.contains("Y") || idString.contains("Z")){*/
        while (!NumberUtils.isParsable(idString)) {
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the identification number:");
            idString = input.nextLine();
        }
        int idInt = Integer.parseInt(idString);
        if (!leadMap.containsKey(idInt)) {
            System.err.println("Lead not found.");
            createDecisionMaker();
        }
        Lead lead = leadMap.get(idInt);
        decisionMaker = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
        leadMap.remove(idInt);
        createOpportunity();
    }

   public static void createOpportunity() {
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
               createOpportunity();
       }
       System.out.println("Number of products:");
       String numberOfProducts = input.nextLine();
       /*    while (numberOfProducts.contains("a") || numberOfProducts.contains("b") || numberOfProducts.contains("c") || numberOfProducts.contains("d") || numberOfProducts.contains("e") || numberOfProducts.contains("f") || numberOfProducts.contains("g") || numberOfProducts.contains("h") || numberOfProducts.contains("i") || numberOfProducts.contains("j") || numberOfProducts.contains("k") || numberOfProducts.contains("l") || numberOfProducts.contains("m") || numberOfProducts.contains("n") || numberOfProducts.contains("o") || numberOfProducts.contains("p") || numberOfProducts.contains("q") || numberOfProducts.contains("r") || numberOfProducts.contains("s") || numberOfProducts.contains("t") || numberOfProducts.contains("u") || numberOfProducts.contains("v") || numberOfProducts.contains("w") || numberOfProducts.contains("x") || numberOfProducts.contains("y") || numberOfProducts.contains("z") || numberOfProducts.contains("A") || numberOfProducts.contains("B") || numberOfProducts.contains("C") || numberOfProducts.contains("D") || numberOfProducts.contains("E") || numberOfProducts.contains("F") || numberOfProducts.contains("G") || numberOfProducts.contains("H") || numberOfProducts.contains("I") || numberOfProducts.contains("J") || numberOfProducts.contains("K") || numberOfProducts.contains("L") || numberOfProducts.contains("M") || numberOfProducts.contains("N") || numberOfProducts.contains("O") || numberOfProducts.contains("P") || numberOfProducts.contains("Q") || numberOfProducts.contains("R") || numberOfProducts.contains("S") || numberOfProducts.contains("T") || numberOfProducts.contains("U") || numberOfProducts.contains("V") || numberOfProducts.contains("W") || numberOfProducts.contains("X") || numberOfProducts.contains("Y") || numberOfProducts.contains("Z")){*/
       while (!NumberUtils.isParsable(numberOfProducts)) {
           System.err.println("The quantity must be written in numbers.");
           System.out.println("Please, enter the number of products:");
           numberOfProducts = input.nextLine();
       }
       int quantity = Integer.parseInt(numberOfProducts);
       OppStatus status = OppStatus.OPEN;
       opportunity = new Opportunity(productType, decisionMaker, quantity, status);
       oppMap.put(opportunity.getId(), opportunity);
       createAccount();
   }




public static void createAccount(){
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
                createAccount();
        }
        System.out.println("Number of employees:");
        String numEmployees = input.nextLine();
       /* while (numEmployees.contains("a") || numEmployees.contains("b") || numEmployees.contains("c") || numEmployees.contains("d") || numEmployees.contains("e") || numEmployees.contains("f") || numEmployees.contains("g") || numEmployees.contains("h") || numEmployees.contains("i") || numEmployees.contains("j") || numEmployees.contains("k") || numEmployees.contains("l") || numEmployees.contains("m") || numEmployees.contains("n") || numEmployees.contains("o") || numEmployees.contains("p") || numEmployees.contains("q") || numEmployees.contains("r") || numEmployees.contains("s") || numEmployees.contains("t") || numEmployees.contains("u") || numEmployees.contains("v") || numEmployees.contains("w") || numEmployees.contains("x") || numEmployees.contains("y") || numEmployees.contains("z") || numEmployees.contains("A") || numEmployees.contains("B") || numEmployees.contains("C") || numEmployees.contains("D") || numEmployees.contains("E") || numEmployees.contains("F") || numEmployees.contains("G") || numEmployees.contains("H") || numEmployees.contains("I") || numEmployees.contains("J") || numEmployees.contains("K") || numEmployees.contains("L") || numEmployees.contains("M") || numEmployees.contains("N") || numEmployees.contains("O") || numEmployees.contains("P") || numEmployees.contains("Q") || numEmployees.contains("R") || numEmployees.contains("S") || numEmployees.contains("T") || numEmployees.contains("U") || numEmployees.contains("V") || numEmployees.contains("W") || numEmployees.contains("X") || numEmployees.contains("Y") || numEmployees.contains("Z")){*/
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

    public static void createOpportunityInAccount(){
        System.out.println("Enter the identification number of the company account this opportunity is attached to:");
        String idAccString = input.nextLine();
        /*    while (idAccString.contains("a") || idAccString.contains("b") || idAccString.contains("c") || idAccString.contains("d") || idAccString.contains("e") || idAccString.contains("f") || idAccString.contains("g") || idAccString.contains("h") || idAccString.contains("i") || idAccString.contains("j") || idAccString.contains("k") || idAccString.contains("l") || idAccString.contains("m") || idAccString.contains("n") || idAccString.contains("o") || idAccString.contains("p") || idAccString.contains("q") || idAccString.contains("r") || idAccString.contains("s") || idAccString.contains("t") || idAccString.contains("u") || idAccString.contains("v") || idAccString.contains("w") || idAccString.contains("x") || idAccString.contains("y") || idAccString.contains("z") || idAccString.contains("A") || idAccString.contains("B") || idAccString.contains("C") || idAccString.contains("D") || idAccString.contains("E") || idAccString.contains("F") || idAccString.contains("G") || idAccString.contains("H") || idAccString.contains("I") || idAccString.contains("J") || idAccString.contains("K") || idAccString.contains("L") || idAccString.contains("M") || idAccString.contains("N") || idAccString.contains("O") || idAccString.contains("P") || idAccString.contains("Q") || idAccString.contains("R") || idAccString.contains("S") || idAccString.contains("T") || idAccString.contains("U") || idAccString.contains("V") || idAccString.contains("W") || idAccString.contains("X") || idAccString.contains("Y") || idAccString.contains("Z")){*/
        while (!NumberUtils.isParsable(idAccString)) {
            System.err.println("The identification must be a number.");
            System.out.println("Please, enter the account identification number:");
            idAccString = input.nextLine();
        }
        int idAccInt = Integer.parseInt(idAccString);
        if (!accountMap.containsKey(idAccInt)) {
            System.err.println("Account not found.");
            createOpportunityInAccount();
        }
        account = accountMap.get(idAccInt);
        createDecisionMakerInAccount();
    }

        public static void createDecisionMakerInAccount() {
            System.out.println("Enter the identification number of the lead you want to convert:");
            String idString = input.nextLine();
            /*   while (idString.contains("a") || idString.contains("b") || idString.contains("c") || idString.contains("d") || idString.contains("e") || idString.contains("f") || idString.contains("g") || idString.contains("h") || idString.contains("i") || idString.contains("j") || idString.contains("k") || idString.contains("l") || idString.contains("m") || idString.contains("n") || idString.contains("o") || idString.contains("p") || idString.contains("q") || idString.contains("r") || idString.contains("s") || idString.contains("t") || idString.contains("u") || idString.contains("v") || idString.contains("w") || idString.contains("x") || idString.contains("y") || idString.contains("z") || idString.contains("A") || idString.contains("B") || idString.contains("C") || idString.contains("D") || idString.contains("E") || idString.contains("F") || idString.contains("G") || idString.contains("H") || idString.contains("I") || idString.contains("J") || idString.contains("K") || idString.contains("L") || idString.contains("M") || idString.contains("N") || idString.contains("O") || idString.contains("P") || idString.contains("Q") || idString.contains("R") || idString.contains("S") || idString.contains("T") || idString.contains("U") || idString.contains("V") || idString.contains("W") || idString.contains("X") || idString.contains("Y") || idString.contains("Z")){*/
            while (!NumberUtils.isParsable(idString)) {
                System.err.println("The identification must be a number.");
                System.out.println("Please, enter the lead identification number:");
                idString = input.nextLine();
            }
            int idInt = Integer.parseInt(idString);
            if (!leadMap.containsKey(idInt)) {
                System.err.println("Lead not found.");
                createDecisionMakerInAccount();
            }
            Lead lead = leadMap.get(idInt);
            decisionMaker = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
            leadMap.remove(idInt);
            createOppInAccount();
        }

        public static void createOppInAccount(){
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
                createOppInAccount();
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

    public static void changeStatus() throws NoSuchFieldException {
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
            changeStatus();
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
                changeStatus();
        }
    }
}