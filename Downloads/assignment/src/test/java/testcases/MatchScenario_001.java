package testcases;

import org.testng.annotations.Test;

import helper.DriverFactory;

public class MatchScenario_001 extends DriverFactory {

	@Test
	public void sampleScenario() throws InterruptedException {
		reg.registration();
		home.homepageValidations();
	}
}
