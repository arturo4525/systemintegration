package com.example.labb1.Dao;

import com.example.labb1.Model.MyClimateData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GreenHouseDatabase {
    public MyClimateData getAllClimate() {
        try(Connection con = DriverManager.getConnection( // Uppkopplingen till databasen
                "jdbc:mysql://localhost:3306/mygreenhouse?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true",
                "root",
                "HejHej123");
            Statement stmt =  con.createStatement();
            ResultSet rs = stmt.executeQuery("select id, temperature, humidity, created from greenhousedata;")) {
            // Skickar in en query till databasen med vad som ska hämtas ut. (select/insert/delete)
            MyClimateData mcd = null; // sätter till null för att komma åt och sedan returnera. Utanför while satsen.

            while (rs.next()) {
                mcd = new MyClimateData(); // skapar upp ett myclimatedata objekt, sedan sätter jag all data till rätt värde.
                mcd.setId(rs.getInt("id")); // Sätter in alla värden tils den kört igenom allt.
                mcd.setTemp(rs.getDouble("temperature"));
                mcd.setHumidity(rs.getInt("humidity"));
                mcd.setCreated(rs.getString("created"));
            }

            return mcd; // returnerar sista värdet i databasen.

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String addPower(double price) {
        try(Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mygreenhouse?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true",
                "root",
                "HejHej123"); // Uppkopling
            PreparedStatement prepStmt = con.prepareStatement("INSERT INTO power(price) VALUES(?)"); // Skriver vad vi vill ha/eller skicka in
        ) {

            prepStmt.setDouble(1, price); // Här skickas värdet in.
            prepStmt.execute(); // sen körs det.

            return "Your price is added"; // Returnerar om de gått bra.

        } catch (SQLException e) {
            return "Price was not added!"; // felhantering, returnerar om något gått fel.
        }
    }

    public String getPowerPrice() {
        try(Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mygreenhouse?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true",
                "root",
                "HejHej123"); // Uppkopplingen
            Statement stmt =  con.createStatement();
            ResultSet rs = stmt.executeQuery("select price from power;")) { // Hämtar ut priset.
            double price = 0; // För att kunna returnera de sista värdet sätter jag en double till 0. utanför while satsen.

            while (rs.next()) {
                price = rs.getDouble("price");
            }

            String result = "Power price: " + price + " Kr"; // returnerar en sträng samt priset.
            return result; // returnerar de sista värdet.

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
