package Play_Wright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.*;
import java.util.*;

public class Wego {
  public static void main(String[] args) {
	  Playwright playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions(); // This is declared to launch the browser 
		lp.setChannel("msedge");//this is used to define which browser you want to run your Automation script
		lp.setHeadless(false);//if you pass true then the script will run on background incase if you define false then the script will execute on the browser
		
		Browser browser = playwright.chromium().launch(lp); // This will launch the browser
		Page page = browser.newPage();//this will create a new page or tab on the webpage

      // Open new page
    //  Page page = context.newPage();

      // Go to https://www.wego.co.in/
      page.navigate("https://www.wego.co.in/");

      // Click text=One-wayRound-tripMulti-city
      page.click("text=One-wayRound-tripMulti-city");
      // Click [placeholder="to"]
      page.click("[placeholder=\"to\"]");

      page.fill("[placeholder=\"to\"]", "Delhi");

//      // Click :nth-match([placeholder="to"], 2)
//      page.click(":nth-match([placeholder=\"to\"], 2)");
//
//      // Fill :nth-match([placeholder="to"], 2)
//      page.fill(":nth-match([placeholder=\"to\"], 2)", "");
//
//      // Press CapsLock
//      page.press(":nth-match([placeholder=\"to\"], 2)", "CapsLock");

      // Click text=New Delhi, India
      page.click("text=New Delhi, India");

      // Click [placeholder="Depart"]
      page.click("[placeholder=\"Depart\"]");

      // Click i:has-text("7")
      page.click("i:has-text(\"7\")");

      // Click text=One-way
      page.click("text=One-way");

      // Click button:has-text("Search")
      // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://sp.booking.com/searchresults.html?aid=2192615&city=-2094230&label=compareunits&utm_source=wego&utm_medium=SPPC&utm_content=bookables&utm_campaign=row&utm_term=ufi-M2094230&checkin_monthday=07&checkin_year_month=2022-04&checkout_monthday=08&checkout_year_month=2022-04&no_rooms=1&group_adults=1&group_children=0"), () ->
      page.click("button:has-text(\"Search\")");
      page.waitForNavigation(() -> {
        Page page1 = page.waitForPopup(() -> {
         
        });
      });
      // assert page.url().equals("https://handoff.wego.com/compare/flights/continue?departure_airport_code=BLR&departure_country_code=IN&arrival_city_code=DEL&arrival_country_code=IN&departure_date=2022-04-07&site_code=IN&locale=en&placement_type=home&provider_id=1210&pre_checked=true&outbound_date=2022-04-07&cabin=economy&currency_code=INR&adults_count=1&wc=3abfffb8-5e3f-40be-8571-90dd1edd669d&ws=efe1c62a-2c62-4374-b9c2-56d1bbaa985a");

      // Click text=Bookotrip >> #checkbox
      Page page1 = browser.newPage();
      page1.click("text=Bookotrip >> #checkbox");
      // assert page1.url().equals("https://www.wego.co.in/flights/searches/BLR-cDEL-2022-04-07/economy/1a:0c:0i?sort=price&order=asc&provider_codes=bookotrip.in");

      // Click text=Includes ₹-,419 payment feeBookotrip₹7,964 Total price View Deals View Deal >> :nth-match(#btn, 2)
      page1.click("text=Includes ₹-,419 payment feeBookotrip₹7,964 Total price View Deals View Deal >> :nth-match(#btn, 2)");

      // Click #options >> text=7,964
      page1.click("#options >> text=7,964");

      // Click span:has-text("View Deal")
      // page1.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://www.bookotrip.in/flights/air-result/6424e313-5bda-487b-a641-f65b6dcac191/gel-1?wego_click_id=83b945472f71485da598dadc70efeb20"), () ->
      page1.waitForNavigation(() -> {
        Page page2 = page1.waitForPopup(() -> {
          page1.click("span:has-text(\"View Deal\")");
        });
      });
      
      Page page2 = browser.newPage();

      // Click a:has-text("Credit Card")
      page2.click("a:has-text(\"Credit Card\")");

      // Click text=Master Card
      page2.click("text=Master Card");

      // Click text=8,581.21
      page2.click("text=8,581.21");
      
      page.close();
    }
  }
