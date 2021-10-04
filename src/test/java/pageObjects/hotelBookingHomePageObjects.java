package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.baseClass;

/*
This class contains field elements for Hotel Booking page,
if any element id's changes, we can save here and script will run as is.
Author: Sudheer Bonam
 */
public class hotelBookingHomePageObjects extends baseClass {

    //PageFactoryObjects

    @FindBy(xpath = "//input[@id='firstname']")
    WebElement HB_firstname;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement HB_surname;

    @FindBy(xpath = "//input[@id='totalprice']")
    WebElement HB_price;

    @FindBy(xpath = "//select[@id='depositpaid']")
    WebElement HB_deposit;

    @FindBy(xpath = "//input[@id='checkin']")
    WebElement HB_checkIn;

    @FindBy(xpath = "//input[@id='checkout']")
    WebElement HB_checkOut;

    @FindBy(xpath = "//body/div[1]/div[3]/div[1]/div[7]")
    WebElement HB_save;

    @FindBy(xpath = "//body/div[1]/div[2]/div[2]/div[7]/input[1]")
    WebElement HB_delete;

    public hotelBookingHomePageObjects(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

//Setting up String values

    public void firstname(String strFirstname) {

        HB_firstname.sendKeys(strFirstname);
    }
    public void surname(String strSurname) {

        HB_surname.sendKeys(strSurname);
    }
    public void price(String strPrice) {

        HB_price.sendKeys(strPrice);
    }
    public void deposit(String strDeposit) {

        HB_deposit.sendKeys(strDeposit);
    }
    public void checkin(String strCheckin) {

        HB_checkIn.sendKeys(strCheckin);
    }
    public void checkout(String strCheckout) {

        HB_checkOut.sendKeys(strCheckout);
    }
    public void save() {

        HB_save.click();
    }
    public void delete() {

        HB_delete.click();
    }

    //Setting up to utilise PageFactory model elements.

    public void HB_firstname(String strFirstname) {

        this.firstname(strFirstname);
    }
    public void HB_surname(String strSurname) {

        this.surname(strSurname);
    }
    public void HB_price(String strPrice) {

        this.price(strPrice);
    }
    public void HB_deposit(String strDeposit) {

        this.deposit(strDeposit);
    }
    public void HB_checkin(String strCheckin) {

        this.checkin(strCheckin);
    }
    public void HB_checkout(String strCheckout) {

        this.checkout(strCheckout);
    }
    public void HB_save() {

        this.save();
    }
    public void HB_delete() {

        this.delete();
    }
}