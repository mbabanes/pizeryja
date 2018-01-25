package pl.kielce.tu.iui.iui.model;

import org.springframework.web.context.annotation.SessionScope;
import pl.kielce.tu.iui.iui.controller.json.PizzaJSON;
import pl.kielce.tu.iui.iui.entity.Component;
import pl.kielce.tu.iui.iui.entity.Pizza;

import java.time.LocalDate;


@org.springframework.stereotype.Component
@SessionScope
public class PizzaModel
{
    private PizzaJSON pizzaJSON;
    private Pizza pizza;


    public Pizza getProductOf(PizzaJSON pizzaJSON)
    {
        this.pizzaJSON = pizzaJSON;

        pizza = new Pizza();
        pizza.setName(pizzaJSON.getName());



        pizza.setComponents(pizzaJSON.getComponents());
        pizza.setData(LocalDate.now());

        pizza.setPrice(countPrice());

        return pizza;
    }


    private double countPrice()
    {
        double price = 0.0;

        for(Component component : pizzaJSON.getComponents())
        {
            price += component.getPrice();
        }

        price += 13;

        return price;
    }
}
