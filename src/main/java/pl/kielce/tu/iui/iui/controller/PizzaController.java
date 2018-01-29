package pl.kielce.tu.iui.iui.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.iui.iui.controller.json.PizzaJSON;
import pl.kielce.tu.iui.iui.controller.json.response.PizzaResponseJSON;
import pl.kielce.tu.iui.iui.controller.json.utill.PizzaResponseCreator;
import pl.kielce.tu.iui.iui.entity.Pizza;
import pl.kielce.tu.iui.iui.model.PizzaModel;
import pl.kielce.tu.iui.iui.repository.PizzaRepository;
import pl.kielce.tu.iui.iui.services.PizzaService;
import pl.kielce.tu.iui.iui.validators.PizzaValidator;

import java.util.List;

@RestController
@RequestMapping("pizza")
public class PizzaController
{
    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private PizzaModel pizzaModel;


    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<?> createPizza(@RequestBody PizzaJSON pizzaJSON)
//    public ResponseEntity<?> createPizza(@RequestBody String pizzaJSON)
    {
        PizzaValidator pizzaValidator = new PizzaValidator(pizzaJSON);
        try
        {
            pizzaValidator.validate();
            Pizza pizza = pizzaModel.getProductOf(pizzaJSON);
            pizzaService.save(pizza);
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
    @GetMapping("/")
    public ResponseEntity<?> getAllPizzas()
    {
        List<Pizza> pizzas = pizzaService.getAll();
        List<PizzaResponseJSON> pizzaResponseJSONList = PizzaResponseCreator.createResponseOf(pizzas);
        return ResponseEntity.ok(pizzaResponseJSONList);
    }

    @CrossOrigin
    @GetMapping("{id}")
    public ResponseEntity<?> getPizzaById(@PathVariable Long id)
    {
        Pizza pizza = pizzaService.getPizzaById(id);

        if (pizza != null)
        {
            PizzaResponseJSON pizzaResponseJSON = PizzaResponseCreator.createPizzaResponseOf(pizza);
            return ResponseEntity.ok(pizzaResponseJSON);
        }
        return ResponseEntity.ok(null);
    }

    @CrossOrigin
    @PostMapping("components")
    public ResponseEntity<?> getPizzaByComponents(@RequestBody List<String> components)
    {
        List<Pizza> pizzas = pizzaService.getPizzasBy(components);
        List<PizzaResponseJSON> pizzaResponseJSONList = PizzaResponseCreator.createResponseOf(pizzas);


        return ResponseEntity.ok(pizzaResponseJSONList);
    }
}
