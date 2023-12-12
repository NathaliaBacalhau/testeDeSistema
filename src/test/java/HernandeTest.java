import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HernandeTest {

	private WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void testAcessarExerciciosBiologia() {
		driver.get("https://exercicios.brasilescola.uol.com.br/exercicios-biologia");
		String currentUrl = driver.getCurrentUrl();
		String expected = "https://exercicios.brasilescola.uol.com.br/exercicios-biologia";
		assertEquals(expected, currentUrl);
	}

	@Test
	public void testAcessarExerciciosFisica() {
		driver.get("https://exercicios.brasilescola.uol.com.br/exercicios-fisica");
		String currentUrl = driver.getCurrentUrl();
		String expected = "https://exercicios.brasilescola.uol.com.br/exercicios-fisica";
		assertEquals(expected, currentUrl);
	}

	@Test
	public void testAcessarExerciciosGeografia() {
		driver.get("https://exercicios.brasilescola.uol.com.br/exercicios-geografia");
		String currentUrl = driver.getCurrentUrl();
		String expected = "https://exercicios.brasilescola.uol.com.br/exercicios-geografia";
		assertEquals(expected, currentUrl);
	}

	@Test
	public void testAcessarGeografiaBrasil() {
		driver.get("https://exercicios.brasilescola.uol.com.br/exercicios-geografia-do-brasil");
		String currentUrl = driver.getCurrentUrl();
		String expected = "https://exercicios.brasilescola.uol.com.br/exercicios-geografia-do-brasil";
		assertEquals(expected, currentUrl);
	}

	@Test
	public void testAcessarExerciciosGramatica() {
		driver.get("https://exercicios.brasilescola.uol.com.br/exercicios-gramatica");
		String currentUrl = driver.getCurrentUrl();
		String expected = "https://exercicios.brasilescola.uol.com.br/exercicios-gramatica	";
		assertEquals(expected, currentUrl);
	}
}
