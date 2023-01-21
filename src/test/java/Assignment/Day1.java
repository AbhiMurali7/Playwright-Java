package Assignment;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Day1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.google.com/");
		String title = page.title();
		System.out.println("Page Title :" + title);
		String url = page.url();
		System.out.println("Page URL :" + url);
		page.close();
		browser.close();
		playwright.close();	
	}

}
