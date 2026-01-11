package com.viko;

import com.viko.annotations.*;

@FileSource(delimiter = ",")
public class Customer {

    @Column(index = 0)
    @NotNull(message = "name required")
    public String name;


    @Column(index = 1)
    @Regex(pattern = ".+@.+\\..+", message = "invalid email")
    public String email;


    public Customer() {}

    @Column(index = 2)
    @Range(min = 18, max = 100, message = "age required")
    public int age;
}
