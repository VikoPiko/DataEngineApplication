import com.viko.Customer;
import com.viko.exception.ParsingException;
import com.viko.parser.GenericParser;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {
    @Test
    void shouldParseFile() throws Exception{
        Path file = Files.createTempFile("customers", ".txt");
        Files.writeString(file, "Viko, viko@mail.com,23\nViko2,viko2@mail,32");

        GenericParser parser = new GenericParser();

        List<? extends Customer> result = parser.parse(file.toString(), Customer.class);

        assertEquals(2, result.size());
    }
    @Test
    void shouldIgnoreEmptyLines() throws Exception {
        Path file = Files.createTempFile("customers", ".txt");
        Files.writeString(file, "\n\nJohn,john@mail.com,25");

        GenericParser parser = new GenericParser();
        List<? extends Customer> result = parser.parse(file.toString(), Customer.class);

        assertEquals(1, result.size());
    }

    @Test
    void shouldThrowParsingExceptionOnInvalidNumber() throws Exception {
        Path file = Files.createTempFile("customers", ".txt");
        Files.writeString(file, "John,john@mail.com,NOT_A_NUMBER");

        GenericParser parser = new GenericParser();

        assertThrows(
                ParsingException.class,
                () -> parser.parse(file.toString(), Customer.class)
        );
    }
}
