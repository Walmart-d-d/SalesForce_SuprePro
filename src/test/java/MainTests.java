import org.example.Main;
import org.example.classes.Lead;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTests {


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



}
