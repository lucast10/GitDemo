import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngPractice {
	
		
	/*	@BeforeSuite
		public void starting() {
			//WebDriver driver = new ChromeDriver();
			//driver.get("https://www.google.com");
			//driver.manage().window().maximize();
			System.out.println("Before");
		}
		
		@Parameters({"URL"})
		@Test(groups={"grupo"})
		public void quickTest(String urlsite) {
			System.out.println("Test"+urlsite);
		}
		
		@Test(groups={"grupo"})
		public void anotherQuickTest() {
			System.out.println("Test 2");
		}
		
		@Test(enabled=false)
		public void anotherQuickTest2() {
			System.out.println("Test 2");
		}
		
		@Test(timeOut=4000)
		public void anotherQuickTest3() {
			System.out.println("Test 2");
		}
		
		@Test(dependsOnMethods={"quickTest","anotherQuickTest"})
		public void anotherQuickTest4() {
			System.out.println("Test 2");
		}
		*/
		@Test(dataProvider="getData")
		public void anotherQuickTest5(String gotData, String gotAnother) {
			System.out.println("Test 2");
			System.out.println("gotData");
			System.out.println("gotAnother");
		}
		
		@DataProvider()
		public Object[][] getData() {
			Object[][] data = new Object[3][2];
			
			data[0][0]="test1"; data[0][1]="test4";
			data[1][0]="test5"; data[1][1]="test2";
			data[2][0]="test6"; data[2][1]="test3";
			
			
			return data;
		}
		
		@Parameters({"URL","API"})
		@Test
		public void enterAPI(String urlname, String apikey) {
			System.out.println(urlname);
			System.out.println(apikey);
		}
		
		@AfterSuite
		public void finalization() {
			System.out.println("End");
		}
	
	
}