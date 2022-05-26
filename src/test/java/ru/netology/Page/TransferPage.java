package ru.netology.Page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {

    public static DashboardPage transferMoneyToFirstCard(int transferAmount, String secondNumberCard) {
        $("[data-test-id='amount'] input").setValue(String.valueOf(transferAmount));
        $("[data-test-id='from'] input").setValue(secondNumberCard);
        $("[class='button__text']").click();
        return new DashboardPage();
    }

    public static DashboardPage transferMoneyToSecondCard(int transferAmount, String firstNumberCard) {
        $("[data-test-id='amount'] input").setValue(String.valueOf(transferAmount));
        $("[data-test-id='from'] input").setValue(firstNumberCard);
        $("[class='button__text']").click();
        return new DashboardPage();
    }
}

