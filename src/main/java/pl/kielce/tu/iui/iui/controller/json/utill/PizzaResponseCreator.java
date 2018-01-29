package pl.kielce.tu.iui.iui.controller.json.utill;

import pl.kielce.tu.iui.iui.controller.json.response.ComponentResponseJSON;
import pl.kielce.tu.iui.iui.controller.json.response.PizzaResponseJSON;
import pl.kielce.tu.iui.iui.entity.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaResponseCreator
{
    public static List<PizzaResponseJSON> createResponseOf(List<Pizza> pizzas)
    {
        List<PizzaResponseJSON> pizzaResponseJSONList = new ArrayList<>();

        pizzas.forEach(pizza ->
        {
            PizzaResponseJSON pizzaResponseJSON = createPizzaResponseOf(pizza);
            pizzaResponseJSONList.add(pizzaResponseJSON);
        });

        return pizzaResponseJSONList;
    }

    public static PizzaResponseJSON createPizzaResponseOf(Pizza pizza)
    {
        PizzaResponseJSON pizzaResponseJSON = new PizzaResponseJSON();
        pizzaResponseJSON.setId(pizza.getId());
        pizzaResponseJSON.setName(pizza.getName());
        pizzaResponseJSON.setPrice(pizza.getPrice());
        List<ComponentResponseJSON> componentResponseJSONList = prepareComponentsResponse(pizza);

        pizzaResponseJSON.setComponents(componentResponseJSONList);
        return pizzaResponseJSON;
    }

    private static List<ComponentResponseJSON> prepareComponentsResponse(Pizza pizza)
    {
        List<ComponentResponseJSON> componentResponseJSONList = new ArrayList<>();
        pizza.getComponents().forEach(component ->
        {
//            ComponentResponseJSON componentResponseJSON = new ComponentResponseJSON();
//            componentResponseJSON.setId(component.getId());
//            componentResponseJSON.setName(component.getName());
            ComponentResponseJSON componentResponseJSON = ComponentConverter.convertToComponentResponseJSON(component);
            componentResponseJSONList.add(componentResponseJSON);
        });

        return componentResponseJSONList;
    }
}
