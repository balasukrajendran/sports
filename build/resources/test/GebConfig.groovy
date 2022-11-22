import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.Dimension
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.WebDriver;



waiting {
    timeout = 30
}

environments {

    String chromeBrowserDir = '\\build\\resources\\test\\'

    "chrome" {
        def chromeDriver = new File('build/resources/test/chromedriver.exe') // add .exe for Windows...
        System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)

        driver = { new ChromeDriver() }
    }

}

