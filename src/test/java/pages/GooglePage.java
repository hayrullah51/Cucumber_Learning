package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.OdevStepDefinition;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class GooglePage {

    public GooglePage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    public WebElement searchBox;

    @FindBy(xpath = "(//cite[.='https://www.trendyol.com'])[1]")
    public WebElement searchTrendyolResult;

    @FindBy(xpath = "(//cite[.='https://www.morhipo.com'])[1]")
    public WebElement searchMorhipoResult;





}
