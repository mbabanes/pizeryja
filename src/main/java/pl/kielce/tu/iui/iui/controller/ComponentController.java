package pl.kielce.tu.iui.iui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kielce.tu.iui.iui.controller.json.ComponentJSON;
import pl.kielce.tu.iui.iui.controller.json.utill.ComponentConverter;
import pl.kielce.tu.iui.iui.entity.Component;
import pl.kielce.tu.iui.iui.repository.ComponentRepository;
import pl.kielce.tu.iui.iui.services.ComponentService;
import pl.kielce.tu.iui.iui.validators.ComponentValidator;

import java.util.List;

@RestController
@RequestMapping("component")
public class ComponentController
{
    @Autowired
    private ComponentRepository componentRepository;

    @Autowired
    private ComponentService componentService;

    @CrossOrigin
    @GetMapping("all")
    public ResponseEntity<List<Component>> getAllComponents()
    {
        try
        {
            return ResponseEntity.ok(componentService.getAllComponent());
        } catch(Exception e)
        {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @CrossOrigin
    @GetMapping("all/{page}")
    public ResponseEntity<List<Component>> getPageComponent(@PathVariable Integer page)
    {
        try
        {
            return ResponseEntity.ok(componentService.getComponentPagable(page));
        } catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @CrossOrigin
    @PostMapping("add")
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
        return ResponseEntity.ok(componentService.getComponentById(id));
    }
}
