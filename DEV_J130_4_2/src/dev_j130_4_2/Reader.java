/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev_j130_4_2;

/**
 *
 * @author USER
 */
public class Reader extends Entity{
    public Reader(Database database, String name) {
        super(database, name);
    }

    @Override
    public void run() {
        while (true){
            database.readerEnter(this);
            randomPeriodTime(200,300);
            database.readerExit(this);
            randomPeriodTime(2000,3000);
        }
    }
}
