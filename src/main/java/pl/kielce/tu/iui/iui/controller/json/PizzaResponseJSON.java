package pl.kielce.tu.iui.iui.controller.json;

import java.util.List;

public class PizzaResponseJSON
{
    private long id;
    private String name;
    private List<ComponentResponseJSON> components;
    private double price;


    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<ComponentResponseJSON> getComponents()
    {
        return components;
    }

    public void setComponents(List<ComponentResponseJSON> components)
    {
        this.components = components;
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
