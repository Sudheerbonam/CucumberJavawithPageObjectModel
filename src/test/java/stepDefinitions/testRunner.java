package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
                (features = {"src/test/Features"},
                     glue = {"stepDefinitions"},
                     tags = "(@RegressionTest_NewBooking or @RegressionTest_DeleteBooking)",
                //   tags = "(@RegressionTest_DeleteBooking)",
               //    tags = "(@RegressionTest_NewBooking)",
               monochrome = true,
                   plugin = {"pretty","json:target/cucumber/executionReport.json",
                                      "html:target/cucumber/executionReport.html"})
public class testRunner
{

}
