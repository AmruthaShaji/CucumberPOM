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



   // By individualHotelRatings=By.xpath(" //div[contains(@aria-label,'out of 5')]");
    public void starRatingclick(String star) {
        //List<Webe>ratings=(List<By>)By.xpath("//div[contains(@class,'beb79c8078 b12c1fa68c') and div/h3[contains(text(),'Property rating')]]//div[contains(text(),'5 stars')]");
        // ClickOn(ratings.get(0));
        String splitstar=star.split(" ")[0];
       // By starfilter = By.xpath("//div[contains(@class,'beb79c8078 b12c1fa68c') and div/h3[contains(text(),'Property rating')]]//div[contains(text(),'" + splitstar + " stars')]");
        By starfilter = By.xpath("//div[contains(@class,'beb79c8078 b12c1fa68c') and div/h3[contains(text(),'Property rating')]]//div[contains(text(),'4 stars')]");
        ClickOn(starfilter);//clicking on the required star rating

    }

    By individualHotelRatings=By.xpath("//div[contains(@aria-label,'out of 5')]");

    public ArrayList<Integer> getHotelStarRating()
        {


            List<WebElement>starratings= getDriver().findElements(individualHotelRatings);


            ArrayList<Integer>stars=new ArrayList<>();
            String starvalue;
            int stars1;

        for(WebElement starratings1:starratings)
        {
             starvalue= starratings1.getAttribute("aria-label");

             stars1=Integer.parseInt(starvalue.split(" ")[0]);
            stars.add(stars1);
        }

            System.out.println(stars);
return stars;

    }
}
