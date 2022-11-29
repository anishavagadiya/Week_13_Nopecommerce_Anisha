package computer;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //Click on computer
        clickOnElement(By.linkText("Computers"));
        //Click on Desktop
        clickOnElement(By.linkText("Desktops"));
        //Select Sort By position "Name: Z to A"
        selectByValueFromDropDown(By.name("products-orderby"), "6");
        //Verify the Product will arrange in Descending order.
        String expectedMessage = "Product will arrange in Descending order";


    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Click on computer
        clickOnElement(By.linkText("Computers"));

        //Click on Desktop
        clickOnElement(By.linkText("Desktops"));

        //Select Sort By position "Name: A to Z"
        selectByValueFromDropDown(By.name("products-orderby"), "5");
        Thread.sleep(5000);

        //Click on "Add To Cart"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

        //Verify the Text "Build your own computer"
        String expectedMessage = "Build your own computer";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        //Validate actual and expected message
        Assert.assertEquals("Build your own computer not displayed", expectedMessage, actualMessage);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByValueFromDropDown(By.name("product_attribute_1"), "1");

        //Select "8GB [+$60.00]" using Select class
        selectByValueFromDropDown(By.name("product_attribute_2"), "5");

        //Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(5000);
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));

        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));

        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        //clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));

        //Verify the price "$1,475.00"
        String expectedPrice = "$1,475.00";
        String actualPrice = getTextFromElement(By.xpath("//span[contains(text(),'$1,475.00')]"));
        //Validate expected and actual result
        Assert.assertEquals("Price is not correct ", expectedPrice, actualPrice);

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.cssSelector("#add-to-cart-button-1"));

        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMsg = "The product has been added to your shopping cart";
        String actualMsg = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]"));
        //Validate expected and actual result
        Assert.assertEquals("Price is not correct ", expectedMsg, actualMsg);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath(" //span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.15 Verify the message "Shopping cart"
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedcart = "Shopping cart";
        String actualcart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //Validate expected and actual result
        Assert.assertEquals("Shopping cart isnot displayed ", expectedcart, actualcart);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(2000);
        WebElement Quantity = driver.findElement(By.xpath("//td[@class='quantity']/child::input"));
        Quantity.clear();
        Quantity.sendKeys("2");
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00"
        String expectedTotal = "$2,950.00";
        String actualTotal = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        //validate expected and actual result
        Assert.assertEquals("Price is not matched ", expectedTotal, actualTotal);

        //2.18 click on checkbox “I agree with the terms of service”
        Thread.sleep(2000);
        clickOnElement(By.id("termsofservice"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedMs = "Welcome, Please Sign In!";
        String actualMs = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //Validate expected and actual result
        Assert.assertEquals("Welcome sign is not matching ", expectedMs, actualMs);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.21Click on “CHECKOUT AS GUEST” Tab
        Thread.sleep(2000);
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "John");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Smith");
        sendTextToElement(By.id("BillingNewAddress_Email"), "SmithJohn@hotmail.co.uk");
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "233");
        selectByValueFromDropDown(By.id("BillingNewAddress_StateProvinceId"), "0");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "Heamsted Heath");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "N2 3PU");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "99887765432");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.cssSelector("#shippingoption_1"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.cssSelector("#paymentmethod_1"));
        clickOnElement(By.xpath("//ol[1]/li[4]/div[2]/div[1]/button[1]")); //for continue


        //2.27 Select “Master card” From Select credit card dropdown
        Thread.sleep(3000);
        selectByValueFromDropDown(By.id("CreditCardType"), "MasterCard");

        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "John Smith"); //Enter name
        sendTextToElement(By.name("CardNumber"), "5555555555554444");//enter card number
        selectByValueFromDropDown(By.id("ExpireMonth"), "5"); //enter month
        selectByValueFromDropDown(By.id("ExpireYear"), "2024");//enter year
        sendTextToElement(By.cssSelector("#CardCode"), "3101");

        //2.29 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.30 Verify “Payment Method” is “Credit Card”
        verifyText(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");

        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyText(By.xpath("//div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"), "Next Day Air");

        //2.33 Verify Total is “$2,950.00”
        Thread.sleep(5000);
        verifyText(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong[1]"), "$2,950.00");

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.35 Verify the Text “Thank You”
        verifyText(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

        // 2.36 Verify the message “Your order has been successfully processed!”
        verifyText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");

        // 2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        // 2.37 Verify the text “Welcome to our store”

    }
    @After
    public void tearDown() {
        closeBrowser();
    }


}
