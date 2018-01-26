package pl.kielce.tu.iui.iui.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kielce.tu.iui.iui.entity.User;
import pl.kielce.tu.iui.iui.repository.UserRepository;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public void insert(User user)
    {
        userRepository.save(user);
    }

    public User getUserByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

    public long getIdByEmail(String email)
    {
        return userRepository.getIdByEmail(email);
    }
}
