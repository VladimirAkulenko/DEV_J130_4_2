/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dev_j130_4_2;

/**
 *
 * @author USER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Database database = new Database();
	    Entity[] entity = new Entity[]{
                new Reader(database,"Читатель1"),
                new Reader(database,"Читатель2"),
                new Reader(database,"Читатель3"),
                new Reader(database,"Читатель4"),
                new Reader(database,"Читатель5"),
                new Writer(database,"Писатель1"),
                new Writer(database,"Писатель2"),
                new Writer(database,"Писатель3")
        };

        for (Entity e: entity)
            e.start();
        entity[0].join();

    }
    
}
