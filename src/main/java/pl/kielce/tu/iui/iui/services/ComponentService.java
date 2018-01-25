package pl.kielce.tu.iui.iui.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.kielce.tu.iui.iui.entity.Component;
import pl.kielce.tu.iui.iui.repository.ComponentRepository;

import java.util.List;

@Service
public class ComponentService
{
    @Autowired
    private ComponentRepository componentRepository;

    public List<Component> getAllComponent()
    {
        return componentRepository.findAll();
    }


    public List<Component> getComponentPagable(int page)
    {
        Page<Component> componentPage = componentRepository.findAll(new PageRequest(page, 10));
        return componentPage.getContent();
    }

    public void insert(Component component)
    {
        componentRepository.save(component);
    }

    public Component getComponentById(long id)
    {
        return componentRepository.getOne(id);
    }
}
