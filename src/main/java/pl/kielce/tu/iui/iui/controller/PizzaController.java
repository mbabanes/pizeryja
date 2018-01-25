package pl.kielce.tu.iui.iui.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.iui.iui.controller.json.ComponentResponseJSON;
import pl.kielce.tu.iui.iui.controller.json.PizzaJSON;
import pl.kielce.tu.iui.iui.controller.json.PizzaResponseJSON;
import pl.kielce.tu.iui.iui.entity.Pizza;
import pl.kielce.tu.iui.iui.model.PizzaModel;
import pl.kielce.tu.iui.iui.repository.ComponentRepository;
import pl.kielce.tu.iui.iui.repository.PizzaRepository;
import pl.kielce.tu.iui.iui.validators.PizzaValidator;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pizza")
public class PizzaController
{
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private PizzaModel pizzaModel;


    @CrossOrigin
    @PostMapping("create")
    public ResponseEntity<?> createPizza(@RequestBody PizzaJSON pizzaJSON)
//    public ResponseEntity<?> createPizza(@RequestBody String pizzaJSON)
    {
        PizzaValidator pizzaValidator = new PizzaValidator(pizzaJSON);
        try
        {
            pizzaValidator.validate();
            Pizza pizza = pizzaModel.getProductOf(pizzaJSON);
            pizzaRepository.save(pizza);
            return ResponseEntity.ok(null);
        }catch (IllegalArgumentException e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(pizzaValidator.getErrors());
        }catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Błąd bazy danych");
        }
    }

    @CrossOrigin
    @GetMapping("all")
    public ResponseEntity<?> getAllPizzas()
    {
        List<Pizza> pizzas = pizzaRepository.findAll();
        List<PizzaResponseJSON> pizzaResponseJSONList = preparaResponse(pizzas);
        return ResponseEntity.ok(pizzaResponseJSONList);
    }

    @CrossOrigin
    @GetMapping("{id}")
    public ResponseEntity<?> getPizzaById(@PathVariable Long id)
    {
        Pizza pizza = pizzaRepository.findOne(id);

        if (pizza != null)
        {
            PizzaResponseJSON pizzaResponseJSON = preparePizzaResponse(pizza);
//        List<ComponentResponseJSON> componentResponseJSONList = prepareComponentsResponse(pizza);
//        pizzaResponseJSON.setComponents(componentResponseJSONList);

            return ResponseEntity.ok(pizzaResponseJSON);
        }
        return ResponseEntity.ok(null);
    }

    @CrossOrigin
    @PostMapping("byComponents")
    public ResponseEntity<?> getPizzaByComponents(@RequestBody List<String> components)
    {
        List<Pizza> pizzas = pizzaRepository.dupa(components);
        List<PizzaResponseJSON> pizzaResponseJSONList = preparaResponse(pizzas);


        return ResponseEntity.ok(pizzaResponseJSONList);
    }


    private List<PizzaResponseJSON> preparaResponse(List<Pizza> pizzas)
    {
        List<PizzaResponseJSON> pizzaResponseJSONList = new ArrayList<>();

        pizzas.forEach(pizza ->
        {
            PizzaResponseJSON pizzaResponseJSON = preparePizzaResponse(pizza);
            pizzaResponseJSONList.add(pizzaResponseJSON);
        });

        return pizzaResponseJSONList;
    }

    private PizzaResponseJSON preparePizzaResponse(Pizza pizza)
    {
        PizzaResponseJSON pizzaResponseJSON = new PizzaResponseJSON();
        pizzaResponseJSON.setId(pizza.getId());
        pizzaResponseJSON.setName(pizza.getName());
        pizzaResponseJSON.setPrice(pizza.getPrice());
        List<ComponentResponseJSON> componentResponseJSONList = prepareComponentsResponse(pizza);

        pizzaResponseJSON.setComponents(componentResponseJSONList);
        return pizzaResponseJSON;
    }

    private List<ComponentResponseJSON> prepareComponentsResponse(Pizza pizza)
    {
        List<ComponentResponseJSON> componentResponseJSONList = new ArrayList<>();
        pizza.getComponents().forEach(component ->
        {
            ComponentResponseJSON componentResponseJSON = new ComponentResponseJSON();
            componentResponseJSON.setId(component.getId());
            componentResponseJSON.setName(component.getName());
            componentResponseJSONList.add(componentResponseJSON);
        });

        return componentResponseJSONList;
    }

}
