package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{
  private int retrycount=0;
  private static final int MAX_RETRY_COUNT=0;
	@Override
	public boolean retry(ITestResult result) {
		if (retrycount<MAX_RETRY_COUNT) {
			retrycount++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
