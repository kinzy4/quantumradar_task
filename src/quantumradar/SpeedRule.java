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
public class SpeedRule implements Rule {

    @Override
    public Violation check(Observation observation) {

        int maxSpeed = 80;

        if (observation.getCarType() == CarType.TRUCK) {
            maxSpeed = 60;
        }

        if (observation.getSpeed() > maxSpeed) {

            return new Violation(
                "Speed Rule",
                "speed of " + observation.getSpeed()
                        + " exceeded max allowed " + maxSpeed,
                300
        );
        }

        return null;
    }

    @Override
    public String getRuleName() {
        return "Speed Rule";
    }
}
