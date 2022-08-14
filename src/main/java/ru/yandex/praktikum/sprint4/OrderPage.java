package ru.yandex.praktikum.sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    WebDriver driver;

    public OrderPage(WebDriver driver) {

        this.driver = driver;
    }

    // поле для ввода имени
    private final By inputName = By.xpath("//*[@placeholder='* Имя']");
    // поле для ввода фамилии
    private final By inputSurname = By.xpath("//*[@placeholder='* Фамилия']");
    // поле для ввода адреса
    private final By inputAddress = By.xpath("//*[@placeholder='* Адрес: куда привезти заказ']");
    // поле для ввода станции метро
    private final By inputMetroStation = By.xpath("//*[@placeholder='* Станция метро']");
    // метро items
    private final By metroItems = By.xpath("//*[@class='select-search__select']//button");
    // поле для ввода телефона
    private final By inputTelephone = By.xpath("//*[@placeholder='* Телефон: на него позвонит курьер']");
    // кнопка "Далее"
    private final By buttonNext = By.xpath("//button[text()='Далее']");
    // поле для ввода даты
    private final By inputData = By.xpath("//*[@placeholder='* Когда привезти самокат']");
    // дата items
    private final By dataItems = By.xpath("//*[contains(@class,'react-datepicker__day ')][3]");
    // поле для ввода срока аренды
    private final By inputRentalPeriod = By.xpath("//*[(@class='Dropdown-placeholder') and (text()='* Срок аренды')]");
    // период items
    private final By periodItems = By.xpath("//*[(@class='Dropdown-option') and contains(text(),'сут')]");
    // чекбокс для выбора черного самоката
    private final By checkboxColorBlack = By.xpath("//*[contains(@class,'Checkbox_Label') and text()='чёрный жемчуг']");
    // чекбокс для выбора серого самоката
    private final By checkboxColorGrey = By.xpath("//*[contains(@class,'Checkbox_Label') and text()='серая безысходность']");
    // поле для ввода комментария
    private final By inputComment = By.xpath("//*[@placeholder='Комментарий для курьера']");
    // кнопка "Назад"
    private final By buttonBack = By.xpath("//button[text()='Назад']");
    // кнопка "Заказать" на форме заказа
    private final By formButtonOrder = By.xpath("//button[2][text()='Заказать']");
    // модальное окно для подтверждения заказа
    private final By orderModal = By.xpath("//*[contains(@class,'Order_Modal') and (text()='Хотите оформить заказ?')]");
    // кнопка "Нет"
    private final By buttonNot = By.xpath("//button[text()='Нet']");
    // кнопка "Да"
    private final By buttonYes = By.xpath("//button[text()='Да']");
    // модальное окно "Заказ оформлен"
    final By orderHasBeenPlaced = By.xpath("//*[contains(@class,'Order_ModalHeader') and (text()='Заказ оформлен')]");
    // кнопка "Посмотреть статус"
    final By buttonOrderStatus = By.xpath("//*[contains(@class,'Button_Button__') and (text()='Посмотреть статус')]");//("//*[contains(@class,'Order_NextButton') and (text()='Посмотреть статус')]");


//*[@class='select-search__select']//button[.//div[text()='Сокольники']]

    public void fillOrderFormPart1(String name, String surname, String address, String metroStation, String telephone) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputSurname).sendKeys(surname);
        driver.findElement(inputAddress).sendKeys(address);
        driver.findElement(inputMetroStation).sendKeys(metroStation);
        driver.findElement(metroItems).click();
        driver.findElement(inputTelephone).sendKeys(telephone);
        driver.findElement(buttonNext).click();
    }

    public void fillOrderFormPart2(String comment) {
        driver.findElement(inputData).click();
        driver.findElement(dataItems).click();
        driver.findElement(inputRentalPeriod).click();
        driver.findElement(periodItems).click();
        driver.findElement(checkboxColorBlack).click();
        driver.findElement(inputComment).sendKeys(comment);
        driver.findElement(formButtonOrder).click();
    }

    public void confirmOrder() {

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.
                visibilityOfElementLocated(orderModal));
        driver.findElement(buttonYes).click();
    }

//    public String getTextOrderHasBeenPlaced(By orderHasBeenPlaced) {
//        return driver.findElement(this.orderHasBeenPlaced).getText();
//    }

    public String getTextOrderHasBeenPlacedButton(By locatorButtonOrderStatus) {
        return driver.findElement(locatorButtonOrderStatus).getText();
    }

}
