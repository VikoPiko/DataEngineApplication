package com.viko;

import com.viko.annotations.Column;
import com.viko.annotations.FileSource;
import com.viko.annotations.NotNull;
import com.viko.annotations.Range;

import java.time.LocalDate;

@FileSource(delimiter = "|")
public class Transaction {

    @Column(index = 0)
    @NotNull(message = "Id is required")
    private String tID;

    @Column(index = 1)
    @Range(min=0, max=1_000_000, message="Invalid Amount")
    private double amount;

    @Column(index = 2)
    private LocalDate date;

}