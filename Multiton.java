import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Multiton {
    enum BrowserNames {
        CHROME,FIREFOX
    }
    // экземпляр класса Multiton
    private static Multiton instance;
    private WebDriver driver;

    // конструктор
    private Multiton(BrowserNames browserName) {

        switch(browserName) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.firefox.driver", "./firefoxdriver.exe");
                driver = new FirefoxDriver();
                break;
        }

    }

    // создание экземпляра класса
    public static synchronized Multiton getInstance(BrowserNames browserName) {
        if (instance == null) {
            instance = new Multiton(browserName);
        }
        return instance;
    }

    // получение драйвера
    public WebDriver getDriver() {
        return driver;
    }
}
/* Экземпляр драйвера получаем в тестовом классе инструкцией
WebDriver driver = Multiton.getInstance(Multiton.BrowserNames.CHROME).getDriver();
или
WebDriver driver = Multiton.getInstance(Multiton.BrowserNames.FIREFOX).getDriver(); */
