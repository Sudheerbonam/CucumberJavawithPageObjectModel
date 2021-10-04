package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class baseClass {
    public static WebDriver driver;
    public static Properties property;

    public static WebDriver browserAccess() throws IOException
    {
        property=new Properties();
       //By creating the projectDirectory,it will run @ other systems without path not found issues.
        String projectDirectory = System.getProperty("user.dir");
       //URL fetching from the properties file
        FileInputStream fiStream=new FileInputStream(projectDirectory+ "/src/test/java/utility/global.properties");
        property.load(fiStream);
        //By using the '/' for relative path below, it will run @ Windows and Mac.
        System.setProperty("webdriver.chrome.driver", projectDirectory + "/src/test/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(property.getProperty("url"));
        return driver;
    }
}
