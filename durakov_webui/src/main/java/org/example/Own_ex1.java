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

public class Own_ex1 {
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

        //Переход на статьи
        driver.findElement(By.xpath("//ul[@id='menu']/li[2]/a")).click();

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
