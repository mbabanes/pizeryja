package pl.kielce.tu.iui.iui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.kielce.tu.iui.iui.entity.User;


public interface UserRepository extends JpaRepository<User, Long>
{
    User findByEmail(String email);

    @Query("SELECT u.id FROM User u WHERE u.email = :email")
    long getIdByEmail(@Param("email") String email);
}


