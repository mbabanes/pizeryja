package pl.kielce.tu.iui.iui.controller.json;

import pl.kielce.tu.iui.iui.controller.json.ComponentJSON;
import pl.kielce.tu.iui.iui.entity.Component;

import java.util.List;

public class PizzaJSON
{

    private String name;
    private List<Component> components;


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Component> getComponents()
    {
        return components;
    }

    public void setComponents(List<Component> components)
    {
        this.components = components;
    }

}
