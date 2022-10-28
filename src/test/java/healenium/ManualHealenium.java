package healenium;

import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class ManualHealenium {

    private WebDriver delegate;
    private SelfHealingDriver driver;


    @Before
    public void navegadorChrome() {

        WebDriverManager.chromedriver().setup();
       // System.setProperty("webdriver.chrome.driver", "./src/test/resources/webdriver/chromedriver.exe");
        //declare delegate
        delegate = new ChromeDriver();
        //create Self-healing driver
        driver = SelfHealingDriver.create(delegate);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

    }

    @Test
    public void iniciarPrueba() throws InterruptedException {

        // CREAR UN OBJETO DE LA PAGINA PRINCIPAL
        WebElement txtGmail = driver.findElement(By.xpath("//a[text()='Gmail']"));
        // TOMAR CAPTURA DE PANTALLA
        //((TakesScreenshot)driver.getDelegate()).getScreenshotAs(OutputType.BYTES);
        txtGmail.click();


        WebElement btnIniciarSesion = driver.findElement(By.xpath("//a[text()='Inicia sesión']"));
        btnIniciarSesion.click();


        WebElement txtCorreo = driver.findElement(By.cssSelector("#identifierId"));
        txtCorreo.sendKeys("prueba2022@gmail.com");
        Thread.sleep(2000);

        String titulo = driver.getTitle();
        System.out.println("Hola mvn clean test" + titulo);

    }

    @After
    public void cerrarNavegador() {
        driver.quit();
    }

}
