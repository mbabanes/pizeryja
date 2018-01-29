package pl.kielce.tu.iui.iui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kielce.tu.iui.iui.controller.json.response.ComponentResponseJSON;
import pl.kielce.tu.iui.iui.controller.json.response.PizzaResponseJSON;
import pl.kielce.tu.iui.iui.controller.json.utill.ComponentConverter;
import pl.kielce.tu.iui.iui.controller.json.utill.PizzaResponseCreator;
import pl.kielce.tu.iui.iui.entity.Component;
import pl.kielce.tu.iui.iui.entity.Order;
import pl.kielce.tu.iui.iui.entity.Pizza;
import pl.kielce.tu.iui.iui.entity.User;
import pl.kielce.tu.iui.iui.services.PizzaService;
import pl.kielce.tu.iui.iui.services.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("suggestions")
public class SuggestController
{
    @Autowired
    private UserService userService;
    @Autowired
    private PizzaService pizzaService;

    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<?> getSuggestions()
    {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        User currentUser = userService.getUserByEmail(currentUserEmail);

        List<Order> orders = currentUser.getOrders();

        List<List<Pizza>> pizzas = new ArrayList<>();

        for(Order order : orders)
        {
            pizzas.add(order.getPizzas());
        }

        Set<Component> components = new HashSet<>();
        List<String> componentsNames = new ArrayList<>();

        for (List<Pizza> pizzas1 : pizzas )
        {
            for(Pizza pizza : pizzas1)
            {
                for(Component component : pizza.getComponents())
                {
                    if(component.getName().toUpperCase().equals("SER"))
                        continue;
                    components.add(component);
                    componentsNames.add(component.getName());
                }
            }
        }

        List<Pizza> suggestPizzas = pizzaService.getPizzasBy(componentsNames);
        List<PizzaResponseJSON> pizzaResponseJSONList = PizzaResponseCreator.createResponseOf(suggestPizzas);

//        Set<ComponentResponseJSON> componentResponseJSONList = ComponentConverter.createComponentResponseSetOf(components);

        return ResponseEntity.ok(pizzaResponseJSONList);
    }

    @CrossOrigin
    @GetMapping("/usedComponents")
    public ResponseEntity<?> getSuggestionsAsList()
    {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        User currentUser = userService.getUserByEmail(currentUserEmail);

        List<Order> orders = currentUser.getOrders();

        List<List<Pizza>> pizzas = new ArrayList<>();

        for(Order order : orders)
        {
            pizzas.add(order.getPizzas());
        }

        Set<Component> components = new HashSet<>();
        List<String> componentsNames = new ArrayList<>();

        for (List<Pizza> pizzas1 : pizzas )
        {
            for(Pizza pizza : pizzas1)
            {
                for(Component component : pizza.getComponents())
                {
                    if(component.getName().toUpperCase().equals("SER"))
                        continue;
                    components.add(component);
                    componentsNames.add(component.getName());
                }
            }
        }




        Set<ComponentResponseJSON> componentResponseJSONList = ComponentConverter.createComponentResponseSetOf(components);

        return ResponseEntity.ok(componentResponseJSONList);
    }
}
