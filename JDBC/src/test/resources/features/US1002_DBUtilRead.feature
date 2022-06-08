Feature: US1002 Kullanici DBYtil il database e baglanip istedigi field bilgilerini okur

@Db
  Scenario: TC02 kullanici tablo ve field ismi ile sorgu yapabilmeli

    Given kullanici DBUtil ile HMC veri tabanina baglanir
    And kullanici DBUtil ile "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullanici DBUtil ile "Price" sutunundaki verileri okur
    And DBUtil ile tum "Price" degerlerini sira numarasi ile yazdirir
    Then DBUtill ile 4. "Price" in 425 oldugunu test eder