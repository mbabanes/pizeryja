package pl.kielce.tu.iui.iui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.kielce.tu.iui.iui.entity.Pizza;


import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza, Long>
{
    @Query("SELECT DISTINCT p FROM Pizza p JOIN p.components pc WHERE pc.name IN (:components)")
    List<Pizza> dupa(@Param("components") List<String> components);

    Optional<Pizza> findById(Long id);
}
