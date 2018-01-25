package pl.kielce.tu.iui.iui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kielce.tu.iui.iui.entity.User;


public interface UserRepository extends JpaRepository<User, Long>
{
    User findByEmail(String email);
}


