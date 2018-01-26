package pl.kielce.tu.iui.iui.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pl.kielce.tu.iui.iui.entity.Pizza;
import pl.kielce.tu.iui.iui.repository.PizzaRepository;

import java.util.List;

@Service
public class PizzaService
{
    @Autowired
    private PizzaRepository pizzaRepository;


    public double getPriceById(Long id)
    {
        return pizzaRepository.getPriceById(id);
    }

    public void save(Pizza pizza)
    {
        pizzaRepository.save(pizza);
    }

    public List<Pizza> getAll()
    {
        return pizzaRepository.findAll();
    }

    public Pizza getPizzaById(Long id)
    {
        return pizzaRepository.findOne(id);
    }

    public List<Pizza> getPizzasBy(List<String> components)
    {
        return pizzaRepository.findByComponentsName(components);
    }
}
