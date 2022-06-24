/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev_j130_4_2;

/**
 *
 * @author USER
 */
public class Writer extends Entity{
    public Writer(Database database, String name) {
        super(database, name);
    }

    @Override
    public void run() {
        while (true){
            database.writerEnter(this);
            randomPeriodTime(1000,2000);
            database.writerExit(this);
            randomPeriodTime(2000,3000);
        }
    }
}