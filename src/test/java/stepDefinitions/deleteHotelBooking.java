package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import pageObjects.hotelBookingHomePageObjects;
import utility.baseClass;
import utility.screenShots;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class deleteHotelBooking extends baseClass {

    hotelBookingHomePageObjects HotelBookingHomePageObjects;
    screenShots ScreenShots = new screenShots();
    String currentDate = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    //**********Start of Delete Existing Hotel Booking**********
    @BeforeTest
    @Given("User on the Hotel Booking Form pages")
    public void user_on_the_hotel_booking_form_pages() throws IOException {
        driver= baseClass.browserAccess();
    }
    @And("User clicks on the Delete button")
    public void user_clicks_on_the_delete_button() throws InterruptedException {
        HotelBookingHomePageObjects = new hotelBookingHomePageObjects(driver);
        WebElement activeBookings = driver.findElement(By.id("bookings"));
        List<WebElement> bookingRows = activeBookings.findElements(By.tagName("p"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        int totalRows = bookingRows.size();
        System.out.println("rows:::"+ totalRows);
        for (int i = 0; i < totalRows; i++) {
            String rowText = bookingRows.get(i).getText();
            System.out.println("row text:::"+ rowText);
            if (rowText.contains("Bonam"))
            {
                HotelBookingHomePageObjects.HB_delete();
                System.out.println("Record Found and Deleted Successfully."+rowText);
            }
        }
    }
    @Then("Existing record got deleted successfully")
    public void existing_record_got_deleted_successfully() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().refresh();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        JavascriptExecutor JsExecutor = (JavascriptExecutor)driver;
        Thread.sleep(1000);
        JsExecutor.executeScript("window.scrollBy(0,250)");
        ScreenShots.captureScreen("Record Deleted Successfully"+currentDate);
       // driver.close();
       // driver.quit();

    }
            //**********End of Delete Existing Hotel Booking**********
}

