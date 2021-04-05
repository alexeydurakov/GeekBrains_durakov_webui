package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CRM_EX2 {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static final WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();

        // Класс настроек Chrome browser https://chromedriver.chromium.org/capabilities
        ChromeOptions options = new ChromeOptions();

        // Полный перечень https://peter.sh/experiments/chromium-command-line-switches/
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }

    public static void main( String[] args ) throws InterruptedException {
        login();

        // Клик на кнопку "Контрагенты"
        driver.findElement(By.xpath("//span[contains(.,'Контрагенты')]")).click();

        // Клик на "Контактные лица"
        driver.findElement(By.xpath("//span[contains(.,'Контактные лица')]")).click();

        // кликаем на кнопку Создать контактное лицо
        driver.findElement(By.linkText("Создать контактное лицо")).click();

        sleep(2000);

        // заполняем поле Фамилия
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Hull");
        // заполняем поле Имя
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Shaun");

        sleep(2000);

        // ОРГАНИЗАЦИЯ
        driver.findElement(By.cssSelector(".select2-input")).click();
        driver.findElement(By.cssSelector(".select2-input")).sendKeys("1234");

        // заполняем поле Должность
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("REPO");

        //Сохранить и закрыть
        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();

        driver.quit();
    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);

        // используем имя тега
        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);

        // используем имя класса
        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        // используя xpath
        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();
    }
}
