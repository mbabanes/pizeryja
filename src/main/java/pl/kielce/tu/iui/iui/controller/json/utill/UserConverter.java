package pl.kielce.tu.iui.iui.controller.json.utill;

import pl.kielce.tu.iui.iui.controller.json.UserJSON;
import pl.kielce.tu.iui.iui.controller.json.response.UserResponse;
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

    public static UserResponse cpnvertToUserResponse(User user)
    {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setPhone(user.getPhoneNumber());

        return userResponse;
    }
}
