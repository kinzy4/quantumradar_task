/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quantumradar;

/**
 *
 * @author Kinzy
 */
public class SeatbeltRule implements Rule {

    @Override
    public Violation check(Observation observation) {

        if (!observation.isSeatbeltFastened()) {

            return new Violation(
                    "Seatbelt Rule",
                    "Seatbelt not fastened",
                    100
            );
        }

        return null;
    }

    @Override
    public String getRuleName() {
        return "Seatbelt Rule";
    }
}