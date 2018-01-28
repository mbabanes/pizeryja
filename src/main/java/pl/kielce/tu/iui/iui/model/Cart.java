package pl.kielce.tu.iui.iui.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class Cart
{
    private List<Long> pizzasIds;

    public Cart()
    {
        pizzasIds = new ArrayList<>();
    }

    public void add(long pizzaId)
    {
        pizzasIds.add(pizzaId);
    }

    public List<Long> getPizzasIds()
    {
        return pizzasIds;
    }

    public void setPizzasIds(List<Long> pizzasIds)
    {
        this.pizzasIds = pizzasIds;
    }
}
