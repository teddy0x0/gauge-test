import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.thoughtworks.gauge.Step

class Web {
    @Step("ログインページが表示されていること")
    fun displayLoginPage() {
        `$`(".login").shouldBe(Condition.visible)
    }
}