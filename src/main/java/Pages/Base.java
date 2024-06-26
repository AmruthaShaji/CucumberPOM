package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.xml.sax.Locator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static StepDefinitions.Hook.getDriver;

public class Base {

    public WebElement getELement(By locator) {
        return getDriver().findElement(locator);
    }

    public void ClickOn(By locator) {
        getELement(locator).click();
        ;
    }

    public ArrayList<String> textList(By locator) {
        List<WebElement> wblist = getDriver().findElements(locator);
        ArrayList<String> textlist = new ArrayList<>();
        for (WebElement wb : wblist) {
            textlist.add(wb.getText());

        }

return textlist;
    }


}

