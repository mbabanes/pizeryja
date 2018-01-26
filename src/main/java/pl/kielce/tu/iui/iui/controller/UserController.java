package pl.kielce.tu.iui.iui.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.iui.iui.controller.json.UserJSON;
import pl.kielce.tu.iui.iui.controller.json.utill.UserConverter;
import pl.kielce.tu.iui.iui.entity.User;
import pl.kielce.tu.iui.iui.repository.UserRepository;
import pl.kielce.tu.iui.iui.services.UserService;
import pl.kielce.tu.iui.iui.validators.UserValidator;

@RestController
@RequestMapping("user")
public class UserController
{
    @Autowired
    private UserService userService;


    @CrossOrigin
    @PostMapping("register")
    public ResponseEntity<?> createUser(@RequestBody UserJSON userJSON)
    {
        UserValidator userValidator = new UserValidator(userJSON);
        try
        {
            userValidator.validate();
            User user = UserConverter.convertToUser(userJSON);
            user.setPhoneNumber(user.getPhoneNumber().replaceAll("[- ]", ""));
            userService.insert(user);
            return ResponseEntity.ok("Udana rejestracja");
        }catch(IllegalArgumentException e)
        {
            return ResponseEntity.badRequest().body(userValidator.getErrors());
        }catch(Exception sqlE)
        {
            sqlE.printStackTrace();
            return ResponseEntity.badRequest().body("Bład bazy danych");
        }
    }
}