/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quantumradar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kinzy
 */

/*
 * Quantum Radar System
 *
 * This system receives observations from a physical radar.
 * Each observation contains:
 * - Plate number
 * - Date
 * - Car type (Private, Truck, Bus)
 * - Speed
 * - Seatbelt status
 *
 * The radar checks every observation against a list of traffic rules.
 * If any rule is violated, a traffic fine is generated containing
 * all violations and their fees.
 *
 * The design is extensible because new rules can be added by
 * implementing the Rule interface without changing this class.
 *
 * AI Model Used:
 * Rule-Based Expert System (No Machine Learning).
 */

public class QuRadar {

    private List<Rule> rules;
    private List<Fine> fines;

    public QuRadar() {
        rules = new ArrayList<>();
        fines = new ArrayList<>();
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void observe(Observation observation) {

        List<Violation> violations = new ArrayList<>();

        for (Rule rule : rules) {

            Violation violation = rule.check(observation);

            if (violation != null) {
                violations.add(violation);
            }
        }

        if (!violations.isEmpty()) {

            Fine fine = new Fine(
                    observation.getPlateNumber(),
                    violations
            );

            fines.add(fine);

            fine.printFine();
        }
    }

    // Required in the task
    public void getAllPossibleFines() {

        System.out.println("===== All Fines =====");

        for (Fine fine : fines) {
            System.out.println(
                    fine.getPlateNumber()
                    + " -> "
                    + fine.getTotalAmount()
                    + " EGP"
            );
        }

        System.out.println();
    }

    // Required in the task
    public void printViolatedRulesCount() {

        Map<String, Integer> counts = new HashMap<>();

        for (Fine fine : fines) {

            for (Violation violation : fine.getViolations()) {

                String rule = violation.getRuleName();

                counts.put(rule, counts.getOrDefault(rule, 0) + 1);
            }
        }

        System.out.println("===== Violated Rules =====");

        for (String rule : counts.keySet()) {
            System.out.println(rule + " : " + counts.get(rule));
        }
    }

}