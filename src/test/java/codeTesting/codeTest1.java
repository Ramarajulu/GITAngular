package codeTesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class codeTest1 {

	public static void main(String[] args) throws Exception {

		File file = new File(
				"C:\\Users\\Ramarajulu.M\\workspace\\WebdriverTest\\src\\test\\java\\example\\SampleCode.java");

		boolean boolWebDriver = false;
		boolean boolMethod = false;
		boolean boolChromeDriver = false;
		boolean boolURL = false;
		boolean boolUserName = false;
		boolean boolPassword = false;

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		while ((st = br.readLine()) != null) {
			if (st.contains("WebDriver") && st.lastIndexOf("//") == -1) {
				System.out.println(st.trim());
				boolWebDriver = true;
			}
			if (st.contains("methodName")) {
				System.out.println(st.trim());
				boolMethod = true;
			}
			if(st.contains("ChromeDriver")) {
				System.out.println(st.trim());
				boolChromeDriver = true;
			}
			if(st.contains("driver.get")) {
				System.out.println(st.trim());
				boolURL = true;
			}
			if(st.contains("deeksha.singh@parthenonglobal.com")) {
				System.out.println(st.trim());
				boolUserName = true;
			}
			if(st.contains("dsrc12345566")) {
				System.out.println(st.trim());
				boolPassword = true;
			}
		}
		if (boolWebDriver == false) {
			System.out.println("WEBDRIVER NOT ASSIGNED");
		}
		if (boolMethod == false) {
			System.out.println("METHOD NAME INCORRECT");
		}
		if (boolChromeDriver == false) {
			System.out.println("CHROME DRIVER NOT ASSIGNED ");
		}
		if (boolURL == false) {
			System.out.println("URL NOT ASSIGNED");
		}
		if (boolUserName == false) {
			System.out.println("USERNAME INCORRECT");
		}
		if (boolPassword == false) {
			System.out.println("PASSWORD INCORRECT");
		}

	}

}
