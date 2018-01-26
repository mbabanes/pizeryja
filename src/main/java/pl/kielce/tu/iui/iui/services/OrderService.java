package pl.kielce.tu.iui.iui.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kielce.tu.iui.iui.entity.Order;
import pl.kielce.tu.iui.iui.repository.OrderRepository;

@Service
public class OrderService
{
    @Autowired
    private OrderRepository orderRepository;

    public void save(Order order)
    {
        orderRepository.save(order);
    }

    public Order getOrderById(Integer id)
    {
        return orderRepository.findOne(id);
    }
}
