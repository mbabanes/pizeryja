package pl.kielce.tu.iui.iui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.iui.iui.entity.User;
import pl.kielce.tu.iui.iui.repository.UserRepository;
import pl.kielce.tu.iui.iui.validators.UserValidator;

import javax.validation.Valid;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    UserRepository userRepository;





    @CrossOrigin
    @GetMapping("{name}")
    public ResponseEntity<List<User>> getResources(@PathVariable String name) {

        List<User> users = userRepository.findAll();
        StringBuilder message = new StringBuilder();
        for(User usr : users)
        {
            message.append(usr);
        }

        return new ResponseEntity< List<User>>(users, HttpStatus.OK);
    }

}