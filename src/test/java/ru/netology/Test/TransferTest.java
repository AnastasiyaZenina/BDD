package ru.netology.Test;

import org.junit.jupiter.api.Test;
import ru.netology.Data.DataHelper;
import ru.netology.Page.DashboardPage;
import ru.netology.Page.LoginPage;
import ru.netology.Page.TransferPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferTest {
    public int transferAmount = 4000;

    @Test
    void transferMoneyBetweenOwnCards() {
        open("http://localhost:9999");
        var LoginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = LoginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        int startBalanceCard1 = dashboardPage.getFirstCardBalance();
        int startBalanceCard2 = dashboardPage.getSecondCardBalance();
        var transferPage = dashboardPage.chooseCard1();
        String secondNumberCard = String.valueOf(DataHelper.getSecondNumber());
        TransferPage.transferMoneyToFirstCard(transferAmount, String.valueOf(secondNumberCard));

        var dashBoardPageAfterTransfer = new DashboardPage();
        int balanceCard1AfterTransfer = dashBoardPageAfterTransfer.getFirstCardBalance();
        int balanceCard2AfterTransfer = dashBoardPageAfterTransfer.getSecondCardBalance();

        int actual = startBalanceCard2 - transferAmount;
        int actual2 = startBalanceCard1 + transferAmount;
        assertEquals(actual, balanceCard2AfterTransfer);
        assertEquals(actual2, balanceCard1AfterTransfer);

    }

    @Test
    void transferMoneyBetweenOwnCardsBack() {
        open("http://localhost:9999");
        var LoginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = LoginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        int startBalanceCard1 = dashboardPage.getFirstCardBalance();
        int startBalanceCard2 = dashboardPage.getSecondCardBalance();
        var transferPage = dashboardPage.chooseCard2();
        String firstNumberCard = String.valueOf(DataHelper.getFirstNumber());
        TransferPage.transferMoneyToSecondCard(transferAmount, String.valueOf(firstNumberCard));

        var dashBoardPageAfterTransfer = new DashboardPage();
        int balanceCard1AfterTransfer = dashBoardPageAfterTransfer.getFirstCardBalance();
        int balanceCard2AfterTransfer = dashBoardPageAfterTransfer.getSecondCardBalance();

        int actual = startBalanceCard2 + transferAmount;
        int actual2 = startBalanceCard1 - transferAmount;
        assertEquals(actual, balanceCard2AfterTransfer);
        assertEquals(actual2, balanceCard1AfterTransfer);

    }
}