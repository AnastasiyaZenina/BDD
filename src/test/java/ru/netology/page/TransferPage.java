package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {
    private static SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private static SelenideElement amountInput = $("[data-test-id='amount'] input");
    private static SelenideElement fromInput = $("[data-test-id='from'] input");
    private SelenideElement transferHead = $(byText("Пополнение карты"));

    public static DashboardPage makeTransfer(int transferAmount, DataHelper.CardInfo cardInfo) {
        amountInput.setValue(String.valueOf(transferAmount));
        fromInput.setValue(cardInfo.getCardNumber());
        transferButton.click();
        return new DashboardPage();
    }
}

