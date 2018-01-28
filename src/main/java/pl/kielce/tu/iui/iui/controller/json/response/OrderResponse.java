package pl.kielce.tu.iui.iui.controller.json.response;

import pl.kielce.tu.iui.iui.controller.json.AddressJSON;

import java.util.List;

public class OrderResponse
{
    private Integer id;
    private List<PizzaResponseJSON> pizzas;
    private AddressJSON address;
    private UserResponse user;
    private double price;
    private boolean canceled;
    private boolean done;
    private String date;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public List<PizzaResponseJSON> getPizzas()
    {
        return pizzas;
    }

    public void setPizzas(List<PizzaResponseJSON> pizzas)
    {
        this.pizzas = pizzas;
    }

    public AddressJSON getAddress()
    {
        return address;
    }

    public void setAddress(AddressJSON address)
    {
        this.address = address;
    }

    public UserResponse getUser()
    {
        return user;
    }

    public void setUser(UserResponse user)
    {
        this.user = user;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public boolean isCanceled()
    {
        return canceled;
    }

    public void setCanceled(boolean canceled)
    {
        this.canceled = canceled;
    }

    public boolean isDone()
    {
        return done;
    }

    public void setDone(boolean done)
    {
        this.done = done;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }
}
