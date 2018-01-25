package pl.kielce.tu.iui.iui.validators;

import org.assertj.core.api.WithAssertions;
import org.junit.Before;
import org.junit.Test;
import pl.kielce.tu.iui.iui.controller.json.UserJSON;
import pl.kielce.tu.iui.iui.entity.User;

import java.util.List;

public class UserValidatorTest implements WithAssertions
{
    private UserJSON user;
    private UserValidator userValidator;

    @Before
    public void setUp()
    {
        user = new UserJSON();
        user.setEmail("wrongemailformat");

        userValidator = new UserValidator(user);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenUserHasWrongFormatOfEmailThenThrowsIllegalArgumentException()
    {
        userValidator.validate();
    }

    @Test
    public void whenUserHasWrongFormatOfEmailThenListOfErrorHasError()
    {
        try
        {
            userValidator.validate();
        }catch (IllegalArgumentException e)
        {

        }
        testListOfError("email", user.getEmail(), ErrorType.WRONG_FORMAT);
    }



    @Test(expected = IllegalArgumentException.class)
    public void whenUserHasWrongFormatOfFirstNameThenThrowsIllegalArgumentException()
    {
        user.setEmail("email@wp.pl");
        user.setFirstName("123Wrong name type");
        userValidator.validate();
    }

    @Test
    public void whenUserHasWrongFormatOfFirstNameThenListOfErrorHasError()
    {
        user.setEmail("email@wp.pl");
        user.setFirstName("123Wrpmg na,e type");

        try
        {
            userValidator.validate();
        }catch(IllegalArgumentException e)
        {

        }
        testListOfError("firstName", user.getFirstName(), ErrorType.WRONG_FORMAT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenUserHasWrongFormatOfLastNameThenThrowsIllegalArgumentException()
    {
        user.setEmail("email@wp.pl");
        user.setFirstName("firstName");
        user.setLastName("1234!@#wrong");
        userValidator.validate();
    }

    @Test
    public void whenUserHasWrongLastNameThenListOfErrorHasError()
    {
        user.setEmail("email@wp.pl");
        user.setFirstName("firstName");
        user.setLastName("1234!@#wrong");
        try{
            userValidator.validate();
        }catch (IllegalArgumentException e){}

        testListOfError("lastName", user.getLastName(), ErrorType.WRONG_FORMAT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenUserHasWrongPhoneNumberFormatThenThrowsIllegalArgumentException()
    {
        user.setEmail("email@wp.pl");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPhoneNumber("wrongPhoneNumber");
        userValidator.validate();
    }

    @Test
    public void whenUserHasWrongPhoneNumberFormatThenErrorOfListHasError()
    {
        user.setEmail("email@wp.pl");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPhoneNumber("wrongPhoneNumber");
        try{
            userValidator.validate();
        }catch (IllegalArgumentException e){}
        testListOfError("phoneNumber", user.getPhoneNumber(), ErrorType.WRONG_FORMAT);
    }

    @Test
    public void whenUserCanUse3FormatOfPhoneNumber()
    {
//        user.setEmail("email@wp.pl");
//        user.setFirstName("firstName");
//        user.setLastName("lastName");
//        user.setPhoneNumber("123456789");
//        userValidator.validate();
//
//        user.setPhoneNumber("123 456 789");
//        userValidator.validate();
//
//        user.setPhoneNumber("123-456-789");
//        userValidator.validate();
    }


    private void testListOfError(String expectedField, String expectedValue, ErrorType errorType)
    {
        List<Error> errors = userValidator.getErrors();
        Error error = errors.get(0);
        assertThat(error.getField()).isEqualTo(expectedField);
        assertThat(error.getValue()).isEqualTo(expectedValue);
        assertThat(error.getErrorType()).isEqualTo(errorType);
    }


}
