@odev
Feature: US9999 Trendyol ve Morhipodan makas aratma

  Scenario: TC 9901 : Kullanici Trendyolda makas aratir ve urun sayisini alir

    Given kullanici "googleUrl" sayfasina gider
    When kullanici google da "trendyol" aratir
    And kullanici "trendyol" aramasina  tiklar
    And kullanici "trendyol" sayfasina gittigini dogrular
    And kullanici trendyol sayfasinda "makas" kelimesini aratir
    Then  kullanici trendyolda "makas" icin urun sayisini kontrol eder


    Scenario: TC 9902 : Kullanici yeni sekmede morhipoda makas aratir ve urun sayisini alir

      Given kullanici yeni sekme acar
      When kullanici "googleUrl" sayfasina gider
      And kullanici google da "morhipo" aratir
      And kullanici "morhipo" aramasina  tiklar
      And kullanici "morhipo" sayfasina gittigini dogrular
      And kullanici morhipo sayfasinda "makas" kelimesini aratir
      Then  kullanici morhipoda "makas" icin urun sayisini kontrol eder

      And kullanici urun sayisi fazla olan sayfayi kapatir
      Then kullanici diger sayfayi kapatir






