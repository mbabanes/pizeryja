package pl.kielce.tu.iui.iui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kielce.tu.iui.iui.entity.Component;

import java.util.List;

public interface ComponentRepository extends JpaRepository<Component, Long>
{
    List<Component> getAllByNameIn(List<String> name);
}
