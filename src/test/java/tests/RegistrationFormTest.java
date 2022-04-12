package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class RegistrationFormTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
           lastName = faker.name().lastName(),
           userEmail = faker.internet().emailAddress(),
           userGender = "Male",
           userNumber = faker.number().digits(10),
           birthDay = "30",
           birthMonth = "October",
           birthYear = "1999",
           subject = "Math",
           hobbies = "Sports",
           pictureName = "1.png",
           userCurrentAddress = faker.address().fullAddress(),
           state = "NCR",
           city = "Delhi",
           fullName = firstName +" " + lastName,
           dateOfBirth = String.format("%s %s,%s", birthDay, birthMonth, birthYear),
           stateCity = state + " " + city;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setEmail(userEmail)
                            .setGender(userGender)
                            .setUserNumber(userNumber)
                            .setBirthDate(birthDay, birthMonth, birthYear)
                            .setSubject(subject)
                            .setHobbies(hobbies)
                            .uploadPicture("img/" + pictureName)
                            .setCurrentAddress(userCurrentAddress)
                            .setState(state)
                            .setCity(city)
                            .submit()
                            .checkResult("Student Name", fullName)
                            .checkResult("Student Email", userEmail)
                            .checkResult("Gender", userGender)
                            .checkResult("Mobile", userNumber)
                            .checkResult("Date of Birth", dateOfBirth)
                            .checkResult("Subjects", subject)
                            .checkResult("Hobbies", hobbies)
                            .checkResult("Picture", pictureName)
                            .checkResult("Address", userCurrentAddress)
                            .checkResult("State and City", stateCity)
                            .close();
    }
}

