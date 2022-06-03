@paralel2
Feature: US1002 Background ile amazon search testi

  Background: amazon sayfasina gidis
    Given kullanici amazon sayfasina gider
    # diyez ile yorum yazabilirsiniz

  @wip
  Scenario: TC02_Amazon iPhone Search Testi

    And iPhone icin arama yapar
    Then sonuclarin iPhone icerdigini test eder

  @wip  # genelde @wip yapariz bunun uzerinde suanda calisiyoruz demek icin web in process
  Scenario: TC03_Amazon tea pot  Search Testi
    And tea pot icin arama yapar
    Then sonuclarin tea pot icerdigini test eder

  Scenario: TC04_Amazon flower  Search Testi
    And flower icin arama yapar
    Then sonuclarin flower icerdigini test eder