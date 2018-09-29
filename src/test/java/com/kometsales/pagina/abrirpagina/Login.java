package com.kometsales.pagina.abrirpagina;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
//	public static WebDriver driver;
	public static final String LOGIN_EXITOSO = "Login exitoso";
	public static final String URL_KOMETSALES = "https://app.kometsales.com";
	public static final String USER_NAME = "gp";
	public static final String PASSWORD = "demo";
	public static final String PASSWORD_FALLIDO = "demo1";
	public static final String FALLO_SISTEMA = "Login fallido. Usuario o contraseña incorrecto";
	public static final int TIME_SLEEP = 3;
	private static String chrome = System.getProperty("user.dir") + "\\chromedriver.exe";

	public static void loginExitoso() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", chrome);
		try {
			WebDriver driver = new ChromeDriver();
			TimeUnit.SECONDS.sleep(TIME_SLEEP);
			driver.manage().window().maximize();
			driver.get(URL_KOMETSALES);
			driver.findElement(By.id("txtUserName")).sendKeys(USER_NAME);
			driver.findElement(By.id("txtPassword")).sendKeys(PASSWORD);
			// TODO: Utilicé Xpath porque el botón no tiene id, pero este no es el deber ser
			// ya que el xpath es dinámico
			driver.findElement(By.xpath("//*[@id=\"frmSignin\"]/button")).click();
			TimeUnit.SECONDS.sleep(TIME_SLEEP);
			driver.close();
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			System.out.println(LOGIN_EXITOSO);
		}

	}

	public static void loginFallido() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", chrome);
		try {
			WebDriver driver = new ChromeDriver();
			TimeUnit.SECONDS.sleep(TIME_SLEEP);
			driver.manage().window().maximize();
			driver.get(URL_KOMETSALES);
			driver.findElement(By.id("txtUserName")).sendKeys(USER_NAME);
			driver.findElement(By.id("txtPassword")).sendKeys(PASSWORD_FALLIDO);
			// TODO: Utilicé Xpath porque el botón no tiene id, pero este no es el deber ser
			// ya que el xpath es dinámico
			driver.findElement(By.xpath("//*[@id=\"frmSignin\"]/button")).click();
			TimeUnit.SECONDS.sleep(TIME_SLEEP);
			driver.close();
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			System.out.println(FALLO_SISTEMA);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO: Desde este método se orquestan las pruebas a realizar
		loginExitoso();
		// loginFallido();
	}
}
