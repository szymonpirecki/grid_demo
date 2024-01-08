import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class GridDemoTest {

    private WebDriver driver;


    @SneakyThrows
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox", "MicrosoftEdge"})
    public void demoTest1(String browser) {
        setUp(browser);
        driver.get("https://www.selenium.dev");
        Thread.sleep(10000);
        assertThat(driver.getTitle()).isEqualTo("Selenium");
    }
//
//    @SneakyThrows
//    @ParameterizedTest
//    @ValueSource(strings = {"chrome", "firefox", "MicrosoftEdge"})
//    public void demoTest2(String browser) {
//        setUp(browser);
//        driver.get("https://www.selenium.dev");
//        Thread.sleep(10000);
//        assertThat(driver.getTitle()).isEqualTo("Selenium");
//    }
//
//    @SneakyThrows
//    @ParameterizedTest
//    @ValueSource(strings = {"chrome", "firefox", "MicrosoftEdge"})
//    public void demoTest3(String browser) {
//        setUp(browser);
//        driver.get("https://www.selenium.dev");
//        Thread.sleep(10000);
//        assertThat(driver.getTitle()).isEqualTo("Selenium");
//    }
//
//    @SneakyThrows
//    @ParameterizedTest
//    @ValueSource(strings = {"chrome", "firefox", "MicrosoftEdge"})
//    public void demoTest4(String browser) throws MalformedURLException {
//        setUp(browser);
//        driver.get("https://www.selenium.dev");
//        Thread.sleep(10000);
//        assertThat(driver.getTitle()).isEqualTo("Selenium");
//    }
//
//    @SneakyThrows
//    @ParameterizedTest
//    @ValueSource(strings = {"chrome", "firefox", "MicrosoftEdge"})
//    public void demoTest5(String browser) {
//        setUp(browser);
//        driver.get("https://www.selenium.dev");
//        Thread.sleep(10000);
//        assertThat(driver.getTitle()).isEqualTo("Selenium");
//    }
//
//    @SneakyThrows
//    @ParameterizedTest
//    @ValueSource(strings = {"chrome", "firefox", "MicrosoftEdge"})
//    public void demoTest6(String browser) {
//        setUp(browser);
//        driver.get("https://www.selenium.dev");
//        Thread.sleep(10000);
//        assertThat(driver.getTitle()).isEqualTo("Selenium");
//    }
//
//    @SneakyThrows
//    @ParameterizedTest
//    @ValueSource(strings = {"chrome", "firefox", "MicrosoftEdge"})
//    public void demoTest7(String browser) {
//        setUp(browser);
//        driver.get("https://www.selenium.dev");
//        Thread.sleep(10000);
//        assertThat(driver.getTitle()).isEqualTo("Selenium");
//    }
//
//    @SneakyThrows
//    @ParameterizedTest
//    @ValueSource(strings = {"chrome", "firefox", "MicrosoftEdge"})
//    public void demoTest8(String browser) throws MalformedURLException {
//        setUp(browser);
//        driver.get("https://www.selenium.dev");
//        Thread.sleep(10000);
//        assertThat(driver.getTitle()).isEqualTo("Selenium");
//    }


    private void setUp(String browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setPlatform(Platform.WINDOWS);

        try {
            driver = new RemoteWebDriver(new URL("http://192.168.0.227:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}