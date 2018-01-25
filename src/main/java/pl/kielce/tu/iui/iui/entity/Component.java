package pl.kielce.tu.iui.iui.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Component implements Serializable
{
    private static final long serialVersionUID = 1378811328221835433L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double count;
    private double price;
    private LocalDate data;

    @ManyToMany(mappedBy = "components")
    private List<Pizza> pizzas;

    public Component()
    {
        super();
    }

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

    public double getCount()
    {
        return count;
    }

    public void setCount(double count)
    {
        this.count = count;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }


    public LocalDate getData()
    {
        return data;
    }

    public void setData(LocalDate data)
    {
        this.data = data;
    }

    public List<Pizza> getPizzas()
    {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas)
    {
        this.pizzas = pizzas;
    }
}
