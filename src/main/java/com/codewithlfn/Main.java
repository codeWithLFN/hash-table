package com.codewithlfn;

public class Main {
    public static void main(String[] args) {
        StudentHashTable hashTable = new StudentHashTable(10);

        // add some students to the table
        System.out.println("--- adding student records ---");
        hashTable.insert("TUT1", "Thabo Vundle");
        hashTable.insert("TUT2", "Legato Modena");
        hashTable.insert("TUT3", "Siphon Dlamini");
        System.out.println("all records added.\n");

        // search for a student that exists and one that doesnt
        System.out.println("--- searching for students ---");
        System.out.println("looking up TUT2: " + hashTable.search("TUT2"));
        System.out.println("looking up TUT9: " + hashTable.search("TUT9"));
        System.out.println();

        // remove a student from the table
        System.out.println("--- removing a student ---");
        hashTable.delete("TUT1");

        // check that they were actually removed
        System.out.println("\n--- confirming deletion ---");
        System.out.println("looking up TUT1: " + hashTable.search("TUT1"));
    }
}