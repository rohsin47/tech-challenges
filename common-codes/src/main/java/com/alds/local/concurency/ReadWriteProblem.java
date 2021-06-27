package com.alds.local.concurency;

/**
 * @author rohsingh
 * 
 * Problem statement : Imagine you have an application where you have multiple readers and a single writer. You are asked 
 * to design a lock which lets multiple readers read at the same time, but only one writer write at a time.
 * 
 * 
 * TIPS :
 * Define the APIs your class will expose. In this case you'll need two for writer and two for reader. These are:

        acquireReadLock
        releaseReadLock
        acquireWriteLock
        releaseWriteLock
  
     Think about each use case that you need to satisfy. These are: Before we allow a reader to enter the critical section, 
     we need to make sure that there's no writer in progress. It is ok to have other readers in the critical section since 
     they aren't making any modifications. Before we allow a writer to enter the critical section, we need to make sure that 
     there's no reader or writer in the critical section.

    Start by examining the Reader use case. You can have multiple readers acquire the read lock, and to keep track of all of them you’ll 
    need a count. You increment this count whenever a reader acquires a read lock and decrement it whenever a reader releases it.

    Releasing the read lock is easy, but before you acquire the read lock, you need to be sure that no other writer is currently writing. 
    Again, you’ll need some variable to keep track of whether a writer is writing. Since only a single writer can write at a given point in time, 
    you can just keep a boolean variable to denote if the write lock is acquired or not.

    Additionally, you’ll also need a condition variable for the readers and writers to wait while the other party is in progress. 
    You can use a mutex lock with a condition variable to guard the sections of the code where you manipulate any shared variables.
    
        
Common pitfalls
    Avoid splitting the acquisition and release of the mutex variable across two methods. It may seem more efficient since a writer thread only 
    acquires and releases the condition variable once during operation. But the Achilles’ heel of this approach is that if the writer thread dies 
    between the two method calls, the entire system would enter a deadlock.

    Another common pitfall of the ReadWrite Lock problem is starvation. If a writer arrives while there are readers in the critical section, it might 
    wait in queue forever while readers come and go. As long as a new reader arrives before the last of the current readers departs, there will always 
    be at least one reader in the room. To help avoid this, you could add a mutex for the readers and allow writers to lock it.
 *
 */
public class ReadWriteProblem {
    
    private final Object mutex = new Object();
    
    private int readers;
    private int writers;
    
    public void acquireRead() throws InterruptedException {
        synchronized (mutex) {
            while(writers != 0) {
                mutex.wait();
            }
            readers++;
        }     
    }
    
    public void releaseRead() {
        synchronized (mutex) {
            if(readers >=1) {
                readers--;
            }
            if(readers == 0) {
                mutex.notifyAll();
            }
        }
    }
    
    public void acquireWrite() throws InterruptedException {
        synchronized (mutex) {
            while(readers != 0) {
                mutex.wait();
            }
            writers++;
        }
    }
    
    public void releaseWrite() {
        synchronized (mutex) {
            if(writers >=1) {
                writers--;
            }
            if(writers == 0) {
                mutex.notifyAll();
            }
        }
    }
    
    String testData;
    
    public ReadWriteProblem() {
        this.testData = "Test1";
    }
    
    public void read() throws InterruptedException {
        acquireRead();
        System.out.println(Thread.currentThread().getName() + " : "+testData);
        releaseRead();
    }
    
    public void write(String data) throws InterruptedException {
        acquireWrite();
        this.testData = data;
        releaseWrite();
    }
    
    
    public static void main(String[] args) {    
        ReadWriteProblem ins = new ReadWriteProblem();
        Runnable reader1 = () -> {
            Thread.currentThread().setName("Reader-1");
            try {
                ins.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable reader2 = () -> {
            Thread.currentThread().setName("Reader-2");
            try {
                ins.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable reader3 = () -> {
            Thread.currentThread().setName("Reader-3");
            try {
                ins.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable writer = () -> {
            Thread.currentThread().setName("Writer");
            try {
                ins.write("Test2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable reader4 = () -> {
            Thread.currentThread().setName("Reader-4");
            try {
                ins.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        
        new Thread(reader1).start();
        new Thread(reader2).start();
        new Thread(writer).start();
        new Thread(reader3).start();
        new Thread(reader4).start();
    }
   
}
