package pl.sda;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginValidatorTest {

    private static final String USERNAME = "Javaktw9";
    private static final String PASSWORD = "SDA2019";
    private LoginValidator loginValidatorSUT;

    @Before
    public void setup() {
        loginValidatorSUT = new LoginValidator(); // SUT - Subject Under Testing
    }

    @Test
    public void shouldReturnFalseWhenUserNameIsEmpty() {
        // given
        String userName = "";
        // when
        boolean valid = loginValidatorSUT.isValid(userName, PASSWORD);
        // then
        assertThat(valid, is(false));
    }

    @Test
    public void shouldReturnFalseWhenPasswordIsEmpty() {
        // given
        String password = "";
        // when
        boolean valid = loginValidatorSUT.isValid(USERNAME, password);
        // then
        assertThat(valid, is(false));
    }

    @Test
    public void shouldReturnFalseWhenUserNameIsLessThanSixCharacters() {
        // given
        String userName = "Java";
        // when
        boolean valid = loginValidatorSUT.isValid(userName, PASSWORD);
        // then
        assertThat(valid, is(false));
    }

    @Test
    public void shouldReturnFalseWhenPasswordIsLessThanSixCharacters() {
        // given
        String password = "SDA";
        // when
        boolean valid = loginValidatorSUT.isValid(USERNAME, password);
        // then
        assertThat(valid, is(false));
    }

    @Test
    public void shouldReturnFalseIfUserNameAndPasswordAreIncorrect() {
        // given
        String userName = "Blabla";
        String password = "kotek";
        // when
        boolean valid = loginValidatorSUT.isValid(userName, password);
        // then
        assertThat(valid, is(false));
    }

    @Test
    public void shouldReturnFalseForNonCaseSensitiveLoginOrPassword() {
        // given
        String userName = "javakTW9";
        String password = "sdA2019";
        // when
        boolean valid = loginValidatorSUT.isValid(userName, password);
        // then
        assertThat(valid, is(false));
    }
}