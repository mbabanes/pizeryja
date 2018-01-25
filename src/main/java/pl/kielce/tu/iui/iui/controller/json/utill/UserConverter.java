package pl.kielce.tu.iui.iui.controller.json.utill;

import pl.kielce.tu.iui.iui.controller.json.UserJSON;
import pl.kielce.tu.iui.iui.entity.User;

public class UserConverter
{
    public static User convertToUser(UserJSON userJSON)
    {
        User user = new User();
        user.setFirstName(userJSON.getFirstName());
        user.setLastName(userJSON.getLastName());
        user.setEmail(userJSON.getEmail());
        user.setPassword(userJSON.getPassword());
        user.setPhoneNumber(userJSON.getPhoneNumber());

        return user;
    }
}
