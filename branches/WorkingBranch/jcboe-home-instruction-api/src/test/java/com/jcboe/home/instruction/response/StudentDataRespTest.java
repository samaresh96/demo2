package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentDataRespTest {

    @Test
    void testDefaultConstructorAndSetters() {

        StudentDataResp student = new StudentDataResp();

        student.setStudentId(1L);
        student.setStudentName("John Smith");
        student.setDob("2010-01-01");
        student.setGender("Male");
        student.setAge("15");
        student.setGrade("10");
        student.setGradeId(10);
        student.setSchool("ABC School");
        student.setSchoolCode("ABC001");
        student.setSpecialEd("No");
        student.setParentsName("Parent Name");
        student.setEmailId("john@test.com");
        student.setIsforgotPassword(true);
        student.setEmailVerified(true);

        assertEquals(1L, student.getStudentId());
        assertEquals("John Smith", student.getStudentName());
        assertEquals("2010-01-01", student.getDob());
        assertEquals("Male", student.getGender());
        assertEquals("15", student.getAge());
        assertEquals("10", student.getGrade());
        assertEquals(10, student.getGradeId());
        assertEquals("ABC School", student.getSchool());
        assertEquals("ABC001", student.getSchoolCode());
        assertEquals("No", student.getSpecialEd());
        assertEquals("Parent Name", student.getParentsName());
        assertEquals("john@test.com", student.getEmailId());
        assertTrue(student.isIsforgotPassword());
        assertTrue(student.isEmailVerified());
    }


    @Test
    void testParameterizedConstructor() {

        StudentDataResp student = new StudentDataResp(
                1L,
                "John Smith",
                "2010-01-01",
                "Male",
                "15",
                "10",
                10,
                "ABC School",
                "ABC001",
                "No",
                "Parent Name",
                "john@test.com",
                true,
                true
        );

        assertEquals(1L, student.getStudentId());
        assertEquals("John Smith", student.getStudentName());
        assertEquals("2010-01-01", student.getDob());
        assertEquals("Male", student.getGender());
        assertEquals("15", student.getAge());
        assertEquals("10", student.getGrade());
        assertEquals(10, student.getGradeId());
        assertEquals("ABC School", student.getSchool());
        assertEquals("ABC001", student.getSchoolCode());
        assertEquals("No", student.getSpecialEd());
        assertEquals("Parent Name", student.getParentsName());
        assertEquals("john@test.com", student.getEmailId());
        assertTrue(student.isIsforgotPassword());
        assertTrue(student.isEmailVerified());
    }


    @Test
    void testBooleanSetters() {

        StudentDataResp student = new StudentDataResp();

        student.setIsforgotPassword(false);
        student.setEmailVerified(false);

        assertFalse(student.isIsforgotPassword());
        assertFalse(student.isEmailVerified());
    }


    @Test
    void testToString() {

        StudentDataResp student = new StudentDataResp();

        student.setStudentId(1L);
        student.setStudentName("John Smith");
        student.setSchool("ABC School");

        String result = student.toString();

        assertNotNull(result);
        assertTrue(result.contains("studentId=1"));
        assertTrue(result.contains("studentName=John Smith"));
        assertTrue(result.contains("school=ABC School"));
    }
}