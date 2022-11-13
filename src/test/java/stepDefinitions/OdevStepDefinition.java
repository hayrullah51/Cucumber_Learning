package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.GooglePage;
import pages.MorhipoPage;
import pages.TrendyolPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

public class OdevStepDefinition {

    GooglePage googlePage = new GooglePage();
    TrendyolPage trendyolPage = new TrendyolPage();
    MorhipoPage morhipoPage = new MorhipoPage();
    Actions actions = new Actions(Driver.getDriver());
    String trendyolHandle;
    String morhipoHandle;
    int trendyolSonucSayisi;
    int morhipoSonucSayisiInt;




    @When("kullanici google da {string} aratir")
    public void kullanici_google_da_aratir(String aranacakUrun) {
        googlePage.searchBox.sendKeys(aranacakUrun, Keys.ENTER);
    }

    @When("kullanici {string} aramasina  tiklar")
    public void kullanici_aramasina_tiklar(String googleArama) {
        if (googleArama.contains("trendyol")) {
            googlePage.searchTrendyolResult.click();
            trendyolHandle = Driver.getDriver().getWindowHandle();
            System.out.println("Trendyol window handle is : " + trendyolHandle);
        } else if (googleArama.contains("morhipo")) {
            googlePage.searchMorhipoResult.click();
            morhipoHandle = Driver.getDriver().getWindowHandle();
        }
    }

    @When("kullanici {string} sayfasina gittigini dogrular")
    public void kullanici_sayfasina_gittigini_dogrular(String gidilenSayfaUrl) throws InterruptedException {
        Thread.sleep(1000);
        if (gidilenSayfaUrl.contains("trendyol")) {
            Thread.sleep(1000);
            System.out.println(Driver.getDriver().getCurrentUrl());
            Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigReader.getProperty("trendyolUrl"));
        } else if (gidilenSayfaUrl.contains("morhipo")) {
            Thread.sleep(1000);
            System.out.println(Driver.getDriver().getCurrentUrl());
            Assert.assertTrue(Driver.getDriver().getCurrentUrl().equalsIgnoreCase(ConfigReader.getProperty("morhipoUrl")));
        }

    }

    @When("kullanici trendyol sayfasinda {string} kelimesini aratir")
    public void kullanici_trendyol_sayfasinda_kelimesini_aratir(String string) {
        trendyolPage.searchBox.sendKeys(ConfigReader.getProperty("arananUrun"), Keys.ENTER);
    }

    @Then("kullanici trendyolda {string} icin urun sayisini kontrol eder")
    public void kullanici_trendyolda_icin_urun_sayisini_kontrol_eder(String string) {
        String trendyolSearchResultText = trendyolPage.searchResultText.getText();
        String[] sonucSayisiTrendyol = trendyolSearchResultText.split(" ");
        trendyolSonucSayisi = Integer.parseInt(sonucSayisiTrendyol[3]);
        System.out.println(trendyolSonucSayisi);
    }

    @Given("kullanici yeni sekme acar")
    public void kullanici_yeni_sekme_acar() {
        //actions.keyDown(Keys.LEFT_CONTROL).sendKeys("T").keyUp(Keys.LEFT_CONTROL).perform();

        Driver.getDriver().switchTo().newWindow(WindowType.TAB).get(ConfigReader.getProperty("googleUrl"));
    }


    @When("kullanici morhipo sayfasinda {string} kelimesini aratir")
    public void kullanici_morhipo_sayfasinda_kelimesini_aratir(String aranacakUrun) {

        morhipoPage.searchBox.sendKeys(aranacakUrun, Keys.ENTER);

    }

    @Then("kullanici morhipoda {string} icin urun sayisini kontrol eder")
    public void kullanici_morhipoda_icin_urun_sayisini_kontrol_eder(String string) {
        String morhipoSearchResultText = morhipoPage.urunSayisi.getText();
        morhipoSonucSayisiInt = Integer.parseInt(morhipoSearchResultText);
    }

    @Then("kullanici urun sayisi fazla olan sayfayi kapatir")
    public void kullanici_urun_sayisi_fazla_olan_sayfayi_kapatir() {

        if (morhipoSonucSayisiInt < trendyolSonucSayisi){
            Driver.closeDriver();
        }else {
            Driver.closeDriver();
        }

    }

    @Then("kullanici diger sayfayi kapatir")
    public void kullanici_diger_sayfayi_kapatir() throws AWTException  {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
    }


}
