package pl.kielce.tu.iui.iui.controller.json.utill;

import pl.kielce.tu.iui.iui.controller.json.ComponentJSON;
import pl.kielce.tu.iui.iui.controller.json.response.ComponentResponseJSON;
import pl.kielce.tu.iui.iui.entity.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static List<ComponentResponseJSON> createComponentResponseListOf(List<Component> components)
    {
        List<ComponentResponseJSON> componentResponseJSONList = new ArrayList<>();
        components.forEach(component -> {
            componentResponseJSONList.add(ComponentConverter.convertToComponentResponseJSON(component));
        });
        return componentResponseJSONList;
    }

    public static Set<ComponentResponseJSON> createComponentResponseSetOf(Set<Component> components)
    {
        Set<ComponentResponseJSON> componentResponseJSONHashSet = new HashSet<>();
        components.forEach(component -> {
            componentResponseJSONHashSet.add(ComponentConverter.convertToComponentResponseJSON(component));
        });
        return componentResponseJSONHashSet;
    }

    private static double stringToDouble(String string)
    {
        return Double.valueOf(string);
    }
}
