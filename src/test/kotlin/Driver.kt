import com.thoughtworks.gauge.BeforeSuite
import com.thoughtworks.gauge.AfterSuite
import org.openqa.selenium.WebDriver

class Driver {
    // Initialize a webDriver instance of required browser
    // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the webDriver
    @BeforeSuite
    fun initializeDriver() {
        webDriver = DriverFactory.driver
    }

    // Close the webDriver instance
    @AfterSuite
    fun closeDriver() {
        webDriver!!.quit()
    }

    companion object {
        // Holds the WebDriver instance
        var webDriver: WebDriver? = null
    }
}