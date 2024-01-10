package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.User;
import com.example.service.UserAuthentication;

class UserAuthenticationTest {

    static User u;
    static UserAuthentication ua;
    static Scanner sc;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        u = new User();
        ua = new UserAuthentication();
        ua.listOfUser(new User("demo@example.com", "demo@123"));
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        u = null;
        ua = null;
    }

    @BeforeEach
    void setUp() throws Exception {
        sc = new Scanner(System.in);
    }

    @AfterEach
    void tearDown() throws Exception {
        sc.close();
    }

    @Test
    void testLogin() {
        System.out.println("Enter your email and password to Register:");
        String email = sc.nextLine();
        String password = sc.nextLine();
        u.setEmail(email);
        u.setPassword(password);
        assertTrue(ua.Login(u));
    }

    @Test
    void testListOfUser() {
        assertNotNull(ua.listOfUser(new User("test@gmail.com", "password")));
    }

    static User user;

    @Test
    void testRegistration() {
        String email = "test@example.com";
        user = new User("test@example.com", "test@123");
        String result = ua.registration(user);
        System.out.println(result);
        assertEquals("Registered", result);
    }
}
