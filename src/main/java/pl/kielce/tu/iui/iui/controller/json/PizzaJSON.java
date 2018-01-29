package pl.kielce.tu.iui.iui.controller.json;

import pl.kielce.tu.iui.iui.controller.json.ComponentJSON;
import pl.kielce.tu.iui.iui.entity.Component;

import java.util.List;

public class PizzaJSON
{

    private String name;
    private List<Long> components;


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Long> getComponents()
    {
        return components;
    }

    public void setComponents(List<Long> components)
    {
        this.components = components;
    }

}
