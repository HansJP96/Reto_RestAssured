# new feature
# Tags: optional

Feature: Verificacion de servicios
  Como visitante de la pagina reqres
  quiero asegurarme que los endpoint que ofrecen funcionan
  para cumplir con el reto de sofkaU

  Scenario: Registro de usuario existoso
    Given que un usuario quiere registrarse con un email "eve.holt@reqres.in" y con una contrasena "pistol"
    When el usuario realiza la peticion para solicitar el registro
    Then el usuario recibe una respuesta satisfactoria con un numero identificador y un token

    Scenario Outline: Validacion de usuario existente
      When se necesita verificar la existencia del usuario con id = <numId>
      Then se recibe una respuesta satisfactoria y se verifica que el email del usuario sea "<resEmail>"
      Examples:
      |numId| resEmail|
      |5| charles.morris@reqres.in|
      |8| lindsay.ferguson@reqres.in|
      |10| byron.fields@reqres.in|