package Utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.model.Media;

public class ListenerTest extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info(result.getName()+" is passed");
		test.log(Status.PASS, "Test Failed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");  
		   LocalDateTime now = LocalDateTime.now(); 
		File failScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir") +"//target//screenshot_"+dtf.format(now)+".png";
		try {
			FileHandler.copy(failScreenshot, new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()); 
		}
		test.log(Status.FAIL ,"Test Failed "+result.getThrowable());
		test.addScreenCaptureFromPath(destination);
		log.error(result.getName()+" is failed");
		}

	public void onTestSkipped(ITestResult result){
		// TODO Auto-generated method stub
		log.info(result.getName()+" is skipped");
		test.log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}



}
