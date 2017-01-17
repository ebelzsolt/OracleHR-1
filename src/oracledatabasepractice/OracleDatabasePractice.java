/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracledatabasepractice;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Ébel Zsolt
 */
public class OracleDatabasePractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* 
        A dátum trükkös dolog, az oracle adatbázis java.sql.Date-et vár és nem
        java.util.Date-et!
        */
        Date date = new Date(Calendar.getInstance().getTimeInMillis());

        Employee emp = new Employee(4, "Jakab", "Gipsz", "XYZ2", "111.222.333.44",
                date, "IT_PROG", 1000, 0, 103, 60);
        emp.insertEmployeeToDatabase();

    }

}
