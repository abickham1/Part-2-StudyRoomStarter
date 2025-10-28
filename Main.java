package com.company;

import java.util.concurrent.Semaphore;

public class Main {

    static Semaphore room = new Semaphore(5); //Allow at most 5 students to enter the room. Used for bonus only.
    static Semaphore mutexCS = new Semaphore(1); //Enforce mutual exclusion for numCS variable
    static Semaphore mutexBio = new Semaphore(1); //Enforce mutual exclusion for numBio variable
    static Semaphore lockStudent = new Semaphore(1); //Prevent students of different majors from entering study room
    static int numBio = 0;  //Keep track of the number of Bio majors in the room
    static int numCS = 0;   //Keep track of the number of CS majors in the room

    public static class BioStudent extends Thread {
        String name;

        public BioStudent(String n)
        {
            name = n;
        }

        public void run(){
            //Request to enter room
            try {
                // Wait until no CS students are in the room
                lockStudent.acquire();

                mutexBio.acquire();
                if (numBio == 0) { // first bio student blocks CS
                    // CS students will wait
                }
                numBio++;
                mutexBio.release();

                lockStudent.release();

                // Acquire room capacity
                room.acquire();

            //Enter room
            System.out.println("Student " + name + " entered room...");

            //Sit on couch
            System.out.println("Student " + name + " sitting on couch...");

            //Study
            System.out.println("Student " + name + " studying...");
            Thread.sleep(200);

            //Playing game
            System.out.println("Student " + name + " eating a snack");
            Thread.sleep(400);

            //Packing up
            System.out.println("Student " + name + " packing up...");

            //Bye
            System.out.println("Student " + name + " exiting...");
                room.release();

                mutexBio.acquire();
                numBio--;
                mutexBio.release();


        }
            catch(InterruptedException e){
                e.printStackTrace();
            }
    }

    public static class CSStudent extends Thread {
        String name;

        public CSStudent(String n)
        {
            name = n;
        }

        public void run() {

            try {
                // Wait until no Bio students are in the room
                lockStudent.acquire();

                mutexCS.acquire();
                if (numCS == 0) { // first CS student blocks Bio
                    // Bio students will wait
                }
                numCS++;
                mutexCS.release();

                lockStudent.release();

                // Acquire room capacity
                room.acquire();
            //Enter room
            System.out.println("Student " + name + " entered room...");

            //Sit on couch
            System.out.println("Student " + name + " sitting on couch...");

            //Study
            System.out.println("Student " + name + " studying...");
            Thread.sleep(200);

            //Playing game
            System.out.println("Student " + name + " playing the Xbox One");
            Thread.sleep(400);

            //Packing up
            System.out.println("Student " + name + " packing up...");

            //Bye
            System.out.println("Student " + name + " exiting...");
            room.release();

                mutexCS.acquire();
                numCS--;
                mutexCS.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new BioStudent("Bio" + i).start();
        }

        // Create 20 CS students
        for (int i = 1; i <= 20; i++) {
            new CSStudent("CS" + i).start();
        }

        /*BioStudent b1 = new BioStudent("Bio1");
        BioStudent b2 = new BioStudent("Bio2");
        BioStudent b3 = new BioStudent("Bio3");
        BioStudent b4 = new BioStudent("Bio4");
        BioStudent b5 = new BioStudent("Bio5");

        BioStudent b6 = new BioStudent("Bio6");
        BioStudent b7 = new BioStudent("Bio7");
        BioStudent b8 = new BioStudent("Bio8");
        BioStudent b9 = new BioStudent("Bio9");
        BioStudent b10 = new BioStudent("Bio10");
        CSStudent cs1 = new CSStudent("CS1");
        CSStudent cs2 = new CSStudent("CS2");
        CSStudent cs3 = new CSStudent("CS3");
        CSStudent cs4 = new CSStudent("CS4");
        CSStudent cs5 = new CSStudent("CS5");

        CSStudent cs6 = new CSStudent("CS6");
        CSStudent cs7 = new CSStudent("CS7");
        CSStudent cs8 = new CSStudent("CS8");
        CSStudent cs9 = new CSStudent("CS9");
        CSStudent cs10 = new CSStudent("CS10");


        b2.start();
        cs1.start();
        b4.start();
        b5.start();

        b1.start();
        cs6.start();
        cs7.start();
        cs8.start();
        cs9.start();
        cs10.start();
        b6.start();
        b7.start();
        b8.start();
        b9.start();
        b10.start();
        cs2.start();
        cs3.start();
        cs4.start();
        cs5.start();
        b3.start();*/
    }
    }
}
