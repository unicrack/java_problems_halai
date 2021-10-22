import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Factory {
    public interface Driver {
        void getDriver();
    }

    public class Chrome implements Driver {
        public void getDriver() {
            System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
            WebDriver driver = new ChromeDriver();
        }
    }

    public class Firefox implements Driver {
        public void getDriver() {
            System.setProperty("webdriver.firefox.driver", "./firefoxdriver.exe");
            WebDriver driver = new FirefoxDriver();
        }
    }

    public abstract class Instance {
        public abstract Driver getInstance();
    }

    public class ChromeInstance extends Instance {
        @Override
        public Driver getInstance() {
            return new Chrome();
        }
    }

    public class FirefoxInstance extends Instance {
        @Override
        public Driver getInstance() {
            return new Firefox();
        }
    }
}
/* Экземпляр драйвера должен быть получен в тестовом классе инструкцией
WebDriver driver = Factory.ChromeInstance.getInstance();
или
WebDriver driver = Factory.FirefoxInstance.getInstance();
Но у меня не получилось, ошибку я так и не нашёл */