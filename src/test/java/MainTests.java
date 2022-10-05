import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTests {

    @Test
    @DisplayName("Get lead info from terminal if valid inputs - works ok ")
    void getLeadInfo_ValidInputs_worksOK() {
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
    void getLeadInfo_PhoneNotParsable_worksOK() {
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

}
