package pl.kielce.tu.iui.iui.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Favorite implements Serializable{

	private static final long serialVersionUID = 8646501194698206131L;

	private long id;
	private User user;
	private Pizza pizza;
	private Supplement supplement;
	private LocalDate data;
	
	public Favorite()
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

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Pizza getPizza()
	{
		return pizza;
	}

	public void setPizza(Pizza pizza)
	{
		this.pizza = pizza;
	}

	public Supplement getSupplement()
	{
		return supplement;
	}

	public void setSupplement(Supplement supplement)
	{
		this.supplement = supplement;
	}

	public LocalDate getData()
	{
		return data;
	}

	public void setData(LocalDate data)
	{
		this.data = data;
	}
}
