package Assignment;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Day4BrowerContext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();

		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = browserType.launch(headless);

		BrowserContext context = browser.newContext(
				new Browser.NewContextOptions().setViewportSize(1920, 1000));
		
		// Screenshot Capture Start
		context.tracing().start(
				new Tracing.StartOptions()
				.setScreenshots(true)
				.setSnapshots(true) 
				.setSources(!true)  //Java source code
				);
		
		Page page = context.newPage();
		page.navigate("https://www.saucedemo.com/");
		page.locator("input[placeholder='Username']").type("standard_user");
		page.locator("input[type='password']").type("secret_sauce");
		page.getByText("Login").click();
		String title = page.title();
		System.out.println("Login Success:" + title);
		page.close();

//		BrowserContext context2 = browser.newContext(
//				new Browser.NewContextOptions().setViewportSize(1920, 1000));
//		Page newPage = context2.newPage();
//		newPage.navigate("https://demo.applitools.com/");
//		newPage.locator("#username").type("admin");
//		newPage.locator("#password").type("admin");
//		newPage.getByText("Sign in").click();
//		String title1 = page.title();
//		System.out.println("Login Success:" + title1);
//		newPage.close();
		
		// Screenshot Capture Stop
		context.tracing().stop(
				new Tracing.StopOptions()
				.setPath(Paths.get("trace.zip"))
				);

		context.close();

		playwright.close();

	}

}
