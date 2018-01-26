package pl.kielce.tu.iui.iui.model;

import pl.kielce.tu.iui.iui.entity.Address;

import java.util.List;

public class OrderDetails
{
    private List<Long> pizzaIds;
    private Address address;
    private String email;

    public OrderDetails(List<Long> pizzaIds, Address address, String email)
    {
        this.pizzaIds = pizzaIds;
        this.address = address;
        this.email = email;
    }

    public List<Long> getPizzaIds()
    {
        return pizzaIds;
    }

    public Address getAddress()
    {
        return address;
    }

    public String getEmail()
    {
        return email;
    }
}
