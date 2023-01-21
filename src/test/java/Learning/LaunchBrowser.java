package Learning;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false).
				setChannel("chrome"));  // Open the Chrome setChannel for open the our local chrome
		Page page = browser.newPage(); // new tab
		page.navigate("http://letscode.in/");
		String title = page.title();
		System.out.println("Page title: "+title);
		page.close();
		browser.close();
		playwright.close();


	}

}
