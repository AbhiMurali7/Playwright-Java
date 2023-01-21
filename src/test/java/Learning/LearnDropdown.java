package Learning;

import java.util.List;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class LearnDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright .chromium().launch(headless).newPage();
		page.navigate("https://letcode.in/dropdowns");
		
		//SelectOption
//		page.selectOption("#fruits", "1");   
		
		//Using ElementHandle
		Locator fruitsDD = page.locator("#fruits");
//		fruitsDD.selectOption("1");
		
		//Select by Label(Text)
//		fruitsDD.selectOption(new SelectOption().setLabel("Banana"));
		
		//Select by Index
		fruitsDD.selectOption(new SelectOption().setIndex(3));
		
		String notificationMsg = page.locator("//div[@class='notification is-success']//p[1]").textContent();
		System.out.println(notificationMsg); 
		
		//How to select multiple values
		Locator herosDD = page.locator("#superheros");
		herosDD.selectOption(new String[] {"aq","ca","cm","bt"});  //shouldn't pass Label and Index
		
		
		Locator langDD = page.locator("#lang");
		Locator options = langDD.locator("option");
		
		//Print the options
		List<String> allInnerTexts = options.allInnerTexts();
		allInnerTexts.forEach(i-> System.out.println(i));
		
		//Find Options length
		int count = options.count();
		System.out.println("Length:" +count);
		
		//Select the last options in dropdown values
		langDD.selectOption(new SelectOption().setIndex(count-1));
		
		
		
	}

}
