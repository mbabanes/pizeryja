package pl.kielce.tu.iui.iui.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.kielce.tu.iui.iui.controller.json.OrderParam;
import pl.kielce.tu.iui.iui.entity.Address;
import pl.kielce.tu.iui.iui.entity.Order;
import pl.kielce.tu.iui.iui.entity.Pizza;
import pl.kielce.tu.iui.iui.entity.User;
import pl.kielce.tu.iui.iui.repository.PizzaRepository;
import pl.kielce.tu.iui.iui.services.PizzaService;
import pl.kielce.tu.iui.iui.services.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderModel
{
    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private UserService userService;

    private List<Long> pizzaIds;

    private String email;

    public OrderModel()
    {
    }

//    public OrderModel(OrderParam orderParam, String email)
//    {
//        this.orderParam = orderParam;
//        this.email = email;
//    }

    public Order createOrder(OrderDetails orderDetails)
    {
        this.pizzaIds = orderDetails.getPizzaIds();
        this.email = orderDetails.getEmail();

        Order order = new Order();
        putPizzasAndCountPrice(order);
        putUser(order);

        order.setData(LocalDate.now());
        order.setCanceled(false);
        order.setDone(false);
        order.setAddress(orderDetails.getAddress());

        return order;
    }


    private void putPizzasAndCountPrice(Order order)
    {
        List<Pizza> pizzas = new ArrayList<>();
        double price = 0;
        for (Long id : this.pizzaIds)
        {

            Pizza pizza = new Pizza();
            pizza.setId(id);
            pizza.setPrice(pizzaService.getPriceById(id));
            price += pizza.getPrice();

            pizzas.add(pizza);
        }

        order.setPrice(price);
        order.setPizzas(pizzas);
    }

    private void putUser(Order order)
    {
        User user = new User();
        long userId = userService.getIdByEmail(email);
        user.setId(userId);

        order.setUser(user);
    }
}
