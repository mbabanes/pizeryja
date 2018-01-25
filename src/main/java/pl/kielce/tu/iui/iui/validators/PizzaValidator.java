package pl.kielce.tu.iui.iui.validators;

import pl.kielce.tu.iui.iui.controller.json.PizzaJSON;

import java.util.ArrayList;
import java.util.List;

public class PizzaValidator
{
    private List<Error> errors = new ArrayList<>();
    private PizzaJSON pizzaJSON;


    public PizzaValidator(PizzaJSON pizzaJSON)
    {
        this.pizzaJSON = pizzaJSON;
    }


    public void validate() throws IllegalArgumentException
    {
        if (nameIsEmpty())
        {
            errors.add(new Error("pizza.name", pizzaJSON.getName(), ErrorType.WRONG_FORMAT));
            throw new IllegalArgumentException("Pizza name field is empty");
        }


        if(componentsIsTooLess())
        {
            errors.add(new Error("pizza.components", null, ErrorType.TOO_LESS));
            throw new IllegalArgumentException("Pizza components need 3 or more components");
        }
    }

    public List<Error> getErrors()
    {
        return errors;
    }

    private boolean componentsIsTooLess()
    {
        return ( pizzaJSON.getComponents().isEmpty() ) || (pizzaJSON.getComponents().size() < 3);
    }

    private boolean nameIsEmpty()
    {
        return pizzaJSON.getName().length() == 0;
    }
}
