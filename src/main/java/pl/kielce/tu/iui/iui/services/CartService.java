package pl.kielce.tu.iui.iui.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pl.kielce.tu.iui.iui.controller.json.CartResponse;
import pl.kielce.tu.iui.iui.controller.json.PizzaResponseJSON;
import pl.kielce.tu.iui.iui.controller.json.utill.PizzaResponseCreator;
import pl.kielce.tu.iui.iui.entity.Pizza;
import pl.kielce.tu.iui.iui.model.Cart;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class CartService
{
    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private Cart cart;

    public CartResponse createCartResponse()
    {
        CartResponse cartResponse = new CartResponse();

        List<Pizza> pizzas = new ArrayList<>();
        double price = 0.0;
        for(Long id : cart.getPizzasIds())
        {
            Pizza pizza = pizzaService.getPizzaById(id);
            price += pizza.getPrice();
            pizzas.add(pizza);
        }

        List<PizzaResponseJSON> pizzaResponseJSONList = PizzaResponseCreator.createResponseOf(pizzas);
        cartResponse.setPizzas(pizzaResponseJSONList);
        cartResponse.setPrice(price);

        return cartResponse;
    }
}
