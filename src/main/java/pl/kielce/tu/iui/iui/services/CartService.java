package pl.kielce.tu.iui.iui.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pl.kielce.tu.iui.iui.controller.json.response.CartResponse;
import pl.kielce.tu.iui.iui.controller.json.response.PizzaResponseJSON;
import pl.kielce.tu.iui.iui.controller.json.utill.PizzaResponseCreator;
import pl.kielce.tu.iui.iui.entity.Pizza;
import pl.kielce.tu.iui.iui.component.Cart;

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

    public CartResponse getCart()
    {
        return createCartResponse();
    }

    public void addToCart(Long id)
    {
        cart.add(id);
    }

    private CartResponse createCartResponse()
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
