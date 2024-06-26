package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static StepDefinitions.Hook.getDriver;

public class HotelSearch extends Base {


    By hotelnames = By.xpath("//div[@data-testid='title']");

    public ArrayList<String> getHotels() {
        return textList(hotelnames);
    }

/*By hotelprices=By.xpath("//span[@data-testid='price-and-discounted-price']");
    public ArrayList<String> getPricelist()
    {
        return textList(hotelprices);
    }*/

    By popupclsbtn = By.xpath("//button[@aria-label='Dismiss sign-in info.']");

    public void btnclick() {
        ClickOn(popupclsbtn);
    }

    By hotelprices = By.xpath("//span[@data-testid='price-and-discounted-price']");

    public ArrayList<Integer> getPricelist()
    {
        ArrayList<String> hprices = textList(hotelprices);
        ArrayList<Integer> pricelist = new ArrayList<>();
        String price1 = "";
        String pricewc = "";
        int newprice;

        for (String price : hprices) {
            price1 = price.split(" ")[1];
            pricewc = price1.replace(",", "");
            newprice = Integer.parseInt(pricewc);

            pricelist.add(newprice);
        }
        return pricelist;
    }

    public void starRatingclick(String star)
    {
        List<By>ratings=(List<By>)By.xpath("//div[contains(@class,'beb79c8078 b12c1fa68c') and div/h3[contains(text(),'Property rating')]]//div[contains(text(),'5 stars')]");
        ClickOn(ratings.get(0));
    }
}
