package pl.sda;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;

public class UserRegisterValidator {
    public Collection<String> validateUSer(User user) {
        Collection<String> validationMessages = new ArrayList<>();

        if (StringUtils.isNotBlank(user.getFirstName())) {
            validationMessages.add("First name cannot be empty.");
        }
        if (StringUtils.isNotBlank(user.getLastName())) {
            validationMessages.add("Last name cannot be empty.");
        }
        if (StringUtils.isNotBlank(user.getAddress().getCity())) {
            validationMessages.add("City name cannot be empty.");
        }
        if (StringUtils.isNotBlank(user.getAddress().getStreet())) {
            validationMessages.add("Street name cannot be empty.");
        }
        if (StringUtils.isNotBlank(user.getAddress().getHouseNo())) {
            validationMessages.add("House number cannot be empty.");
        }
        return validationMessages;
    }
}
