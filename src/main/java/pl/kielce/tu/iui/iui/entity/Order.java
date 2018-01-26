package pl.kielce.tu.iui.iui.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "orders")
public class Order implements Serializable
{

    private static final long serialVersionUID = -3147943021699886694L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    private double price;

    @ManyToMany
    @JoinTable(name = "orders_pizza",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
    private List<Pizza> pizzas;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private boolean done;
    private boolean canceled;


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }


    public List<Pizza> getPizzas()
    {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas)
    {
        this.pizzas = pizzas;
    }


    public LocalDate getData()
    {
        return data;
    }

    public void setData(LocalDate data)
    {
        this.data = data;
    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public boolean isDone()
    {
        return done;
    }

    public void setDone(boolean done)
    {
        this.done = done;
    }

    public boolean isCanceled()
    {
        return canceled;
    }

    public void setCanceled(boolean canceled)
    {
        this.canceled = canceled;
    }
}
