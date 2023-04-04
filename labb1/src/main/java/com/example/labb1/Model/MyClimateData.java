package com.example.labb1.Model;

import lombok.Data;

@Data
public class MyClimateData { // Objekt för att lagra ner motsvarande rad från databasen.// mall, objektklass.
    int id;
    double temp;
    int humidity;
    String created;

    public MyClimateData(){}

}
