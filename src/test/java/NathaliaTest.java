import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class NathaliaTest {

	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

	}

	@Test
	public void nomeSiteTeste() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://brasilescola.uol.com.br/");

		String currentUrl = driver.getCurrentUrl();
		String expected = "https://brasilescola.uol.com.br/";

		assertEquals(expected, currentUrl);

		driver.quit();
	}

	//Clica em disciplina e compara url
	@Test
	public void nomeDisciplinaTeste() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://brasilescola.uol.com.br/");
		WebElement disciplina = driver.findElement(By.className("menu-item-link"));
		disciplina.click();

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://brasilescola.uol.com.br/disciplinas";

		assertEquals(expectedUrl, currentUrl);

		driver.quit();
	}
	

	//Move o para o elemento search-mobile e verifica se o atributo placeHolder tem o conteudo "Pesquise aqui"
	@Test
	public void placeHolderSearchMobileTest() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://brasilescola.uol.com.br/");
		WebElement searchMobileElement = driver.findElement(By.id("search-mobile"));
		new Actions(driver).moveToElement(searchMobileElement).perform();
		
		assertEquals("Pesquise aqui", driver.findElement(By.id(("search-mobile"))).getAttribute("placeholder"));

		driver.quit();

	}

	//Encontra o elemento serach-mobile e envia nathalia, confirma a alteracao de url
	@Test
	public void searchNathaliaTest() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://brasilescola.uol.com.br/");
		WebElement searchMobileElement = driver.findElement(By.id("search-mobile"));
		searchMobileElement.sendKeys("nathalia");
		searchMobileElement.submit();

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://brasilescola.uol.com.br/busca?q=nathalia";

		assertEquals(expectedUrl, currentUrl);

		driver.quit();
	}

	@Test
	public void test4() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://brasilescola.uol.com.br/");
		
		WebElement contatoClass = driver.findElement(By.className("Contato"));
		contatoClass.click();
		
		Select formSelectClass = new Select(driver.findElement(By.className("form select")));
		formSelectClass.selectByIndex(1);
		//terminar
		
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://brasilescola.uol.com.br/busca?q=nathalia";

		assertEquals(expectedUrl, currentUrl);

		driver.quit();
	}

}
