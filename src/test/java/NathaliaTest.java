import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class NathaliaTest {

	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
	}
	
    @Test
    public void helloSeleniumTest(){
        //https://www.selenium.dev/documentation/webdriver/browsers/
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--remote-allow-origins=*");
		// WebDriver driver = new ChromeDriver(options);
		WebDriver driver = new ChromeDriver();

		driver.get("https://brasilescola.uol.com.br/");
		
		String currentUrl = driver.getCurrentUrl();
		String expected = "https://brasilescola.uol.com.br/";
		
		assertEquals(expected, currentUrl);
		
		driver.quit();
    }
	

	// Escreva um script para abrir google.com e verifique se o título é Google
	@Test
	public void test1(){
		
	}
	// Escreva um script para abrir a https://pt.wikipedia.org e procure algum
	// elemento via ID e clique nele
	@Test
	public void test2(){
		
	}

	// Abra o site do globo.com, procure no html, o elemento da barra de pesquisa, 
	// envie uma string "fantastico" e submeta a busca
	@Test
	public void test3(){
		
	}

	// Abra o site do globo.com, procure por algum elemento responsivo ao hover do mouse.
	// utilize o actions para mover o mouse (sem clicar) para este elemento
	@Test
	public void test4(){
		
	}


}
