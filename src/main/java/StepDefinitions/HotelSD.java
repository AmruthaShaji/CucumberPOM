package StepDefinitions;

import Pages.HotelSearch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;

public class HotelSD {

HotelSearch htn=new HotelSearch();
    ArrayList<String> namelist;
   // ArrayList<String> pricelist;


    @Given("I am on default locations search result screen")
    public void i_am_on_default_locations_search_result_screen() {

       try
       {
           htn.btnclick();
       }
       catch (Exception e) {

       }

     namelist=htn.getHotels();
        System.out.println(namelist);
        System.out.println("size="+namelist.size());

/*
        pricelist=htn.getPricelist();
        System.out.println(pricelist);
        System.out.println("size="+pricelist.size());
*/




    }
    @Then("I verify {string} is within the search result")
    public void i_verify_is_within_the_search_result(String hotel) {
        boolean flag= false;

        for(String name:namelist)
        {
            if (name.contains(hotel)) {
                flag = true;
                break;
            }

        }

        Assert.assertTrue(hotel+"HOTEL is not in search",flag);
        System.out.println(hotel);
    }

    /*@Then("I verify system displays all hotels within {string} amount")
    public void iVerifySystemDisplaysAllHotelsWithinAmount(String maxamount) {
        ArrayList<Integer> highprices=new ArrayList<>();
        String price1="";
        String pricewc="";
        int newprice;
        int amount=Integer.parseInt(maxamount);

        System.out.println(amount);
        boolean flag1=true;
        for(String price:pricelist)
        {
            price1= price.split(" ")[1];
            pricewc=price1.replace(",","");
            newprice=Integer.parseInt(pricewc);

            if(newprice>amount){
                highprices.add(newprice);
                flag1=false;
            }



        }

        if(flag1)
            System.out.println(pricelist);

        else
            System.out.println(highprices);

        Assert.assertTrue("somehotels are not within amount",flag);


    }*/
    @Then("I verify system displays all hotels within {string} amount")
    public void iVerifySystemDisplaysAllHotelsWithinAmount(String maxamount) {

        ArrayList<Integer>hotelprices=htn.getPricelist();
        int amount=Integer.parseInt(maxamount);
        boolean flag1=true;

        ArrayList<Integer>hotelhighprices=new ArrayList<>();
        for(int price:hotelprices)
        {
            if(price>amount){
                hotelhighprices.add(price);
                flag1=false;
            }

        }

        if(flag1)
            System.out.println(hotelprices);

        else
            System.out.println(hotelhighprices);

        Assert.assertTrue("some hotels are not within amount",flag1);





    }

    @When("I select option for stars as {}")
    public void iSelectOptionForStarsAs(String stars) {
        htn.starRatingclick(stars);
    }

    @Then("I verify system displays only {} hotels on search result")
    public void iVerifySystemDisplaysOnlyHotelsOnSearchResult(String arg0) {

    }
}
