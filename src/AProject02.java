import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AProject02 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\__DuoTech\\SoftWare\\Automation\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        driver.findElement(By.linkText("Order")).click();

        String randQtyOrder = String.valueOf((int) (1 + Math.random() * 98));

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(randQtyOrder);
        Thread.sleep(500);
        driver.findElement(By.xpath("//ol/li[5]/input[@class='btn_dark']")).click();


        String actualPrice = driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_txtUnitPrice']")).getAttribute("value");
        String expectedPrice = "100";


        if (actualPrice.equals(expectedPrice)) {
            System.out.println("Price is verified");
        } else {
            System.out.println("price is not verified");
        }


//        Assert.assertEquals(actualPrice,expectedPrice);
//        System.out.println("price is verified");



        if (Integer.parseInt(driver.findElement(By.xpath("//ol/li[2]/input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")).getAttribute("value")) > 10 &&
                Integer.parseInt(driver.findElement(By.xpath("//ol/li[4]/input[@id='ctl00_MainContent_fmwOrder_txtDiscount']")).getAttribute("value")) == 8) {
            System.out.println("Discount is verified.");
        } else {
            System.out.println("Warning! To get a discount you need to add 10+ products.");
        }

//        int expectedDiscount = 8;
//        int actualDiscount= Integer.parseInt(driver.findElement(By.xpath("//ol/li[4]/input[@id='ctl00_MainContent_fmwOrder_txtDiscount']")).getAttribute("value")) ;
//        int orderQuantity = Integer.parseInt(driver.findElement(By.xpath("//ol/li[2]/input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")).getAttribute("value"));
//
//        if (orderQuantity > 10){
//            Assert.assertEquals(actualDiscount, expectedDiscount);
//            System.out.println("discount test passed");
//    }



        StringBuilder randFirstName = new StringBuilder();
        StringBuilder randLastName = new StringBuilder();


        for (int i = 0; i < 8; i++){
            char charFirstN = (char) (97 + Math.random()*26);
            char charLastN = (char)(97 + Math.random()*26);
            randFirstName.append(charFirstN) ;
            randLastName.append(charLastN);
        }

        randFirstName.insert(0,((char)(65 + Math.random()*26)));
        randLastName.insert(0,((char)(65 + Math.random()*26)));


        String randStreetAddress;
        String randHouseNumber = "";
        String randStreetName = "";;
        String randCity = "";
        String randState = "";
        String randZip = "";

        for (int i = 0; i <4; i++){
            int digit = (int)(1+ Math.random()*9);
            randHouseNumber += "" + digit;
        }

        for (int i = 0; i < 8; i++){
            char ch = (char)(97 + Math.random()*26);
            randStreetName += ch;
        }

        randStreetAddress = randHouseNumber + " " + ((char)(65 + Math.random()*26)) + randStreetName;


        for (int i = 0; i < 7;i++){
            char ch = (char)(97 + Math.random()*26);
            randCity += ch;
        }

        randCity = ((char)(65+ Math.random()*26)) + randCity;

        for (int i = 0; i < 2; i++){
            char ch = (char)(65 + Math.random()*26);
            randState += ch;
        }

        for (int i = 0; i < 5; i++){
            int digit =  (int)(1 + Math.random()*9);
            randZip += String.valueOf(digit);
        }


        driver.findElement(By.xpath("//ol[2]/li/child::input[@id ='ctl00_MainContent_fmwOrder_txtName']")).sendKeys(randFirstName + " " + randLastName);
        driver.findElement(By.xpath("//ol[2]/li[2]/input[@id = 'ctl00_MainContent_fmwOrder_TextBox2']")).sendKeys( randStreetAddress);
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")).sendKeys(randCity);
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")).sendKeys(randState);
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")).sendKeys(randZip);


        String visaCard = "4";
        String masterCard = "5";
        String amexCard = "3";

        for (int i = 0; i < 14; i++){
            int digit = (int)(1+ Math.random()*9);
            visaCard += digit;
            masterCard += digit;
            amexCard += digit;
        }

        visaCard += (int)(1 + Math.random()*9);
        masterCard += (int)(1 + Math.random()*9);




        switch((int)(1 + Math.random()*3)){
            case 1: driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']")).click();
                driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys(visaCard);
                break;
            case 2: driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']")).click();
                driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys(masterCard);
                break;
            case 3: driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_2']")).click();
                driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys(amexCard);
                break;
        }



        String expDate = "";
        String mmExpDate = "" +((int)(1 + Math.random()*12));
        String yyExpDate = "/" +((int)(22 + Math.random()*7));

        if(mmExpDate.length() == 1){
            mmExpDate = "0" + mmExpDate;
        }

        if(yyExpDate.equals("/22")){
            mmExpDate = "" + (int)(4+ Math.random()*8);
        }

        expDate = mmExpDate + yyExpDate;



        driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox1']")).sendKeys(expDate);
        driver.findElement(By.xpath("//a [@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();


        String expectedResult = "New order has been successfully added.";
        String actualResult = driver.findElement(By.xpath("//strong")).getText();

        if(actualResult.equals(expectedResult)){
            System.out.println("Order verified");
        }else{
            System.out.println("Something went wrong with your order");
        }

//        Assert.assertEquals(actualResult, expectedResult);
//        System.out.println("Order verified");


         driver.findElement(By.xpath("//a [@id='ctl00_logout']")).click();


          driver.close();


    }
}

