package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.PracticeTestPage;
import utilities.Driver;

public class PracticeTestPageStepDefs {

    Actions actions = new Actions(Driver.getDriver());
    PracticeTestPage practiceTestPage = new PracticeTestPage();

    Integer toplam;
    @Given("{string} adresine gidin")
    public void adresine_gidin(String url) {
        Driver.getDriver().get(url);
    }
    @Given("{int} defa click me ye tiklayin")
    public void defa_click_me_ye_tiklayin(Integer int1) {

        for (int i = 0; i < int1; i++) {
            practiceTestPage.clickButton.click();
        }

    }
    @Given("{int} defa Space dugmesine basin")
    public void defa_space_dugmesine_basin(Integer int1) {
        for (int i = 0; i < int1; i++) {
           actions.sendKeys(Keys.SPACE).click().perform();
        }
    }
    @Given("Down yazisindaki iki basamakli sayilarin hepsini toplayin")
    public void down_yazisindaki_iki_basamakli_sayilarin_hepsini_toplayin() {toplam = (practiceTestPage.down32List.size())*32;
        System.out.println("down 32'deki 32'lerin toplami : "+toplam);
    }
    @Given("Tum click metinlerinin uzunlugunun toplamini onceki toplamdan cikarin")
    public void tum_click_metinlerinin_uzunlugunun_toplamini_onceki_toplamdan_cikarin() {

        Integer sonuc = ((practiceTestPage.tumPtagi.size() - practiceTestPage.clickList.size()) - toplam);

    }
    @Then("sonucun {int} oldugunu dogrulayin")
    public void sonucun_oldugunu_dogrulayin(Integer int1) {

    }

}