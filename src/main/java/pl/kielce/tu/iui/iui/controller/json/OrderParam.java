package pl.kielce.tu.iui.iui.controller.json;

import java.util.List;

public class OrderParam
{
    private List<Long> pizzaIds;

  private AddressJSON addressJSON;


    public List<Long> getPizzaIds()
    {
        return pizzaIds;
    }

    public void setPizzaIds(List<Long> pizzaIds)
    {
        this.pizzaIds = pizzaIds;
    }

    public AddressJSON getAddressJSON()
    {
        return addressJSON;
    }

    public void setAddressJSON(AddressJSON addressJSON)
    {
        this.addressJSON = addressJSON;
    }
}
