package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Own_ex2 {
    private static final String LOGIN_PAGE_URL = "https://www.fishing.ru";
    private static final String MY_LOGIN = "alexey.durakov@yandex.ru";
    private static final String MY_PASSWORD = "200566";
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

        //Клик на кнопку форум
        driver.findElement(By.linkText("Форум")).click();

        //Переход на ветку Базы и отели
        driver.findElement(By.linkText("Базы и отели")).click();

        //Переход на тему Гостевые дома Купола Карелии
        driver.findElement(By.linkText("Гостевые дома Купола Карелии")).click();

        //Поиск сообщения
        driver.findElement(By.cssSelector("#post-847578 .messageText")).click();

        //перемещаемся наверх
        driver.findElement(By.cssSelector(".button-scroll-top > a")).click();

        //переход на главную
        driver.findElement(By.xpath("//span/a/span")).click();

        //выход
        logout();

        driver.quit();
    }

    private static void login() {
        driver.get(LOGIN_PAGE_URL);

        // используем имя тега
        WebElement loginTextInput = driver.findElement(By.xpath("//dd/input"));
        loginTextInput.sendKeys(MY_LOGIN);

        // используем имя класса
        WebElement passwordTextInput = driver.findElement(By.xpath("//li[3]/input"));
        passwordTextInput.sendKeys(MY_PASSWORD);

        // используя xpath
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Вход']"));
        loginButton.click();
    }

    private static void logout(){
        driver.findElement(By.linkText("alexey.durakov")).click();
        driver.findElement(By.linkText("Выход")).click();
    }
}
