Feature: US1007 Scenario Outline ile amazon search

  Scenario Outline: TC12 amazonda bir listedeki tum elementleri aratma

    Given kullanici "AmazonUrl" sayfasina gider
    Then "<aranacakEleman>" icin arama yapar
    And sonuclarin "<aranacakEleman>" icerdigini test eder





    Examples:
      |aranacakEleman|
      |Apple|
      |Java |
      |Samsung|
      |Armut  |
      |nutella|