package com.codewithlfn;

// each entry holds a student id, their name, and a link to the next entry in the same bucket
public class StudentEntry {
    String studentId;
    String fullName;
    StudentEntry next;

    public StudentEntry(String studentId, String fullName) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.next = null;
    }
}