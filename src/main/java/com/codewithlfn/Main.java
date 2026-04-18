package com.codewithlfn;

public class Main {
    public static void main(String[] args) {
        StudentHashTable hashTable = new StudentHashTable(10);

        System.out.println("--- 1. INSERTING RECORDS ---");
        hashTable.insert("TUT001", "Thabo Ndlovu");
        hashTable.insert("TUT002", "Lerato Mokoena");
        hashTable.insert("TUT003", "Sipho Dlamini");
        System.out.println("Records added successfully.\n");

        System.out.println("--- 2. SEARCHING RECORDS ---");
        System.out.println("Searching for TUT002: " + hashTable.search("TUT002"));
        System.out.println("Searching for TUT009: " + hashTable.search("TUT009"));
        System.out.println();

        System.out.println("--- 3. DELETING RECORDS ---");
        hashTable.delete("TUT001");

        System.out.println("\n--- 4. VERIFYING DELETION ---");
        System.out.println("Searching for TUT001: " + hashTable.search("TUT001"));

    }
}