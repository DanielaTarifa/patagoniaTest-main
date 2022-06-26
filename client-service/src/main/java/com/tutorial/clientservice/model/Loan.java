package com.tutorial.clientservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    private Double amount;//Double amount -String brand
    private String type;//String type -String model
    private int clientId;
}
