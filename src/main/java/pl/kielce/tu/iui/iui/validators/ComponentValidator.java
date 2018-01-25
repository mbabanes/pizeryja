package pl.kielce.tu.iui.iui.validators;

import pl.kielce.tu.iui.iui.controller.json.ComponentJSON;
import pl.kielce.tu.iui.iui.validators.utill.LetterValidator;
import pl.kielce.tu.iui.iui.validators.utill.NumberValidator;

import java.util.ArrayList;
import java.util.List;

public class ComponentValidator
{
    private List<Error> errors = new ArrayList();

    private ComponentJSON componentJSON;

    public ComponentValidator(ComponentJSON componentJSON)
    {
        this.componentJSON = componentJSON;
    }

    public void validate() throws IllegalArgumentException
    {
        checkName();
        checkCount();
        checkPrice();
    }


    private void checkPrice()
    {
        if (!NumberValidator.validate(componentJSON.getPrice()))
        {
            errors.add(new Error("component.price", componentJSON.getPrice(), ErrorType.WRONG_FORMAT));
            throw new IllegalArgumentException("Price is not a number");
        }
    }

    private void checkCount()
    {
        if (!NumberValidator.validate(componentJSON.getCount()))
        {
            errors.add(new Error("component.count", componentJSON.getCount(), ErrorType.WRONG_FORMAT));
            throw new IllegalArgumentException("Count is not a number");
        }
    }

    private void checkName()
    {
        if (!LetterValidator.validate(componentJSON.getName()))
        {
            errors.add(new Error("component.name", componentJSON.getName(), ErrorType.WRONG_FORMAT));
            throw new IllegalArgumentException("Name is in wrong format");
        }
    }

    public List<Error> getErrors()
    {
        return errors;
    }
}
