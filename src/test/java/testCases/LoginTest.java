package testCases;



import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.BaseClass;
import Utils.FileHandling;
import pages.LoginPage;

public class LoginTest extends BaseClass{
@Test(priority = 0)
public void launchUrl(Method method) {
	test =extent.createTest(method.getName());
	driver.get("https://opensource-demo.orangehrmlive.com/");
	Assert.assertEquals("OrangeHRM", driver.getTitle());
}
@Test(priority = 1,dataProvider = "logindata")
public void login(String username,String password,Method method) throws InterruptedException {
	test =extent.createTest(method.getName());
	loginPage.enterUsername(username).enterPassword(password).clickLogin();
	Thread.sleep(3000);
	if(username.equals("admin")) {
	Assert.assertEquals(true, false);
	}
}
@DataProvider(name = "logindata")
public Object[][] getLoginData() throws IOException{
	return FileHandling.getDataFromExcel("src//test//resources//datasheet.xlsx", "login");
}

}
