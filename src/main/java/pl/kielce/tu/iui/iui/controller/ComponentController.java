package pl.kielce.tu.iui.iui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.iui.iui.controller.json.ComponentJSON;
import pl.kielce.tu.iui.iui.controller.json.response.ComponentResponseJSON;
import pl.kielce.tu.iui.iui.controller.json.utill.ComponentConverter;
import pl.kielce.tu.iui.iui.entity.Component;
import pl.kielce.tu.iui.iui.repository.ComponentRepository;
import pl.kielce.tu.iui.iui.services.ComponentService;
import pl.kielce.tu.iui.iui.validators.ComponentValidator;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("components")
public class ComponentController
{
    @Autowired
    private ComponentService componentService;

    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<?> getAllComponents()
    {
        try
        {
            List<Component> components = componentService.getAllComponent();
            List<ComponentResponseJSON> componentResponseJSONList = createComponentResponseListOf(components);

            return ResponseEntity.ok(componentResponseJSONList);
        } catch(Exception e)
        {
            return ResponseEntity.badRequest().body(null);
        }
    }



    @CrossOrigin
    @GetMapping("all/{page}")
    public ResponseEntity<?> getPageComponent(@PathVariable Integer page)
    {
        try
        {
            List<Component> components = componentService.getComponentPagable(page);
            List<ComponentResponseJSON> componentResponseJSONList = createComponentResponseListOf(components);
            return ResponseEntity.ok(componentResponseJSONList);
        } catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<?> addComponent(@RequestBody ComponentJSON componentJSON)
    {
        ComponentValidator componentValidator = new ComponentValidator(componentJSON);
        try{
            componentValidator.validate();
            Component component = ComponentConverter.convertToComponent(componentJSON);
            componentService.insert(component);
            return ResponseEntity.ok("Dodano skladnik");
        } catch (IllegalArgumentException e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(componentValidator.getErrors());
        } catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Błąd bazy danych.");
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> getComponentById(@PathVariable long id)
    {
        Component component = componentService.getComponentById(id);
        ComponentResponseJSON componentResponseJSON = ComponentConverter.convertToComponentResponseJSON(component);
        return ResponseEntity.ok(componentResponseJSON);
    }

    private List<ComponentResponseJSON> createComponentResponseListOf(List<Component> components)
    {
        List<ComponentResponseJSON> componentResponseJSONList = new ArrayList<>();
        components.forEach(component -> {
            componentResponseJSONList.add(ComponentConverter.convertToComponentResponseJSON(component));
        });
        return componentResponseJSONList;
    }
}
