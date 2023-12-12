import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HernandeTest {

	private WebDriver driver;

	@Before
	public void setup() {
		// Configuração do WebDriver antes de cada teste
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		// Fechamento do navegador após cada teste
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void testAcessarExerciciosBiologia() {
		// Acessar a página de exercícios de Biologia
		driver.get("https://exercicios.brasilescola.uol.com.br/exercicios-biologia");
		String currentUrl = driver.getCurrentUrl();
		String expected = "https://exercicios.brasilescola.uol.com.br/exercicios-biologia";

		// Verificar se a URL é a esperada
		assertEquals(expected, currentUrl);

		// Exemplo de assertTrue para verificar se a URL contém a palavra "biologia"
		assertTrue(currentUrl.contains("biologia"));
	}

	@Test
	public void testAcessarExerciciosFisica() {
		// Acessar a página de exercícios de Física
		driver.get("https://exercicios.brasilescola.uol.com.br/exercicios-fisica");
		String currentUrl = driver.getCurrentUrl();
		String expected = "https://exercicios.brasilescola.uol.com.br/exercicios-fisica";

		// Verificar se a URL é a esperada
		assertEquals(expected, currentUrl);

		// Exemplo de assertFalse para verificar se a URL não contém a palavra "quimica"
		assertFalse(currentUrl.contains("quimica"));
	}

	@Test
	public void testAcessarExerciciosGeografia() {
		// Acessar a página de exercícios de Geografia
		driver.get("https://exercicios.brasilescola.uol.com.br/exercicios-geografia");
		String currentUrl = driver.getCurrentUrl();
		String expected = "https://exercicios.brasilescola.uol.com.br/exercicios-geografia";

		// Verificar se a URL é a esperada
		assertEquals(expected, currentUrl);

		// Exemplo de assertTrue para verificar se o título da página contém "Geografia"
		assertTrue(driver.getTitle().contains("Geografia"));
	}

	@Test
	public void testAcessarGeografiaBrasil() {
		// Acessar a página de exercícios de Geografia do Brasil
		driver.get("https://exercicios.brasilescola.uol.com.br/exercicios-geografia-do-brasil");
		String currentUrl = driver.getCurrentUrl();
		String expected = "https://exercicios.brasilescola.uol.com.br/exercicios-geografia-do-brasil";

		// Verificar se a URL é a esperada
		assertEquals(expected, currentUrl);

		// Exemplo de assertFalse para verificar se a URL não contém a palavra "matematica"
		assertFalse(currentUrl.contains("matematica"));
	}

	@Test
	public void testAcessarExerciciosGramatica() {
		// Acessar a página de exercícios de Gramática
		driver.get("https://exercicios.brasilescola.uol.com.br/exercicios-gramatica");
		String currentUrl = driver.getCurrentUrl();
		String expected = "https://exercicios.brasilescola.uol.com.br/exercicios-gramatica";

		// Verificar se a URL é a esperada
		assertEquals(expected, currentUrl);

		// Exemplo de assertTrue para verificar se a URL contém a palavra "portugues"
		assertTrue(currentUrl.contains("portugues"));
	}

	@Test
	public void placeHolderSearchMobileTest() {
		// Acessar a página inicial
		driver.get("https://brasilescola.uol.com.br/");
		WebElement searchMobileElement = driver.findElement(By.id("search-mobile"));

		// Mover o cursor do mouse para o elemento de pesquisa mobile
		new Actions(driver).moveToElement(searchMobileElement).perform();

		// Exemplo de assertTrue para verificar se o placeholder contém a palavra "Pesquise"
		assertTrue(searchMobileElement.getAttribute("placeholder").contains("Pesquise"));
	}

	@Test
	public void searchHernandeTest() {
		// Acessar a página inicial
		driver.get("https://brasilescola.uol.com.br/");
		WebElement searchMobileElement = driver.findElement(By.id("search-mobile"));

		// Preencher a barra de pesquisa com "hernande" e submeter o formulário
		searchMobileElement.sendKeys("hernande");
		searchMobileElement.submit();

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://brasilescola.uol.com.br/busca?q=hernande";

		// Exemplo de assertTrue para verificar se a URL contém a palavra "busca"
		assertTrue(currentUrl.contains("busca"));
	}
}
