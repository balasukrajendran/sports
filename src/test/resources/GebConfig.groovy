
import org.openqa.selenium.chrome.ChromeOptions;



waiting {
    timeout = 30
}

environments {

    String chromeBrowserDir = '\\build\\resources\\test\\'

    "chrome" {
        def chromeDriver = new File('build/resources/test/chromedriver.exe') // add .exe for Windows...
        System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)
//---
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=420,842")
        if (System.properties.get("headless").toString().equalsIgnoreCase("true")) {
            options.addArguments("--headless")
        }
      /
        driver = {new ChromeDriver(options)}

    }

}

