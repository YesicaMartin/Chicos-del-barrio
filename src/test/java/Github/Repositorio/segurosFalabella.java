package Github.Repositorio;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class segurosFalabella {

	String url = "https://compratusoat.com.co/";
	String mensaje;
	WebDriver driver;
	WebElement input, input1, input2, input3, input4, input5, input6;
	WebElement clic, clic1, clic2, clic3, clic4, clic5, clic6;
	WebDriverWait obj;
	
	@Before
	public void Antes () throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		obj = new WebDriverWait(driver,1000);
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(1000);
	}
	
	@Test
	public void durante () throws InterruptedException {
		
		//Datos
		WebElement input = obj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pro2\"]/div[2]/input")));
		input.sendKeys("WDM98E");
		WebElement input1 = driver.findElement(By.xpath("//*[@id=\"mail\"]"));
		input1.sendKeys("daniel.envios@gmail.com");
		WebElement input2 = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		input2.sendKeys("Daniel");
		WebElement input3 = driver.findElement(By.xpath("//*[@id=\"apellidos\"]"));
		input3.sendKeys("Grajales");
		WebElement input4 = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
		input4.sendKeys("3228856119");
		//Aceptar terminos
		WebElement clic = driver.findElement(By.xpath("//*[@id=\"accept\"]"));
		clic.click();
		//Ventana emergente
		WebElement clic1 = obj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modalTerminos\"]/div/div/div[3]/button[2]")));
		clic1.click();
		Thread.sleep(1000);
		//Cotizar
		WebElement clic2 = driver.findElement(By.xpath("//*[@id=\"btsubmit\"]"));
		clic2.click();
		Thread.sleep(1000);
		//Valida datos
		WebElement clic3 = obj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paso1\"]/div[5]/div/div[2]/input[1]")));
		clic3.submit();
		//Seleccionar ciudad
		WebElement input5 = obj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"inputSelect\"]")));
		input5.sendKeys("Bogota");
		input5.sendKeys(Keys.ARROW_DOWN);
		input5.sendKeys(Keys.ENTER);
		
		WebElement clic4 = driver.findElement(By.xpath("//*[@id=\"paso2\"]/div[4]/div/div[2]/input[1]"));
		clic4.submit();
		
		WebElement clic5 = obj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paso3\"]/div[3]/div[2]/div/label/span")));
		clic5.click();
		
		WebElement clic6 = driver.findElement(By.xpath("//*[@id=\"paso3\"]/div[4]/div/div[2]/input[1]"));
		clic6.submit();
		//listo mensaje
		
		WebElement input6 = obj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/h1")));
		mensaje = input6.getText();
		
		//Comparación
		Assert.assertEquals("¡Lo sentimos no podemos continuar con tu compra!", mensaje);
		
		
		
	}
	
	
	@After
	public void despues () {
		driver.quit();
	}
	
	
}
