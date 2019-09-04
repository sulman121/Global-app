package Runnerpackage;

import org.testng.annotations.AfterClass;  
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;  


@CucumberOptions ( features = "src/test/resources/Features/"
                   ,glue = {"Steps"}
	               ,dryRun = false
	               ,monochrome=true
	               ,plugin = {"pretty","html:target/site/cucumber-pretty",
	            		      "json:target/cucumber.json"}
                   ,strict = false
                   ,tags = {"@Additional,@Requested"}
	               		
		          )

  

public class RunnerClass {
	
	private TestNGCucumberRunner testngcucumberrunner;
	
	@BeforeClass(alwaysRun=true)
	public void SetUpClass() throws Exception{
		
		testngcucumberrunner = new TestNGCucumberRunner(this.getClass());
	}
	
    @Test(dataProvider="features")
    public void feature(PickleEventWrapper eventwrapper,CucumberFeatureWrapper cucumberFeature) throws Throwable {
    	
    	testngcucumberrunner.runScenario(eventwrapper.getPickleEvent());
    }
	
	@DataProvider
	public Object[][] features(){
		return testngcucumberrunner.provideScenarios();
	}
}