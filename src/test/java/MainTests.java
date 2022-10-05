import org.example.Main;
import org.example.classes.Account;
import org.example.classes.Contact;
import org.example.classes.Lead;
import org.example.classes.Opportunity;
import org.example.enums.IndustryOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTests {

    private Map<Integer, Lead> leadMap;
    private Map<Integer, Opportunity> oppMap;
    private Map<Integer, Account> accountMap;
    private Account account;
    private static Contact decisionMaker;

    @BeforeEach
    void setUp() {
        Lead lead1 = new Lead("Maria", 678888999, "maria@email.com", "ironhack");
        Lead lead2 = new Lead("Miguel", 668766787, "miguel@email.com", "toyota");

        leadMap = Map.of(
                lead1.getId(), lead1,
                lead2.getId(), lead2
            );

        oppMap = new HashMap<>();
        Account account1 = new Account(IndustryOption.ECOMMERCE, 2, "Madrid", "Spain", new ArrayList<>(), new ArrayList<>());
        accountMap = new HashMap<>();
        accountMap.put(account1.getId(), account1);
        account = null;
        decisionMaker = null;
    }

    @Test
    @DisplayName("Get lead info from terminal if valid inputs - works ok ")
    void getLeadInfo_ValidInputs_WorksOK() {
        String userInput = String.format("Antonia%s633245565%santoniavega@gmail.com%sMovistar",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        Map<String, String> result = Main.getLeadInfo();

        assertEquals("Antonia", result.get("name"));
        assertEquals("633245565", result.get("phone"));
        assertEquals("antoniavega@gmail.com", result.get("email"));
        assertEquals("Movistar", result.get("companyName"));
    }

    @Test
    @DisplayName("Get lead info from terminal if phone number input is not parsable - works ok ")
    void getLeadInfo_PhoneNotParsable_WorksOK() {
        String userInput = String.format("Antonia%sbanana%s633245565%santoniavega@gmail.com%sMovistar",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);
        Map<String, String> result = Main.getLeadInfo();

        assertEquals("Antonia", result.get("name"));
        assertEquals("633245565", result.get("phone"));
        assertEquals("antoniavega@gmail.com", result.get("email"));
        assertEquals("Movistar", result.get("companyName"));
    }

    @Test
    @DisplayName("Create Lead works ok")
    void createLead_WorksOK(){
        Map<String, String> leadInfo = Map.of(
                "name", "Tom",
                "phone", "678987678",
                "email", "Tom@email.com",
                "companyName", "Mercadona"
            );
        Lead lead = Main.createLead(leadInfo);
        assertEquals("Tom", lead.getName());
        assertEquals(678987678, lead.getPhoneNumber());
        assertEquals("Tom@email.com", lead.getEmail());
        assertEquals("Mercadona", lead.getCompanyName());
    }

    @Test
    @DisplayName("Get Lead to convert from terminal if id exists - works ok")
    void getLeadToConvert_IdExists_WorksOK(){

        String userInput = "1";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        Lead lead = Main.getLeadToConvert(leadMap);

        assertEquals(1, lead.getId());
        assertEquals("Maria", lead.getName());
    }

    @Test
    @DisplayName("Get Lead to convert from terminal if id doesn't exists - works ok")
    void getLeadToConvert_IdNotExists_WorksOK(){

        String userInput = String.format("5%s2",
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        Lead lead = Main.getLeadToConvert(leadMap);

        assertEquals(2, lead.getId());
        assertEquals("Miguel", lead.getName());
    }

    @Test
    @DisplayName("Remove from Lead Map - works ok")
    void removeFromLeadMap_WorksOk(){
        Main.removeFromLeadMap(1);
        assertEquals(2, leadMap.keySet().size());
    }

    @Test
    @DisplayName("Create opportunity - works ok")
    void createOpportunity_WorksOk(){
        String userInput = String.format("1%s1%s",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        Main.createOpportunity(oppMap);
        assertEquals(1, oppMap.keySet().size());
    }

    @Test
    @DisplayName("Create account - works ok")
    void createAccount_WorksOk(){
        String userInput = String.format("1%s1%sBarcelona%sSpain",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        Main.createAccount(accountMap);
        assertEquals(2, accountMap.keySet().size());
    }

    @Test
    @DisplayName("Create opportunity in account - works ok")
    void createOpportunityInAccount_WorksOk(){
        String userInput = "1";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        Account account = Main.createOpportunityInAccount(accountMap);

        assertEquals(1, account.getId());
    }

    @Test
    @DisplayName("Create decision maker in account - works ok")
    void createDecisionMakerInAccount_WorksOk(){
        String userInput = "1";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        Contact decisionMaker1 = Main.createDecisionMakerInAccount(leadMap);
        System.out.println(decisionMaker1.toString());

        assertEquals(1, decisionMaker1.getId());
    }





}
