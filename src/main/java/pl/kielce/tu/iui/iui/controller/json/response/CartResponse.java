package pl.kielce.tu.iui.iui.controller.json.response;


import java.util.ArrayList;
import java.util.List;



public class CartResponse
{
    private List<PizzaResponseJSON> pizzas;
    private double price;

    public CartResponse()
    {
        this.pizzas = new ArrayList<>();
    }

    public List<PizzaResponseJSON> getPizzas()
    {
        return pizzas;
    }

    public void setPizzas(List<PizzaResponseJSON> pizzas)
    {
        this.pizzas = pizzas;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
