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
public interface Rule {

    Violation check(Observation observation);

    String getRuleName();
}