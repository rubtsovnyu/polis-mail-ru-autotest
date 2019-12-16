package core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import model.TestBot;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private final String loginFormSlr = "form[action='https://www.ok.ru/https']";
    private final String inputLoginSlr = "input[data-l$=login]";
    private final String inputPasswordSlr = "input[data-l$=password]";

    public LoginPage() {
        super();
    }

    public void doLogin(TestBot testBot) {
        typeInInputField($(inputLoginSlr), testBot.getLogin());
        typeInInputField($(inputPasswordSlr), testBot.getPassword());
        $(loginFormSlr).submit();
    }

    private void typeInInputField(final SelenideElement inputFieldElement, final String value) {
        inputFieldElement.sendKeys(value);
    }

    @Override
    protected void check() {
        $(loginFormSlr).shouldBe(Condition.visible.because("Login form should be visible to be able to log in"));
    }
}
