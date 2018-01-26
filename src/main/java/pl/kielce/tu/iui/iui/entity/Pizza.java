package pl.kielce.tu.iui.iui.entity;

import org.hibernate.annotations.Fetch;
import org.springframework.data.repository.cdi.Eager;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Pizza implements Serializable {

	private static final long serialVersionUID = 7694599471257093934L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="pizza_components",
			joinColumns= {@JoinColumn(name="pizza_id")},
			inverseJoinColumns={@JoinColumn(name="component_id")})
	private List<Component> components;

	private LocalDate data;
	private double price;


	@ManyToMany(mappedBy="pizzas")
	private List<Order> orders;


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

	public List<Component> getComponents()
	{
		return components;
	}

	public void setComponents(List<Component> components)
	{
		this.components = components;
	}

	public LocalDate getData()
	{
		return data;
	}

	public void setData(LocalDate data)
	{
		this.data = data;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public List<Order> getOrders()
	{
		return orders;
	}

	public void setOrders(List<Order> orders)
	{
		this.orders = orders;
	}
}
