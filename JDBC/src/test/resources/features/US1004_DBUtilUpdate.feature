Feature: US1004 kullanici kayitlari update eder

  Scenario: TC04 Kullanici IDHotel degeri verilen Email i update edebilmeli

    Given kullanici DBUtil ile HMC veri tabanina baglanir
    Then tHotel tablosunda IDHotel degeri 1005 olan kaydin Email bilgisini "heyyyyyyyyyyyyyy@gmail.com" yapar