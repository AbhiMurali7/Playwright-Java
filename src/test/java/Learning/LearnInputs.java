package Learning;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnInputs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false).
				setChannel("chrome"));  // Open the Chrome setChannel for open the our local chrome
		Page page = browser.newPage(); // new tab
		page.navigate("https://letcode.in/edit");
		// page.fill("#fullName", "Abinaya");    // Another way to pass value
		page.locator("#fullName").type("Abinaya");
		Locator locator = page.locator("#join");
		locator.press("End"); //press the field
		locator.type(" man"); //Append text + press
		locator.press("Tab"); 
		
		String attribute = page.locator("id=getMe").getAttribute("value");
		System.out.println(attribute);  //get value from field box
		
		page.locator("//input[@value='Koushik Chatterjee']").clear();


	}

}
