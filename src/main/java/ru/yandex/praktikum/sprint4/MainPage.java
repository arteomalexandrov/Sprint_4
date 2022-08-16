package ru.yandex.praktikum.sprint4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class MainPage {

    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
    }

    WebDriver driver;
    public final String pageUrl = "https://qa-scooter.praktikum-services.ru/";

    // Кнопка "Заказать" вверху страницы
    private final By headerButtonOrder = By.xpath("//*[contains(@class,'Header_')]/button[text()='Заказать']");
    // Кнопка "Заказать" внизу страницы
    private final By homeButtonOrder = By.xpath("//*[contains(@class,'Home_')]/button[text()='Заказать']");
    // Вопросы о важном
    private final By questionsButtonBlock = By.className("accordion__item");
    // Вопрос1
    final By questionButton1 = By.id("accordion__heading-0");
    // Вопрос2
    final By questionButton2 = By.id("accordion__heading-1");
    // Вопрос3
    final By questionButton3 = By.id("accordion__heading-2");
    // Вопрос4
    final By questionButton4 = By.id("accordion__heading-3");
    // Вопрос5
    final By questionButton5 = By.id("accordion__heading-4");
    // Вопрос6
    final By questionButton6 = By.id("accordion__heading-5");
    // Вопрос7
    final By questionButton7 = By.id("accordion__heading-6");
    // Вопрос8
    final By questionButton8 = By.id("accordion__heading-7");

    // ответы на вопросы
    final By answerText1 = By.xpath("//*[@id='accordion__panel-0']//p");
    final By answerText2 = By.xpath("//*[@id='accordion__panel-1']//p");
    final By answerText3 = By.xpath("//*[@id='accordion__panel-2']//p");
    final By answerText4 = By.xpath("//*[@id='accordion__panel-3']//p");
    final By answerText5 = By.xpath("//*[@id='accordion__panel-4']//p");
    final By answerText6 = By.xpath("//*[@id='accordion__panel-5']//p");
    final By answerText7 = By.xpath("//*[@id='accordion__panel-6']//p");
    final By answerText8 = By.xpath("//*[@id='accordion__panel-7']//p");

    // Найди блок вопросов и сделай скролл до него
    public MainPage scrollForQuestionsBlock() {
        WebElement element = driver.findElement(questionsButtonBlock);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    // метод для клика по вопросам и получение текста ответов
    public String getAnswerText(By locatorQuestion, By locatorAnswer) {
        driver.findElement(locatorQuestion).click();
        return driver.findElement(locatorAnswer).getText();
        }

    // метод для перехода к форме заказа вверху страницы
    public void clickHeaderButtonOrder() {
        driver.findElement(headerButtonOrder).click();
    }

    // метод для перехода к форме заказа внизу страницы
    public void clickHomeButtonOrder() {
        WebElement element = driver.findElement(homeButtonOrder);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(homeButtonOrder).click();
    }

}