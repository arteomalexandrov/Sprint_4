package ru.yandex.praktikum.sprint4;

import org.junit.Assert;
import org.junit.Test;

public class SeleniumTest extends BaseTest {

    // тесты на проверку текстов на вопросы
    @Test
    public void test1() {
        // создай объект класса главной страницы приложения
        MainPage mainPage = new MainPage(driver);
        String actual;
        actual = String.valueOf(mainPage
                .scrollForQuestionsBlock()
                .getAnswerText(mainPage.questionButton1, mainPage.answerText1));
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        // создай объект класса главной страницы приложения
        MainPage mainPage = new MainPage(driver);
        String actual;
        actual = String.valueOf(mainPage
                .scrollForQuestionsBlock()
                .getAnswerText(mainPage.questionButton2, mainPage.answerText2));
        String expected = "Пока что у нас так: один заказ — один самокат. " +
                "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        Assert.assertEquals(expected, actual);
    }

   @Test
    public void test3() {
        // создай объект класса главной страницы приложения
        MainPage mainPage = new MainPage(driver);
        String actual;
        actual = String.valueOf(mainPage
                .scrollForQuestionsBlock()
                .getAnswerText(mainPage.questionButton3, mainPage.answerText3));
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        // создай объект класса главной страницы приложения
        MainPage mainPage = new MainPage(driver);
        String actual;
        actual = String.valueOf(mainPage
                .scrollForQuestionsBlock()
                .getAnswerText(mainPage.questionButton4, mainPage.answerText4));
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        // создай объект класса главной страницы приложения
        MainPage mainPage = new MainPage(driver);
        String actual;
        actual = String.valueOf(mainPage
                .scrollForQuestionsBlock()
                .getAnswerText(mainPage.questionButton5, mainPage.answerText5));
        String expected = "Пока что нет! " +
                "Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        // создай объект класса главной страницы приложения
        MainPage mainPage = new MainPage(driver);
        String actual;
        actual = String.valueOf(mainPage
                .scrollForQuestionsBlock()
                .getAnswerText(mainPage.questionButton6, mainPage.answerText6));
        String expected = "Самокат приезжает к вам с полной зарядкой. " +
                "Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. " +
                "Зарядка не понадобится.";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        // создай объект класса главной страницы приложения
        MainPage mainPage = new MainPage(driver);
        String actual;
        actual = String.valueOf(mainPage
                .scrollForQuestionsBlock()
                .getAnswerText(mainPage.questionButton7, mainPage.answerText7));
        String expected = "Да, пока самокат не привезли. " +
                "Штрафа не будет, объяснительной записки тоже не попросим. " +
                "Все же свои.";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test8() {
        // создай объект класса главной страницы приложения
        MainPage mainPage = new MainPage(driver);
        String actual;
        actual = String.valueOf(mainPage
                .scrollForQuestionsBlock()
                .getAnswerText(mainPage.questionButton8, mainPage.answerText8));
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        Assert.assertEquals(expected, actual);
    }

    // тесты на проверку заказа самоката вверху страницы
    @Test
    public void test9() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickHeaderButtonOrder();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderFormPart1("Пётр", "Петров", "Ленина, 25", "сокольники", "89031505050");
        orderPage.fillOrderFormPart2("Как выйдете из метро, позвоните по указанному телефону");
        orderPage.confirmOrder();
        String expected = "Посмотреть статус";
        String actual = orderPage.getTextOrderHasBeenPlacedButton(orderPage.buttonOrderStatus);
        Assert.assertEquals(expected, actual);
        }

    @Test
    public void test10() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickHeaderButtonOrder();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderFormPart1("Иван", "Иванов", "Ленина, 25", "баграти", "89031505060");
        orderPage.fillOrderFormPart2("Буду в красной футболке");
        orderPage.confirmOrder();
        String expected = "Посмотреть статус";
        String actual = orderPage.getTextOrderHasBeenPlacedButton(orderPage.buttonOrderStatus);
        Assert.assertEquals(expected, actual);
    }

    // тесты на проверку заказа самоката внизу страницы
    @Test
    public void test11() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickHomeButtonOrder();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderFormPart1("Кирилл", "Кириллов", "Можайское шоссе, 1", "слав", "89031505070");
        orderPage.fillOrderFormPart2("Из метро выход налево");
        orderPage.confirmOrder();
        String expected = "Посмотреть статус";
        String actual = orderPage.getTextOrderHasBeenPlacedButton(orderPage.buttonOrderStatus);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test12() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickHomeButtonOrder();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderFormPart1("Борис", "Борисов", "Ленина, 25", "слав", "89031505080");
        orderPage.fillOrderFormPart2("Возле метро буду ждать");
        orderPage.confirmOrder();
        String expected = "Посмотреть статус";
        String actual = orderPage.getTextOrderHasBeenPlacedButton(orderPage.buttonOrderStatus);
        Assert.assertEquals(expected, actual);
    }

}