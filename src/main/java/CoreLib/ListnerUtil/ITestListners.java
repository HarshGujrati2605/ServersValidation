package CoreLib.ListnerUtil;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListners implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println(result.getName() + " is failed");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println(result.getTestName() + " is passed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println(result.getName() + " is skipped..");
	}

}
