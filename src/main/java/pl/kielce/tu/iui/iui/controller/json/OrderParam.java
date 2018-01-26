package pl.kielce.tu.iui.iui.controller.json;

import java.util.List;

public class OrderParam
{
    private List<Long> pizzaIds;

    private String city;
    private String street;
    private String houseNumber;


    public List<Long> getPizzaIds()
    {
        return pizzaIds;
    }

    public void setPizzaIds(List<Long> pizzaIds)
    {
        this.pizzaIds = pizzaIds;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getHouseNumber()
    {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber)
    {
        this.houseNumber = houseNumber;
    }
}
