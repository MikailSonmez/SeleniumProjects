Feature: US1014 Dinamik Elemanlar
  @Dinamik
  Scenario: TC19 Dinamik elementler tiklanabilmeli

    Given kullanici "DemoQaUrl" sayfasina gider
    Then Will enable 5 seconds butonunun enable olmaisini bekleyin
    And Will enable 5 seconds butonunun enable oldugunu test edin