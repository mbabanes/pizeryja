package pl.kielce.tu.iui.iui.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;
import pl.kielce.tu.iui.iui.controller.json.PizzaJSON;
import pl.kielce.tu.iui.iui.entity.Component;
import pl.kielce.tu.iui.iui.entity.Pizza;
import pl.kielce.tu.iui.iui.services.ComponentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Component
@SessionScope
public class PizzaModel
{
    private PizzaJSON pizzaJSON;

    @Autowired
    private ComponentService componentService;


    public Pizza getProductOf(PizzaJSON pizzaJSON)
    {
        this.pizzaJSON = pizzaJSON;

        Pizza pizza = new Pizza();
        pizza.setName(pizzaJSON.getName());


        List<Component> components = this.getComponents();
        pizza.setComponents(components);
        pizza.setData(LocalDate.now());

        pizza.setPrice(countPriceBy(components));

        return pizza;
    }

    private List<Component> getComponents()
    {
        List<Component> components = new ArrayList<>();
        pizzaJSON.getComponents().forEach(id ->{
            Component component = componentService.getComponentById(id);
            components.add(component);
        });

        return components;

    }


    private double countPriceBy(List<Component> components)
    {
        double price = 0.0;

        for(Component component : components)
        {
            price += component.getPrice();
        }

        price += 13;

        return price;
    }
}
