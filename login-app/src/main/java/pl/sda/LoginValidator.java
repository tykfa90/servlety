package pl.sda;

import org.apache.commons.lang3.StringUtils;

public class LoginValidator {
    /**
     * This method validates if userName and password are correct.
     * If userName or password are empty then return false.
     * If userName or password length is smaller than 6 then return false.
     * If userName is Javaktw9 and password is SDA2019 then return true.
     * Username and password are case sensitive.
     * @param userName
     * @param password
     * @return
     */
    boolean isValid(String userName, String password) {
        if (userName.length()<6 || password.length()<6) {
            return false;
        }
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            return false;
        }
        if (!("Javaktw9").equals(userName) || !("SDA2019").equals(password)) {
            return false;
        }
        return true;
    }

}
