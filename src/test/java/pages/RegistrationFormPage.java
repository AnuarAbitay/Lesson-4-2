package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();

    // Locators
    SelenideElement firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    userEmailInput = $("#userEmail"),
                    genderWrapper = $("#genterWrapper"),
                    userNumberInput = $("#userNumber"),
                    dateOfBirthInput = $("#dateOfBirthInput"),
                    subjectsInput = $("#subjectsInput"),
                    hobbiesWrapper = $("#hobbiesWrapper"),
                    uploadPicture = $("#uploadPicture"),
                    currentAddressInput = $("#currentAddress"),
                    stateInput = $("#state"),
                    stateCityWrapper = $("#stateCity-wrapper"),
                    cityInput = $("#city"),
                    submitButton = $("#submit"),
                    tableResponsive = $(".table-responsive"),
                    closeButton = $("#closeLargeModal");

    //Actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationFormPage setEmail(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    public RegistrationFormPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();

        return this;
    }

    public RegistrationFormPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;
    }

    public RegistrationFormPage setBirthDate(String birthDay, String birthMonth, String birthYear) {
        dateOfBirthInput.click();
        calendarComponent.setData(birthDay, birthMonth, birthYear);

        return this;
    }

    public RegistrationFormPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbies(String hobbies) {
        hobbiesWrapper.$(byText(hobbies)).click();

        return this;
    }

    public RegistrationFormPage uploadPicture(String picturePath) {
        uploadPicture.uploadFromClasspath(picturePath);

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String userCurrentAddress) {
        currentAddressInput.setValue(userCurrentAddress);

        return this;
    }

    public RegistrationFormPage setState(String state) {
        stateInput.click();
        stateCityWrapper.$(byText(state)).click();

        return this;
    }

    public RegistrationFormPage setCity(String city) {
        cityInput.click();
        stateCityWrapper.$(byText(city)).click();

        return this;
    }

    public RegistrationFormPage submit() {
        submitButton.click();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        tableResponsive.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage close() {
        closeButton.click();

        return this;
    }
}
