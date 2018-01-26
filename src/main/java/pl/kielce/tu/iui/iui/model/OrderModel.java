package pl.kielce.tu.iui.iui.model;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kielce.tu.iui.iui.controller.json.OrderParam;
import pl.kielce.tu.iui.iui.entity.Order;
import pl.kielce.tu.iui.iui.entity.Pizza;
import pl.kielce.tu.iui.iui.entity.User;
import pl.kielce.tu.iui.iui.repository.PizzaRepository;
import pl.kielce.tu.iui.iui.services.PizzaService;
import pl.kielce.tu.iui.iui.services.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderModel
{
    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private UserService userService;

    private OrderParam orderParam;

    private String email;

    public OrderModel(OrderParam orderParam, String email)
    {
        this.orderParam = orderParam;
        this.email = email;
    }

    public Order createOrder()
    {
        Order order = new Order();
        putPizzasAndCountPrice(order);
        putUser(order);
        order.setData(LocalDate.now());

        return order;
    }


    private void putPizzasAndCountPrice(Order order)
    {
        List<Pizza> pizzas = new ArrayList<>();
        double price = 0;
        for(Long id : orderParam.getPizzaIds())
        {
            Pizza pizza = new Pizza();
            pizza.setId(id);
            pizza.setPrice(pizzaService.getPriceById(id));
            price += pizza.getPrice();

            pizzas.add(pizza);
        }

        order.setPrice(price);
    }

    private void putUser(Order order)
    {
        User user = new User();
        long userId = userService.getIdByEmail(email);
        user.setId(userId);

        order.setUser(user);
    }
}
