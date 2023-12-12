Feature: BrowserStack Demo

  Scenario: BStack Sample Test - Add product to cart
    Given Estoy en la pagina 'https://bancacomercial-stg.interbank.pe/factoring/solicitud/simulador'
    When se ingresa el ruc '20565433840' y  las ventas anuales '20000'
    And doy click en validar
    And ingreso el aceptante con ruc '20563295369' y escojo la moneda 'soles' con el monto '2000' y un plazo '10' dias
    And ingreso el correo 'correo@correo.com' y un celular '917161443'
    And doy click en Descbrir oferta
    And valido y acepto la oferta
    And ingreso el dni '74822033'
    And verifico otp '123456'
    And configuro cuentas
    And ingreso facultades de '1RL' y envio la solicitud
    Then se muestra el resumen
