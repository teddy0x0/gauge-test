import org.openqa.selenium.WebDriver
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.chrome.ChromeDriver

object DriverFactory {
    // Get a new WebDriver Instance.
    // There are various implementations for this depending on browser. The required browser can be set as an environment variable.
    // Refer http://getgauge.io/documentation/user/current/managing_environments/README.html
    val driver: WebDriver
        get() {
            var browser = System.getenv("BROWSER")
            browser = browser ?: "CHROME"
            return when (browser) {
                "IE" -> {
                    WebDriverManager.iedriver().setup()
                    InternetExplorerDriver()
                }
                "FIREFOX" -> {
                    WebDriverManager.firefoxdriver().setup()
                    FirefoxDriver()
                }
                "CHROME" -> {
                    WebDriverManager.chromedriver().setup()
                    val options = ChromeOptions()
                    if ("Y".equals(System.getenv("HEADLESS"), ignoreCase = true)) {
                        options.addArguments("--headless")
                        options.addArguments("--disable-gpu")
                    }
                    ChromeDriver(options)
                }
                else -> {
                    WebDriverManager.chromedriver().setup()
                    val options = ChromeOptions()
                    if ("Y".equals(System.getenv("HEADLESS"), ignoreCase = true)) {
                        options.addArguments("--headless")
                        options.addArguments("--disable-gpu")
                    }
                    ChromeDriver(options)
                }
            }
        }
}