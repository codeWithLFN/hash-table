package com.codewithlfn;

public class StudentHashTable {
    private StudentEntry[] buckets;
    private int numOfBuckets;

    // Constructor
    public StudentHashTable(int capacity) {
        this.numOfBuckets = capacity;
        this.buckets = new StudentEntry[capacity];
    }

    // methods to calculate the array index for a given ID
    private int getBucketIndex(String studentId) {
        int hashcode = studentId.hashCode();
        return Math.abs(hashcode % numOfBuckets);
    }

    // Insert a student into the hash table
    public void insert(String studentId, String fullName) {
        int index = getBucketIndex(studentId);
        StudentEntry currentEntry = buckets[index];

        // Check if the student ID already exists, if so update the name
        while (currentEntry != null) {
            if (currentEntry.studentId.equals(studentId)) {
                currentEntry.fullName = fullName;
                return;
            }
            currentEntry = currentEntry.next;
        }

        StudentEntry newStudent = new StudentEntry(studentId, fullName);
        newStudent.next = buckets[index];
        buckets[index] = newStudent;
    }

    // Search for a student by ID
    public String search(String studentId) {
        int index = getBucketIndex(studentId);
        StudentEntry currentEntry = buckets[index];

        // Traverse the linked list at this bucket to find the student ID
        while (currentEntry != null) {
            if (currentEntry.studentId.equals(studentId)) {
                return currentEntry.fullName;
            }
            currentEntry = currentEntry.next;
        }
        return "Student not found";
    }

    public void delete(String studentId) {
        int index = getBucketIndex(studentId);
        StudentEntry currentEntry = buckets[index];
        StudentEntry prevEntry = null;

        while (currentEntry != null) {
            if (currentEntry.studentId.equals(studentId)) {
                // If the current entry is the head of the list, delete it
                if (prevEntry == null) {
                    buckets[index] = currentEntry.next; // Deleting the head of the list
                } else {
                    // If the current entry is not the head, update the previous entry's next pointer'
                    prevEntry.next = currentEntry.next; // Bypass the current entry
                }
                System.out.println("Deleted student with ID: " + studentId );
                return;
            }
            prevEntry = currentEntry;
            currentEntry = currentEntry.next;
        }
        System.out.println("Student with ID: " + studentId + " not found for deletion.");
    }
}
