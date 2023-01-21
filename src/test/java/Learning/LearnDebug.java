package Learning;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.AriaRole;

public class LearnDebug {

	//Legacy locator(Old version)
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(setHeadless).newPage();
		page.navigate("https://bookcart.azurewebsites.net/");
		
		//Inspect
		page.pause();
		
		page.getByText("Login").click();
		page.getByLabel("Username").fill("ortoni");
		page.getByLabel("Password").fill("Pass1234$");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
				.setName("Login")).last().click();
		page.getByPlaceholder("Search books", new Page.GetByPlaceholderOptions()
				.setExact(false)).type("The Hookup");
		page.getByRole(AriaRole.OPTION).first().click();
		page.getByAltText("Book cover image").click();
		System.out.println(page.url());	

		playwright.close();
		
	}

}
