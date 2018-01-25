package pl.kielce.tu.iui.iui.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pl.kielce.tu.iui.iui.repository.PizzaRepository;

@Service
@SessionScope
public class PizzaService
{
    @Autowired
    private PizzaRepository pizzaRepository;

}
