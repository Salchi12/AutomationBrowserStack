package com.browserstack.stepdefs;

import com.browserstack.pageobjects.FactoringPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class FactoringStepDefinition {
    private WebDriver driver;

    private FactoringPage factoringPage;

    @Before
    public void setUp() throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, String> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", "jhonparedes_o8ZuJ9");
        bstackOptions.put("accessKey", "8tPkNWVhLyYSbPpSkqBu");
        bstackOptions.put("browserstackSDK","cucumber-testng-javaagent/1.11.9");
        bstackOptions.put("timezone","Lima");

        bstackOptions.put("deviceName", "Samsung Galaxy S23 Ultra");
        bstackOptions.put("osVersion", "13.0");
        bstackOptions.put("browserName", "chrome");
        bstackOptions.put("deviceOrientation", "portrait");

        bstackOptions.putIfAbsent("source", "cucumber-java:sample-master:v1.2");
        capabilities.setCapability("bstack:options", bstackOptions);
        driver = new RemoteWebDriver(
                new URL("https://hub.browserstack.com/wd/hub"), capabilities);
        factoringPage = new FactoringPage(driver);

    }

    @Given("Estoy en la pagina '(.+)'$")
    public void I_am_on_the_website(String url) throws Throwable {
        driver.get(url);
        Thread.sleep(5200);
    }

    @When("se ingresa el ruc {string} y  las ventas anuales {string}")
    public void seIngresaElRucYLasVentasAnuales(String ruc, String ventas) {
        factoringPage.seIngresaElRucYLasVentasAnuales(ruc, ventas);
    }
    @And("doy click en validar")
    public void doyClickEnValidar() throws InterruptedException {
        factoringPage.clickValidar();
    }
    
    @After
    public void teardown(Scenario scenario) throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }


    @And("ingreso el aceptante con ruc {string} y escojo la moneda {string} con el monto {string} y un plazo {string} dias")
    public void ingresoElAceptanteConRucYEscojoLaMonedaSolesConElMontoYUnPlazoDias(String ruc, String moneda,String monto, String dias) throws InterruptedException {
        factoringPage.ingresoElAceptanteConRucYEscojoLaMonedaSolesConElMontoYUnPlazoDias(ruc, moneda,  monto, dias);
        
    }

    @And("ingreso el correo {string} y un celular {string}")
    public void ingresoElCorreoYUnCelular(String correo,String celular) {
        factoringPage.ingresoElCorreoYUnCelular(correo,celular);
    }

    @And("doy click en Descbrir oferta")
    public void doyClickEnDescbrirOferta() throws InterruptedException {
        factoringPage.doyClickEnDescbrirOferta();
        Thread.sleep(2000);
    }

    @And("valido y acepto la oferta")
    public void validoYAceptoLaOferta() throws InterruptedException{
        factoringPage.iniciarAfiliciacion();
    }

    @And("ingreso el dni {string}")
    public void ingresoElDni(String dni) throws InterruptedException{
        factoringPage.ingresoDni(dni);
    }

    @And("verifico otp {string}")
    public void verificoOtp(String otp) throws InterruptedException{
        factoringPage.validarOtp(otp);
    }

    @And("configuro cuentas")
    public void configuroCuentas() throws InterruptedException{
        factoringPage.agregarCuenta();
    }

    @And("ingreso facultades de {string} y envio la solicitud")
    public void ingresoFacultadesDeRLYEnvioLaSolicitud(String representante) throws InterruptedException {
        factoringPage.facultades(representante);
    }

    @Then("se muestra el resumen")
    public void seMuestraElResumen() {
        factoringPage.resumen();
    }
}
