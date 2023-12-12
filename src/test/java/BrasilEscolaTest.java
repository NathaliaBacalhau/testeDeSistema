import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.After;
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


public class BrasilEscolaTest {
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

	@Test
	public void nomeSiteTeste() {
		driver.get("https://brasilescola.uol.com.br/");

		String currentUrl = driver.getCurrentUrl();
		String expected = "https://brasilescola.uol.com.br/";

		assertEquals(expected, currentUrl);

	}

	//Clica em disciplina e compara url
	@Test
	public void nomeDisciplinaTeste() {
		driver.get("https://brasilescola.uol.com.br/");
		WebElement disciplina = driver.findElement(By.className("menu-item-link"));
		disciplina.click();

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://brasilescola.uol.com.br/disciplinas";

		assertEquals(expectedUrl, currentUrl);
	}
	

	//Move o para o elemento search-mobile e verifica se o atributo placeHolder tem o conteudo "Pesquise aqui"
	@Test
	public void placeHolderSearchMobileTest() {
		driver.get("https://brasilescola.uol.com.br/");
		WebElement searchMobileElement = driver.findElement(By.id("search-mobile"));
		new Actions(driver).moveToElement(searchMobileElement).perform();
		
		assertEquals("Pesquise aqui", driver.findElement(By.id(("search-mobile"))).getAttribute("placeholder"));


	}

	//Encontra o elemento serach-mobile e envia nathalia, confirma a alteracao de url
	@Test
	public void searchNathaliaTest() {
		driver.get("https://brasilescola.uol.com.br/");
		WebElement searchMobileElement = driver.findElement(By.id("search-mobile"));
		searchMobileElement.sendKeys("nathalia");
		searchMobileElement.submit();

		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://brasilescola.uol.com.br/busca?q=nathalia";

		assertEquals(expectedUrl, currentUrl);

	}
	//A partir de contato pega o seletor e  seleciona um item 
	@Test
	public void selectTest() {
		driver.get("https://brasilescola.uol.com.br/contato");
		
		WebElement formSelectClass = driver.findElement(By.id("recipient"));
		
		Select select = new Select(formSelectClass);
		
		WebElement twoElement = driver.findElement(By.cssSelector("option[value=\"2\"]"));
    
		select.selectByVisibleText("Área de Cadastro / Problema Login");
       assertTrue(twoElement.isSelected());


	}

}
