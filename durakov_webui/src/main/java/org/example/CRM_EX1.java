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


/**
 * Hello world!
 *
 */
public class CRM_EX1
{
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

        // Клик на кнопку "Проекты"
        driver.findElement(By.xpath("//span[contains(.,'Проекты')]")).click();

        // Клик на  "Мои проекты"
        driver.findElement(By.xpath("//span[contains(.,'Мои проекты')]")).click();

        // кликаем на кнопку Создать проект
        driver.findElement(By.linkText("Создать проект")).click();

        sleep(2000);

        // заполняем поле наименование
        driver.findElement(By.name("crm_project[name]")).sendKeys("popitka2");

        sleep(2000);

        // ОРГАНИЗАЦИЯ
        driver.findElement(By.xpath("//span[contains(.,'Укажите организацию')]")).click();
        driver.findElement(By.xpath("//span[contains(.,'Укажите организацию')]")).sendKeys("1234");

        sleep(2000);

        //Основное контактное лицо
        Select contactperson = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        contactperson.selectByVisibleText("Research & Development");

        sleep(2000);

        //Куратор проекта
        Select projectcurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        projectcurator.selectByVisibleText("Applanatest Applanatest Applanatest");

        sleep(2000);

        //Руководитель проекта
        Select projectmanager = new Select(driver.findElement(By.name("crm_project[rp]")));
        projectmanager.selectByVisibleText("Applanatest Applanatest Applanatest");

        sleep(2000);

        //Менеджер
        Select manager = new Select(driver.findElement(By.name("crm_project[rp]")));
        manager.selectByVisibleText("Гикбрейнс Студент");

        sleep(2000);

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
