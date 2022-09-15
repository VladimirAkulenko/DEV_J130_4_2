/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev_j130_4_2;

/**
 *
 * @author USER
 */
import java.util.Random;

public class Entity extends Thread{
    protected final Database database;
    protected final Random rnd = new Random();

    public Entity(Database database, String name) {
        super(name);
        this.database = database;
    }

    protected void randomPeriodTime (int minMs, int maxMs){
        try {
            Thread.sleep((long) (minMs + rnd.nextFloat() * (maxMs - minMs)));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
