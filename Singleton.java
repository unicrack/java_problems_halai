import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Singleton {
    // экземпляр класса Singleton
    private static Singleton instance;
    private WebDriver driver;

    // конструктор
    private Singleton() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver = new ChromeDriver();
    }

    // создание экземпляра класса
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // получение драйвера
    public WebDriver getDriver() {
        return driver;
    }
}
/* Экземпляр драйвера получаем в тестовом классе инструкцией
 WebDriver driver = Singleton.getInstance().getDriver(); */