package pl.kielce.tu.iui.iui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kielce.tu.iui.iui.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>
{

}
