package Learning;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Download;

public class LearnDownload {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(setHeadless).newPage();
		page.navigate("https://letcode.in/file");
		
		// Wait for the download to start
		Download download = page.waitForDownload(()->{			
			page.locator("'Download Excel'").click();
		});
		
		// Wait for the download process to complete
		System.out.println(download.path());
		System.out.println(download.url());
		System.out.println(download.failure());
		System.out.println(download.suggestedFilename());
		
//		 Save downloaded file somewhere
		download.saveAs(Paths.get(download.suggestedFilename()));
		
		playwright.close();
		
		
	}

}
