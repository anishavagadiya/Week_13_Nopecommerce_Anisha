package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }


    public void sendTextToElement(By by, String text) {
        //Find the Email Field element and send the email
        WebElement emailField = driver.findElement(by);
        //type email to email field
        // emailField.sendKeys("test123@gmail.com");
        emailField.sendKeys(text);
    }

    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    //Assert Method
    public void verifyText(By by, String text) {
        String expectedMessage = text;
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals("Not matched with original text", expectedMessage, actualMessage);

    }
//********** Alert Methods *************

    //Switch to Alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //Switch to AcceptAlert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //Switch to DismissAlert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //Switch to String getText from Alert
    public String getTextFromAlert() {
        String alertText = driver.switchTo().alert().getText();
        return alertText;
    }

    //SendTextToAlert(String text)
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }


    //****************************Select Class Method ************************************************
    //Select option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    //Select option Value
    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    //Select option by Index
    public void selectByIndexFromDropDown(By by, int indexNum) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(indexNum);

    }
    //This is Select the option by contains text


    //**********************Window Handle*************************************


    //**************************Action Class *********************************
    // mouseHoverToElement(),
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHover = driver.findElement(by);
        actions.moveToElement(mouseHover).build().perform();
    }

    // mouseHoverToElementAndClick(By by)
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseClick = driver.findElement(by);
        actions.moveToElement(mouseClick).click().build().perform();
    }

}
