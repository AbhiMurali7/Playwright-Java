package Assignment;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Day2Input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false).
				setChannel("chrome"));
		Page page = browser.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground/input-form-demo");
		page.fill("id=name","VenvelSenni");
		page.type("#inputEmail4", "vel12@outlook.com");
		page.locator("(//div[contains(@class,'form-group w-4/12')]//input)[3]")
							.type("Password");
		
		page.fill("//label[@for='companyname']/following-sibling::input[1]", "XYZ");
		page.type("id=websitename", "www.xyz.com");
		Locator country = page.locator("select[name='country']");
		country.selectOption(new SelectOption().setLabel("India"));
		page.locator("#inputCity").fill("Chennai");
		page.fill("#inputAddress1", "Test Address1");
		page.fill("#inputAddress2", "Test Address2");
		page.type("#inputState", "TamilNadu");
		page.type("#inputZip", "367892");
		page.locator("//button[text()='Submit']").click();
		
		String successMsg = page.locator("//p[@class='success-msg hidden']")
				.textContent();
		System.out.println(successMsg); 
		
		page.close();
		browser.close();
		playwright.close();
		
	}

}
