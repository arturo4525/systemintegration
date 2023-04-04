package com.example.labb1.Model;

import lombok.Data;

@Data
public class PowerData { // powerobjekt/klass som innehåller värdet från tabellen. (Mall av tabellen)
    int id;
    double price;
    String created;

    public PowerData() {}
}
