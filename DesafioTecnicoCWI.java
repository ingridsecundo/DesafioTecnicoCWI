package testes;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.JavascriptExecutor;

public class DesafioTecnicoCWI {

	private WebDriver driver;
	JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ingrid\\Documents\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("https://site.getnet.com.br/");
		driver.manage().window().setSize(new Dimension(1366, 728));
		driver.findElement(By.cssSelector(".c-mobile-header-item__content")).click();
		driver.findElement(By.id("search-trigger")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("global-search-input")).sendKeys("superget");
		driver.findElement(By.cssSelector(".o-btn--cor-roxo-borda")).click();
		js.executeScript("window.scrollTo(0,507)");
		driver.findElement(By.linkText("2")).click();
		js.executeScript("window.scrollTo(0,95)");
		driver.findElement(By.linkText("3")).click();
		js.executeScript("window.scrollTo(0,600)");
		js.executeScript("window.scrollTo(0,1100)");
		driver.findElement(By.linkText("4")).click();
		driver.findElement(By.linkText("5")).click();
		driver.findElement(By.cssSelector(".c-search-page__link:nth-child(6) > .c-search-page__result-title")).click();
		driver.findElement(By.cssSelector(".is-modal-open .o-modal__text-content")).click();
		assertThat(driver.findElement(By.cssSelector(".is-modal-open .o-modal__text-content")).getText(), is(
				"Sim, se você por Pessoa Física, MEI ou Pessoa Jurídica com faturamento de até R$3 milhões por ano, é possível contratar para SuperGet Aluguel ou Compra, POS Chip Aluguel, POS 3G + Wi-Fi Aluguel, POS Digital Aluguel e TEF. Observação: essa condição de recebimento não é válida para E-commerce."));

	}

}
