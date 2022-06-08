Feature: US1001 Kullanici Database'e baglanip bilgileri okuyabilir

  @db
  Scenario: TC01 kullanici database baglanip istedigi bilgileri okuyabilmeli

    Given kullanici HMC veri tabanina baglanir
    # database'e baglanacagiz
    And kullanici "tHOTELROOM" tablosundaki "Price" verilerini alir
    # Query calistiracagiz SELECT Price FROM tHOTELROOM
    And kullanici "Price" sutunundaki verileri okur
    #3.adimda database sorgusu sonunda bize dondurulen bilgiyi nasil kullanabilecegimizi gorecegiz