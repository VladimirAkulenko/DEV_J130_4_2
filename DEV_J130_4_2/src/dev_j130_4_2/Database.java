/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev_j130_4_2;

/**
 *
 * @author USER
 */
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;


public class Database {

    private static final int MAX_AVAILABLE = 100;
    private final Semaphore semaphore = new Semaphore(MAX_AVAILABLE);
    private final AtomicInteger readerInt = new AtomicInteger();

    public synchronized void readerEnter (Reader reader){
        System.out.printf("%s хочет подключиться к базе данных. %n", reader);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        int readInt = readerInt.incrementAndGet();
        System.out.printf("%s подключён к базе данных. Сейчас в базе данных %d читателей. %n", reader,readInt);
    }

    public void readerExit(Reader reader){
        semaphore.release();
        int in = readerInt.decrementAndGet();
        System.out.printf("%s покинул базу данных. %d читателей сейчас в базе данных. %n", reader,in);
    }

    public void writerEnter(Writer writer){
        System.out.printf("%s хочет подключиться к базе данных. %n", writer);

        try {
            semaphore.acquire(MAX_AVAILABLE);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.printf("%s подключён к базе данных. %n", writer);
    }
     public void writerExit(Writer writer){
        semaphore.release(MAX_AVAILABLE);
         System.out.printf("%s покинул базу данных %n", writer);
     }
}
