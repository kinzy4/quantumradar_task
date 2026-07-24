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
public class Violation {

    private String ruleName;
    private String description;
    private int fee;

    public Violation(String ruleName, String description, int fee) {
        this.ruleName = ruleName;
        this.description = description;
        this.fee = fee;
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getDescription() {
        return description;
    }

    public int getFee() {
        return fee;
    }
}