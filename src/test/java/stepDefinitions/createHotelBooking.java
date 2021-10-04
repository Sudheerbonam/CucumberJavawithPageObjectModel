package stepDefinitions;

import entities.CreateHotelBooking;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.json.simple.parser.ParseException;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pageObjects.hotelBookingHomePageObjects;
import utility.baseClass;
import utility.jsonRead;
import utility.screenShots;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
public class createHotelBooking extends baseClass {

    hotelBookingHomePageObjects HotelBookingHomePageObjects;
    screenShots ScreenShots = new screenShots();
    String currentDate = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    List<CreateHotelBooking> createHotelBookingList;

    public createHotelBooking() throws IOException, ParseException {
        HotelBookingHomePageObjects = new hotelBookingHomePageObjects(driver);
        createHotelBookingList  = new jsonRead().jsonDataRead();
    }
    //**********Start of Create a New Hotel Booking**********

        @Given("User on the Hotel Booking Form page")
        public void user_on_the_hotel_booking_form_page() throws IOException, InterruptedException {
            driver= baseClass.browserAccess();
            Thread.sleep(1000);
            ScreenShots.captureScreen("HotelBookingHomePage"+currentDate);
        }
        @When("User enters the Firstname")
        public void user_enters_the_firstname() throws IOException, ParseException {
            HotelBookingHomePageObjects = new hotelBookingHomePageObjects(driver);
            HotelBookingHomePageObjects.HB_firstname(createHotelBookingList.get(0).getFirstName());
        }
        @And("User enters the Surname")
        public void user_enters_the_surname() {
            HotelBookingHomePageObjects.HB_surname(createHotelBookingList.get(0).getSurname());
        }
        @And("User enters the Price")
        public void user_enters_the_price() {
            HotelBookingHomePageObjects.HB_price(createHotelBookingList.get(0).getPrice());
        }
        @And("User selects the Deposit")
        public void user_selects_the_deposit() {
             HotelBookingHomePageObjects.HB_deposit(createHotelBookingList.get(0).getDeposit());
        }
        @And("User selects the Check-in date")
        public void user_selects_the_check_in_date() {
            HotelBookingHomePageObjects.HB_checkin(createHotelBookingList.get(0).getCheckIn());
        }
        @And("User selects the Check-out date")
        public void user_selects_the_check_out_date() {
             HotelBookingHomePageObjects.HB_checkout(createHotelBookingList.get(0).getCheckOut());
        }
        @And("User clicks on the Save button")
        public void user_clicks_on_the_save_button() throws InterruptedException {
            HotelBookingHomePageObjects.HB_save();
        }
        @Then("User verify the confirmed booking record")
        public void user_verify_the_confirmed_booking_record() throws InterruptedException, IOException {
            driver.navigate().refresh();
            WebElement activeBookings = driver.findElement(By.id("bookings"));
            List<WebElement> bookingRows = activeBookings.findElements(By.tagName("p"));
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            int totalRows = bookingRows.size();
            System.out.println("Total Number of Rows are :" + totalRows);
            for (int i = 0; i < totalRows; i++) {
                String rowText = bookingRows.get(i).getText();
                System.out.println("Available Booking Rows are ::" + bookingRows);
                if (rowText.contains(createHotelBookingList.get(0).getFirstName().toString()))
                {
                    System.out.println("Row text data is:  " + rowText);
                    System.out.println("Data from JSON is: " + createHotelBookingList.get(0).getFirstName());
                    //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                }
            }
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            JavascriptExecutor JsExecutor = (JavascriptExecutor)driver;
            Thread.sleep(2000);
            JsExecutor.executeScript("window.scrollBy(0,250)");
            ScreenShots.captureScreen("New Record Created Successfully"+currentDate);
            // driver.close();
           // driver.quit();
        }
    }
    //**********End of Create a New Hotel Booking**********
