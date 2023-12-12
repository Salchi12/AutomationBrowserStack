package com.browserstack.pageobjects;

import io.netty.util.internal.ResourcesUtil;
import org.openqa.selenium.*;

public class FactoringPage {
    private WebDriver webDriver;

    public FactoringPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By inputRuc = By.xpath("//input[@class=\"HyperloopInput__input m\"]");
    private By inputVentas = By.xpath("//input[@class=\"HyperloopInputMask__input m\"]");
    private By validarButton = By.xpath("//button[@class=\"hyperloop-button hyperloop-button__primary hyperloop-button__s hyperloop-button__default hyperloop-button__primary--s\"]");
    private By validarButton2 = By.xpath("//a-hyperloop-button[@text=\"Validar\"]");
    private By añadirCliente = By.xpath("//span[text()=\"Añadir cliente\"]");
    private By inputAceptante = By.xpath("//p[text()=\"Ruc o razón social de tu cliente\"]//following::input[1]");

    private By HOST_MONEDA = By.xpath("///div[@class=\"simulator-amount-form__currency\"]");
    private String MONEDA_SOLES = "div > button:nth-child(1)";
    private By botonSoles = new By.ByCssSelector(MONEDA_SOLES);

    //private By botonSoles =By.xpath("//a-hyperloop-tab/button[@class=\"hyperloop-tab__button hyperloop-tab__button--selected disabled-style\"]");
    private By inputMonto = By.xpath("//p[text()=\"Ruc o razón social de tu cliente\"]//following::input[2]");
    private By inputDias = By.xpath("//input[@class=\"hyperloop-sufpref__input-without-border-right hyperloop-sufpref__form-control hyperloop-sufpref__suffix HyperloopInput__input m\"]");
    private By añadirButton = By.xpath("//span[text()=\"Añadir\"]");
    private By añadirButton2 = By.xpath("//div[@class=\"grid simulator-client-form-modal__button mt-30\"]");
    private By inputCorreo = By.xpath("//input[@placeholder=\"Correo electrónico\"]");
    private By inputCelular = By.xpath("//input[@placeholder=\"Celular\"]");
    private By checkTerminos = By.xpath("//m-hyperloop-checkbox[@id=\"check-pdp\"]");
    private By captcha = By.xpath("//re-captcha[@id=\"recaptcha\"]");
    private By descrubirButton = By.xpath("//a-hyperloop-button[@text=\"¡Descubrir ofertas!\"]");
    private By ofertaTitle = By.xpath("//a-hyperloop-text[@text=\"¡Listo! Tenemos estas ofertas para tu empresa\"]");
    private By iniciarAfiliacion = By.xpath("//a-hyperloop-button[@color=\"primary\"]");
    private By ofertaModalTitle = By.xpath("//a-hyperloop-paragraph[@text=\"Iniciaremos la solicitud de afiliación con los datos ingresados en la simulación\"]");
    private By iniciarAfiliacionModal = By.xpath("//a-hyperloop-button[@text=\"Iniciar afiliación\"]");
    private By inputDni = By.xpath("//input[@class=\"HyperloopInput__input m\"]");
    private By verificarDni = By.xpath("//a-hyperloop-button[@color=\"secondary\"]");
    private By checkPolitica = By.xpath("//m-hyperloop-checkbox[@idcheck=\"pdp\"]");
    private By checkDatosPerrsonales = By.xpath("//m-hyperloop-checkbox[@idcheck=\"lpdp\"]");
    private By checkDatosPerrsonales1 = By.xpath("//m-hyperloop-checkbox[@id=\"check-lpdp\"]");
    private By botonSgt = By.xpath("//a-hyperloop-button[@color=\"primary\"]");
    private By nuevoBotonStg = By.xpath("//a-hyperloop-button[@color=\"primary\"]");
    private By nuevoBotonStg1 = By.xpath("//button[@class=\"hyperloop-button hyperloop-button__primary hyperloop-button__m hyperloop-button__full hyperloop-button__primary--m\"]");
    private By inputOtp = By.xpath("//input[@class=\"HyperloopInput__input m\"]");
    private By inputOtp2 = By.xpath("//input[@type=\"text\"]");
    private By seleccionCuenta1 = By.xpath("//a-hyperloop-link-button[@text=\"Cuenta de desembolso\"]");
    private By seleccionCuenta2 = By.xpath("//p-hyperloop-radio-button[@class=\"hydrated\"]");
    private By btnGuardarCuenta = By.xpath("//a-hyperloop-button[@id=\"btnSave\"]");
    private By terminosCuentas = By.xpath("//m-hyperloop-checkbox[@formcontrolname=\"pdp\"]");
    private By botonBiometria = By.xpath("//a-hyperloop-button[@id=\"formBtnNextStep\"]");
    private static final String HOST_FACULTADES = "body > hyperloop-root > hyperloop-home-ui > div.home_body > hyperloop-factoring > hyperloop-factoring-ui > section > div > div.aside-left.col-xs-12.col-8.background-layout__b > fact-factoring > fact-factoring-iu > div > fact-faculties-step > fact-faculties-step-ui > section > div.faculties-view > div:nth-child(4) > form > div > m-hyperloop-inputgroup-radio";
    private static final String TENGOFACULTADES_TARGET = "div > div > div:nth-child(1)";
    private By enviarSolicitudBoton = By.xpath("//a-hyperloop-button[@id=\"btnFinalize\"]");
    private By confirmarEnvio = By.xpath("//a-hyperloop-button[id=\"btnSend\"]");




    public void seIngresaElRucYLasVentasAnuales(String RUC, String ventas) {
        webDriver.findElement(inputRuc).sendKeys(RUC);
        webDriver.findElement(inputVentas).sendKeys(ventas);
    }

    public void clickValidar() throws InterruptedException {

        webDriver.findElement(validarButton).click();
        webDriver.findElement(validarButton2).click();
        Thread.sleep(4500);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");



    }

    public void ingresoElAceptanteConRucYEscojoLaMonedaSolesConElMontoYUnPlazoDias(String ruc, String moneda, String monto, String dias) throws InterruptedException {
        webDriver.findElement(añadirCliente).click();
        Thread.sleep(2500);
        webDriver.findElement(inputAceptante).sendKeys(ruc);
        webDriver.findElement(inputMonto).sendKeys(monto);
        webDriver.findElement(inputDias).sendKeys(dias);

//        WebElement root = webDriver.findElement(HOST_MONEDA);
//        JavascriptExecutor js = (JavascriptExecutor) webDriver;
//        WebElement shadowDom = (WebElement) js.executeScript("return arguments[0],shadowRoot", root);
//        if (moneda.equals("soles")) {
//
//        }

        webDriver.findElement(añadirButton).click();
        webDriver.findElement(añadirButton2).click();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2500);


    }

    public void ingresoElCorreoYUnCelular(String correo, String celular) {
        webDriver.findElement(inputCorreo).sendKeys(correo);
        webDriver.findElement(inputCelular).sendKeys(celular);
    }

    public void doyClickEnDescbrirOferta() {
        webDriver.findElement(checkTerminos).click();
        webDriver.findElement(captcha).click();
        webDriver.findElement(descrubirButton).click();
//        JavascriptExecutor js = (JavascriptExecutor) webDriver;
//        js.executeScript("window.scrollBy(0, -window.innerHeight)");
    }

    public void iniciarAfiliciacion() throws InterruptedException{
        Thread.sleep(5200);
        webDriver.findElement(iniciarAfiliacion).click();
        Thread.sleep(2200);
        webDriver.findElement(iniciarAfiliacionModal).click();
        Thread.sleep(5500);
    }

    public void ingresoDni(String DNI) throws InterruptedException{
        Thread.sleep(2500);
        webDriver.findElement(inputDni).sendKeys(DNI);
        webDriver.findElement(verificarDni).click();
        Thread.sleep(2000);
        webDriver.findElement(checkPolitica).click();

        //revisar el shadow root
//        webDriver.findElement(checkDatosPerrsonales).click();
//        webDriver.findElement(checkDatosPerrsonales1).click();
        webDriver.findElement(botonSgt).click();
        Thread.sleep(3500);

    }

    public void validarOtp(String OTP) throws InterruptedException{

        webDriver.findElement(nuevoBotonStg).click();
        webDriver.findElement(nuevoBotonStg).click();
        Thread.sleep(2400);
        webDriver.findElement(inputOtp2).sendKeys(OTP);
        webDriver.findElement(inputOtp).sendKeys(OTP);
        webDriver.findElement(nuevoBotonStg1).click();
        Thread.sleep(2500);

    }

    public void agregarCuenta() throws InterruptedException{
        Thread.sleep(2500);
        //selecionarcuenta
        webDriver.findElement(seleccionCuenta1).click();
        webDriver.findElement(seleccionCuenta2).click();
        //botonguardar
        webDriver.findElement(btnGuardarCuenta).click();
        //click en terminos
        webDriver.findElement(terminosCuentas).click();
        webDriver.findElement(botonSgt).click();
        Thread.sleep(2550);
        webDriver.findElement(botonBiometria).click();
    }

    public void facultades( String representante) throws InterruptedException{
        Thread.sleep(2200);
        //boton facultades
        //driver.findElement(By.id("parentId")).getShadowRoot().findElement(By.cssSelector("label")).findElement(By.tagName("input"))
        //webDriver.findElement(By.className("ng-untouched ng-pristine ng-invalid hydrated")).getShadowRoot().findElement(By.cssSelector(TENGOFACULTADES_TARGET)).findElement(By.id("styled-radio-facultiesControl-0")).click();
        webDriver.findElement(By.cssSelector(HOST_FACULTADES)).getShadowRoot().findElement(By.cssSelector(TENGOFACULTADES_TARGET)).findElement(By.cssSelector("label")).click();
        if(representante.equals("1RL")) {
            System.out.println("1rl");

        }
        //boton enviar solicitud
        webDriver.findElement(enviarSolicitudBoton).click();
        Thread.sleep(1200);
        //confirmar envio
        webDriver.findElement(confirmarEnvio).click();
    }

    public void resumen(){
        System.out.println("resuumen");
    }


    //resuumen

}
