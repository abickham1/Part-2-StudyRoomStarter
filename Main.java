package com.company;

import java.util.concurrent.Semaphore;

public class Main {

    static Semaphore room = new Semaphore(5); //Allow at most 5 students to enter the room. Used for bonus only.
    static Semaphore mutexCS = new Semaphore(1); //Enforce mutual exclusion for numCS variable
    static Semaphore mutexBio = new Semaphore(1); //Enforce mutual exclusion for numBio variable
    static Semaphore lockStudent = new Semaphore(1); //Prevent students of different majors from entering study room
    static int numBio = 0;  //Keep track of the number of Bio majors in the room
    static int numCS = 0;   //Keep track of the number of CS majors in the room

    public static class BioStudent extends Thread
    {
        String name;

        public BioStudent(String n)
        {
            name = n;
        }

        public void run()
        {
            //Request to enter room

            //Enter room
            System.out.println("Student " + name + " entered room...");

            //Sit on couch
            System.out.println("Student " + name + " sitting on couch...");

            //Study
            System.out.println("Student " + name + " studying...");
            try{Thread.sleep(200);} catch (Exception e) {}

            //Playing game
            System.out.println("Student " + name + " eating a snack");
            try{Thread.sleep(400);} catch (Exception e) {}

            //Packing up
            System.out.println("Student " + name + " packing up...");

            //Bye
            System.out.println("Student " + name + " exiting...");


        }
    }

    public static class CSStudent extends Thread
    {
        String name;

        public CSStudent(String n)
        {
            name = n;
        }

        public void run()
        {

            //Enter room
            System.out.println("Student " + name + " entered room...");

            //Sit on couch
            System.out.println("Student " + name + " sitting on couch...");

            //Study
            System.out.println("Student " + name + " studying...");
            try{Thread.sleep(200);} catch (Exception e) {}

            //Playing game
            System.out.println("Student " + name + " playing the Xbox One");
            try{Thread.sleep(400);} catch (Exception e) {}

            //Packing up
            System.out.println("Student " + name + " packing up...");

            //Bye
            System.out.println("Student " + name + " exiting...");


        }
    }
    public static void main(String[] args) {
        BioStudent b1 = new BioStudent("Bio1");
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
        b3.start();
    }
}
