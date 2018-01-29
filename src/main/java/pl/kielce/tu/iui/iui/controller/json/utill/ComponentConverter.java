package pl.kielce.tu.iui.iui.controller.json.utill;

import pl.kielce.tu.iui.iui.controller.json.ComponentJSON;
import pl.kielce.tu.iui.iui.controller.json.response.ComponentResponseJSON;
import pl.kielce.tu.iui.iui.entity.Component;

public class ComponentConverter
{
    public static Component convertToComponent(ComponentJSON componentJSON)
    {
        Component component = new Component();
        component.setName(componentJSON.getName());
        component.setCount(stringToDouble(componentJSON.getCount()));
        component.setPrice(stringToDouble(componentJSON.getPrice()));

        return component;
    }

    public static ComponentResponseJSON convertToComponentResponseJSON(Component component)
    {
        ComponentResponseJSON componentResponseJSON = new ComponentResponseJSON();
        componentResponseJSON.setId(component.getId());
        componentResponseJSON.setName(component.getName());
//        componentResponseJSONList.add(componentResponseJSON);

        return componentResponseJSON;
    }


    private static double stringToDouble(String string)
    {
        return Double.valueOf(string);
    }
}
