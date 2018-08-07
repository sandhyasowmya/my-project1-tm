package Common_Methods;

import java.util.Set;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

/*import java.util.Set;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class TestListener  implements ITestListener {
	    @Override
		public void onFinish(ITestContext context) {
			Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
			for (ITestResult temp : failedTests) {
				ITestNGMethod method = temp.getMethod();
				if (context.getFailedTests().getResults(method).size() > 1) {
					failedTests.remove(temp);
				} else {
					if (context.getPassedTests().getResults(method).size() > 0) {
						failedTests.remove(temp);
					}
				}
			}
		}
	  
	    public void onTestStart(ITestResult result) {   }
	  
	    public void onTestSuccess(ITestResult result) {   }
	  
	    public void onTestFailure(ITestResult result) {   }

	    public void onTestSkipped(ITestResult result) {   }

	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

	    public void onStart(ITestContext context) {   }
	}  
*/
public class TestListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
			Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
			for (ITestResult temp : failedTests) {
				ITestNGMethod method = temp.getMethod();
				if (context.getFailedTests().getResults(method).size() > 1) {
					failedTests.remove(temp);
				}else {
					if (context.getPassedTests().getResults(method).size() > 0) {
						failedTests.remove(temp);
					}
				}
			}
		}
	}
	

