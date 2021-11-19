import kotlin.Throws
import java.lang.InterruptedException
import org.openqa.selenium.By
import com.thoughtworks.gauge.Gauge
import com.thoughtworks.gauge.Step
import org.assertj.core.api.Assertions
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Condition.*

class StepImplementation2 {
    @Step("Go to Gauge Get Started Page2")
    @Throws(InterruptedException::class)
    fun gotoGetStartedPage() {
        val getStartedButton = Driver.webDriver?.findElement(By.xpath("//a[@href='https://docs.gauge.org/getting_started/installing-gauge.html']"))
        getStartedButton?.click()
        Gauge.writeMessage("Page title is %s", Driver.webDriver!!.title)
    }

    @Step("Ensure installation instructions are available")
    @Throws(InterruptedException::class)
    fun ensureInstallationInstructionsAreAvailable() {
        val instructions = Driver.webDriver?.findElement(By.xpath("//a[@href='/writing-specifications.html']"))
        Assertions.assertThat(instructions).isNotNull
    }

    @Step("Open the Gauge homepage")
    fun implementation1() {
        val app_url = System.getenv("APP_URL")
        Driver.webDriver?.get("$app_url/")
        Assertions.assertThat(Driver.webDriver!!.title).contains("Gauge")

        `$`(".evaluation").find("aaa").shouldBe(text("aaaaa"))
    }
}