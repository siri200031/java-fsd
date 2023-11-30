package com.ecommerce.tests;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@DisplayName("JUnit 5 Conditional Tests Example")

public class ConditionalTests {

	@Test
	@EnabledOnOs({OS.WINDOWS})
	public void runOnWindows() {
		System.out.println("This runs on Windows");
	}

	@Test
	@EnabledOnOs({OS.LINUX})
	public void runOnLinux() {
		System.out.println("This runs on Linux");
	}


	@Test
	@Disabled
	void mightNotBeExecuted() {
		if (Math.random() < 0.314159) {
			System.out.println("This may or may not execute");
		} else {
			System.out.println("Test is disabled based on a condition");
			assumeTrue(false);
		}
	}
}
