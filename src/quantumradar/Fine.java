/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quantumradar;

import java.util.List;

/**
 *
 * @author Kinzy
 */
public class Fine {

    private String plateNumber;
    private List<Violation> violations;

    public Fine(String plateNumber, List<Violation> violations) {
        this.plateNumber = plateNumber;
        this.violations = violations;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public int getTotalAmount() {

        int total = 0;

        for (Violation violation : violations) {
            total += violation.getFee();
        }

        return total;
    }

    public void printFine() {

        System.out.println("Traffic fine for car " + plateNumber);
        System.out.println("Total amount: " + getTotalAmount() + " EGP");
        System.out.println("Violations:");

        for (Violation violation : violations) {
            System.out.println("- "
                    + violation.getDescription()
                    + " : "
                    + violation.getFee()
                    + " EGP");
        }

        System.out.println();
    }
}