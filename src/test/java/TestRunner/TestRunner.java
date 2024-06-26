package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="Feature/HotelSearch.feature",
        glue = "StepDefinitions"
         ,
        tags = " @starverify")

public class TestRunner {


}


