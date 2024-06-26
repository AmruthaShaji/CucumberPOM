package StepDefinitions;


import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {

 static WebDriver driver;
    @Before
    public void OpenUrrl()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/searchresults.html?ss=Munnar%2C+India&efdco=1&label=gen173nr-1FCAEoggI46AdIM1gEaGyIAQGYATG4ARfIAQzYAQHoAQH4AQKIAgGoAgO4AoDI4LMGwAIB0gIkMTY5ZjZiNDAtOTk5YS00YmNmLTgwZWQtMzk1ODU4MDk0Mjc22AIF4AIB&aid=304142&lang=en-us&sb=1&src_elem=sb&src=index&dest_id=-2105113&dest_type=city&checkin=2024-07-30&checkout=2024-07-31&group_adults=2&no_rooms=1&group_children=0");
    }

    public static WebDriver getDriver()
    {
        return driver;
    }
}
