package com.codewithlfn;

public class StudentHashTable {
    private StudentEntry[] buckets;
    private int numOfBuckets;

    public StudentHashTable(int capacity) {
        this.numOfBuckets = capacity;
        this.buckets = new StudentEntry[capacity];
    }

    // figures out which bucket a student id belongs in
    private int getBucketIndex(String studentId) {
        int hashcode = studentId.hashCode();
        return Math.abs(hashcode % numOfBuckets);
    }

    // adds a student to the table, if the id already exists we just update the name
    public void insert(String studentId, String fullName) {
        int index = getBucketIndex(studentId);
        StudentEntry currentEntry = buckets[index];

        // walk through the chain to see if this id is already there
        while (currentEntry != null) {
            if (currentEntry.studentId.equals(studentId)) {
                currentEntry.fullName = fullName;
                return;
            }
            currentEntry = currentEntry.next;
        }

        // id not found so we add a new entry at the front of the chain
        StudentEntry newStudent = new StudentEntry(studentId, fullName);
        newStudent.next = buckets[index];
        buckets[index] = newStudent;
    }

    // looks up a student by their id and returns their name
    public String search(String studentId) {
        int index = getBucketIndex(studentId);
        StudentEntry currentEntry = buckets[index];

        // go through the chain until we find a match
        while (currentEntry != null) {
            if (currentEntry.studentId.equals(studentId)) {
                return currentEntry.fullName;
            }
            currentEntry = currentEntry.next;
        }
        return "Student not found";
    }

    // removes a student from the table using their id
    public void delete(String studentId) {
        int index = getBucketIndex(studentId);
        StudentEntry currentEntry = buckets[index];
        StudentEntry prevEntry = null;

        while (currentEntry != null) {
            if (currentEntry.studentId.equals(studentId)) {
                // if its the first entry in the bucket just move the head forward
                if (prevEntry == null) {
                    buckets[index] = currentEntry.next;
                } else {
                    // otherwise skip over the entry we want to remove
                    prevEntry.next = currentEntry.next;
                }
                System.out.println("Deleted student with ID: " + studentId + " and name: " + currentEntry.fullName);
                return;
            }
            prevEntry = currentEntry;
            currentEntry = currentEntry.next;
        }
        System.out.println("no student found with ID: " + studentId);
    }
}