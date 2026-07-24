/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quantumradar;

import java.time.LocalDate;

/**
 *
 * @author Kinzy
 */
public class Main {

    public static void main(String[] args) {

        QuRadar radar = new QuRadar();

        
        radar.addRule(new SpeedRule());
        radar.addRule(new SeatbeltRule());

         
        radar.observe(
                new Observation(
                        "ABC1234",
                        LocalDate.now(),
                        CarType.PRIVATE,
                        94,
                        false
                )
        );

       
        radar.observe(
                new Observation(
                        "TRK555",
                        LocalDate.now(),
                        CarType.TRUCK,
                        70,
                        true
                )
        );

      
        radar.observe(
                new Observation(
                        "CAR222",
                        LocalDate.now(),
                        CarType.PRIVATE,
                        75,
                        false
                )
        );

       
        radar.observe(
                new Observation(
                        "XYZ999",
                        LocalDate.now(),
                        CarType.BUS,
                        60,
                        true
                )
        );

        radar.getAllPossibleFines();

        radar.printViolatedRulesCount();

    }

}