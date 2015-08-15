/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2974.Pneumatotron;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

/**
 * THIS IS UNTESTED - TESTING SHOULD COMMENCE ASAP
 * @author Admin
 */
public class NetTable {
    private static NetworkTable netTable = NetworkTable.getTable("SmartDashboard");
    public static double x,y;
    public static boolean isHot;
    public static void update(){
        try {
            x = netTable.getNumber("distanceXtoTarget");
            y = netTable.getNumber("distanceYtoTarget");
            isHot = netTable.getBoolean("oneBlob");
        } catch (TableKeyNotDefinedException e) {
        }
        System.out.println("X: "+x+"\nY: "+y);
    }
}