package com.practice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    @Test
    void studentStoresItsDetails() {
        Student student = new Student(1, "Asha", "Java");
        assertEquals(1, student.getId());
        assertEquals("Asha", student.getName());
        assertEquals("Java", student.getCourse());
    }
}
