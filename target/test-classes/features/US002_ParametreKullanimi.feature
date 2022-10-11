@TT
Feature: US002 Parametre kullanimi
  Scenario: TC01 Kullanici amazonda parametreli arama yapar
    Given kullanici "amazon" sayfasina giderr
    Then kullanici "nutella" icin arama yapar
    And sonuclarin "nutella" icerdigini test eder
    And  sayfayi kapatir

