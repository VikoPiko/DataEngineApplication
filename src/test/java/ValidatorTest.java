import com.viko.Customer;
import com.viko.validation.Validator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {

        @Test
        void shouldDetectValidationErrors() {
            Customer customer = new Customer();
            // name null
            customer.email = "invalid-email";
            customer.age = 20;

            Validator validator = new Validator();
            Map<Customer, Set<String>> errors =
                    validator.validate(List.of(customer));

            assertTrue(errors.containsKey(customer));
            assertEquals(2, errors.get(customer).size());
        }

        @Test
        void shouldPassValidObject() {
            Customer customer = new Customer();
            customer.name = "John";
            customer.email = "john@mail.com";
            customer.age = 30;

            Validator validator = new Validator();
            Map<Customer, Set<String>> errors =
                    validator.validate(List.of(customer));

            assertTrue(errors.isEmpty());
        }
}
