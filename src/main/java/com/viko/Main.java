package com.viko;

import com.viko.parser.GenericParser;
import com.viko.validation.Validator;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {

        GenericParser parser = new GenericParser();

        List<Transaction> transactions =
                parser.parse("transactions.txt", Transaction.class);

        Validator validator = new Validator();

        Map<Transaction, Set<String>> errors =
                validator.validate(transactions);

        if (errors.isEmpty()) {
            System.out.println("All transactions are valid!");
        } else {
            errors.forEach((tx, errs) -> {
                System.out.println("Errors for transaction:");
                errs.forEach(System.out::println);
            });
        }
    }
}
