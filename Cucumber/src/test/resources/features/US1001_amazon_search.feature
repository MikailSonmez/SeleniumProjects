Feature: US1001_amazon_search.feature

  Scenario: TC01_Amazom Search Testi
    Given kullanici amazon sayfasina gider
    And iPhone icin arama yapar
    Then sonuclarin Iphone icerdigini test eder
    Given kullanici amazon sayfasina gider
    And tea pot icin arama yapar
    Then sonuclarin tea pot icerdigini test eder
    Given kullanici amazon sayfasina gider
    And flower icin arama yapar
    Then sonuclarin flower icerdigini test eder