package com.jcboe.home.instruction.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserDetailDTOTest {

    @Test
    void testDefaultConstructorAndSetters() {

        UserDetailDTO dto = new UserDetailDTO();

        dto.setRegisteredUserID(1);
        dto.setUserID(2);
        dto.setUserType("Student");
        dto.setOneTimeCode(1234);
        dto.setRegisteredEmail("test@test.com");
        dto.setUserPassword("password");
        dto.setOtpSentOn("2025-01-01");
        dto.setRegisteredOn("2025-01-02");
        dto.setPasswordReset(true);
        dto.setActive(true);
        dto.setStatus(1);

        dto.setEmployeeId(10);
        dto.setLocationId("100");
        dto.setFirstName("John");
        dto.setLastName("Smith");
        dto.setGuide("Guide");
        dto.setEmailId("john@test.com");
        dto.setMiddleName("M");
        dto.setUpdatedBy(20);
        dto.setUpdatedOn("2025-01-03");
        dto.setUserName("john");
        dto.setAppRoleAbbreviation("ADMIN");
        dto.setAppRoleName("Administrator");

        dto.setValidTsCount(5L);
        dto.setEmployeeName("John Smith");
        dto.setWorkDate("2025-01-04");
        dto.setUserInfoType("EMP");
        dto.setPhoneNumber1("1111111111");
        dto.setPhoneNumber2("2222222222");


        assertEquals(1, dto.getRegisteredUserID());
        assertEquals(2, dto.getUserID());
        assertEquals("Student", dto.getUserType());
        assertEquals(1234, dto.getOneTimeCode());
        assertEquals("test@test.com", dto.getRegisteredEmail());
        assertEquals("password", dto.getUserPassword());
        assertEquals("2025-01-01", dto.getOtpSentOn());
        assertEquals("2025-01-02", dto.getRegisteredOn());
        assertTrue(dto.isPasswordReset());
        assertTrue(dto.isActive());
        assertEquals(1, dto.getStatus());

        assertEquals(10, dto.getEmployeeId());
        assertEquals("100", dto.getLocationId());
        assertEquals("John", dto.getFirstName());
        assertEquals("Smith", dto.getLastName());
        assertEquals("Guide", dto.getGuide());
        assertEquals("john@test.com", dto.getEmailId());
        assertEquals("M", dto.getMiddleName());
        assertEquals(20, dto.getUpdatedBy());
        assertEquals("2025-01-03", dto.getUpdatedOn());
        assertEquals("john", dto.getUserName());
        assertEquals("ADMIN", dto.getAppRoleAbbreviation());
        assertEquals("Administrator", dto.getAppRoleName());

        assertEquals(5L, dto.getValidTsCount());
        assertEquals("John Smith", dto.getEmployeeName());
        assertEquals("2025-01-04", dto.getWorkDate());
        assertEquals("EMP", dto.getUserInfoType());
        assertEquals("1111111111", dto.getPhoneNumber1());
        assertEquals("2222222222", dto.getPhoneNumber2());
    }


    @Test
    void testUserNamePasswordConstructor() {

        UserDetailDTO dto = new UserDetailDTO("john", "password");

        assertEquals("john", dto.getUserName());
        assertEquals("password", dto.getUserPassword());
    }


    @Test
    void testParameterizedConstructor() {

        UserDetailDTO dto = new UserDetailDTO(
                1,
                2,
                "EMP",
                1234,
                "test@test.com",
                "password",
                "2025-01-01",
                "2025-01-02",
                true,
                true,
                1,
                10,
                "100",
                "John",
                "Smith",
                "Guide",
                "john@test.com",
                "M",
                20,
                "2025-01-03",
                "ADMIN",
                "Administrator",
                "EMPLOYEE",
                "1111111111",
                "2222222222"
        );


        assertEquals(1, dto.getRegisteredUserID());
        assertEquals(2, dto.getUserID());
        assertEquals("EMP", dto.getUserType());
        assertEquals(1234, dto.getOneTimeCode());
        assertEquals("test@test.com", dto.getRegisteredEmail());
        assertEquals("password", dto.getUserPassword());
        assertTrue(dto.isPasswordReset());
        assertTrue(dto.isActive());
        assertEquals(1, dto.getStatus());
        assertEquals(10, dto.getEmployeeId());
        assertEquals("100", dto.getLocationId());
        assertEquals("John", dto.getFirstName());
        assertEquals("Smith", dto.getLastName());
        assertEquals("ADMIN", dto.getAppRoleAbbreviation());
        assertEquals("Administrator", dto.getAppRoleName());
        assertEquals("EMPLOYEE", dto.getUserInfoType());
        assertEquals("1111111111", dto.getPhoneNumber1());
        assertEquals("2222222222", dto.getPhoneNumber2());
    }


    @Test
    void testToString() {

        UserDetailDTO dto = new UserDetailDTO();

        dto.setUserName("john");
        dto.setEmployeeName("John Smith");
        dto.setStatus(1);

        String result = dto.toString();

        assertNotNull(result);
        assertTrue(result.contains("userName=john"));
        assertTrue(result.contains("employeeName=John Smith"));
        assertTrue(result.contains("status=1"));
    }
}