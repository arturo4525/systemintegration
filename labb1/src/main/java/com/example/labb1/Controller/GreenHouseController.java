package com.example.labb1.Controller;
import com.example.labb1.Dao.GreenHouseDatabase;
import com.example.labb1.Model.MyClimateData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreenHouseController {

    GreenHouseDatabase myDatabase = new GreenHouseDatabase();

    @RequestMapping("/") // för att få ut senaste värdet
    public MyClimateData returndata(){
        return myDatabase.getAllClimate();
    }

    @RequestMapping("/addpower/{price}") // för att lägga till priset
    public String addPowerPrice(@PathVariable double price) {
        String respons = myDatabase.addPower(price);
        return respons;
    }

    @RequestMapping("/getpowerprice") // Hämta ut priset.
    public String returnPowerPrice(){
        return myDatabase.getPowerPrice();
    }
}
