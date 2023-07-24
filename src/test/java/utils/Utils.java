package utils;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@Getter
@Setter
public class Utils {

    private String userName;
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String state;
    private String city;
    private String zipCode;
    private String mobileNumber;



    public void randomData(){

        Faker faker = new Faker();
        setUserName(faker.name().username());
        setFirstName(faker.name().firstName());
        setLastName(faker.name().lastName());
        setCompany(faker.company().name());
        setAddress1(faker.address().fullAddress());
        setAddress2(faker.address().secondaryAddress());
        setState(faker.address().state());
        setCity(faker.address().city());
        setZipCode(faker.address().zipCode());
        setMobileNumber(faker.phoneNumber().cellPhone());
    }

    public void saveJsonList(String userEmail, String userPassword) throws IOException, ParseException {

        String fileName = "./src/test/resources/user.json";
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;

        JSONObject userObject = new JSONObject();
        userObject.put("userEmail", userEmail);
        userObject.put("userPassword", userPassword);

        jsonArray.add(userObject);

        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();
        System.out.println("Data Saved");

    }

    public static void waitForElement(WebDriver driver, WebElement element, int TIME_SECOND) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_SECOND));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static List readJsondata(String fileName) throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        return jsonArray;

    }

    public static void scrollThePage(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }


}
