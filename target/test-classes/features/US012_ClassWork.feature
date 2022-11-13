Feature: US011 Class Work
@US012
  Scenario Outline:  TC_01_kullanici_sutun_basligi_ile_liste_alabilmeli

    Given kullanici "guruUrl" anasayfasinda
    And "<Basliklar>" sutunundaki tum degerleri yazdirir

    Examples:
      | Basliklar |
      | Company |
      | Group |
      | Prev Close (Rs) |
      | Current Price (Rs) |
      | % Change |

    Scenario: kullanici sayfayi kapatir
      Given sayfayi kapatir