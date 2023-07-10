package utils;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Utils {

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

}
