package Learning;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnLocators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(setHeadless).newPage();
		/*
		 * page.navigate("https://letcode.in/test");
		 * 
		 * //Link Text page.click("'Click'"); // Or // page.click("text=Click");
		 * 
		 * //has-Text page.locator("button:has-text('Goto Home')").click();
		 * 
		 * //Text() page.locator("nav :text('Product')").click();
		 */		
		page.navigate("http://127.0.0.1:5500/allText/index.html");
		
		//Visible
		page.locator("//button[@class='btn btn-primary'] >> visible=true").click();
		
		//Nth
		page.locator("button").locator("nth=1").click();
		System.out.println(page.locator("#attach").textContent());
		page.locator("button").locator("nth=-1").click();
		Thread.sleep(1000);
		System.out.println(page.locator("#attach").textContent());
		
		page.locator("#innerText, #innerText2").click();
		page.locator("//button[text()='Inner Text'] | //button[text()='Inner Text 1']").click();
		playwright.close();
	}

}
