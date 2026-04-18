package com.codewithlfn;

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
