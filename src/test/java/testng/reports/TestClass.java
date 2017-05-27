package testng.reports;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

		@Test
		public void method1(){
			Assert.assertTrue(true);
		}

		@Test
		public void method2(){
			Assert.assertTrue(false);
		}
		
		@Test(dependsOnMethods={"method2"})
		public void method3(){
			Assert.assertTrue(true);
		}
	}


