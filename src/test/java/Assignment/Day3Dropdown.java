package Assignment;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Day3Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(headless).newPage();
//		page.navigate("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
//
//		page.selectOption("#select-demo", "Monday");
//		String selectedMsg = page.locator("p.selected-value.text-size-14").textContent();
//		System.out.println(selectedMsg);
//
//		Locator states = page.locator("#multi-select");
//		states.selectOption(new SelectOption().setLabel("California"));
//		page.locator("button[value='Print First']").click();
//
//			Locator countryDD = page.locator("select[name='States']");
//			countryDD.selectOption(new String[] {"California","New Jersey","Pennsylvania","Washington"}); 
//			page.locator("button[value='Print All']").click();
//
//		String firstSelectedMsg = page.locator("//p[text()='First selected option is : ']").textContent();
//		System.out.println(firstSelectedMsg);
//
//			String optionSelected = page.locator("//p[text()='Options selected are : ']").textContent();
//			System.out.println(optionSelected);
		
		page.navigate("https://testsheepnz.github.io/BasicCalculator.html#main-body");
		page.fill("#number1Field", "5");
		page.fill("#number2Field","5");
		page.selectOption("#selectOperationDropdown", "0");
		page.locator("#calculateButton").click();
		String answerAdd = page.locator("#numberAnswerField").inputValue();
		System.out.println("Answer for Addition:" +answerAdd);
		page.locator("#clearButton").click();
		
		page.fill("#number1Field", "15");
		page.fill("#number2Field","15");
		page.selectOption("#selectOperationDropdown", "2");
		page.locator("#calculateButton").click();
		String answerMul = page.locator("#numberAnswerField").inputValue();
		System.out.println("Answer for Mul:" +answerMul);
		page.locator("#clearButton").click();
		
		page.close();
		playwright.close();
		
		
		
		
		
	}

}
