package pl.kielce.tu.iui.iui.controller.json;

import java.util.List;

public class OrderParam
{
    private List<Long> pizzaIds;

  private AddressParamJSON addressParamJSON;


    public List<Long> getPizzaIds()
    {
        return pizzaIds;
    }

    public void setPizzaIds(List<Long> pizzaIds)
    {
        this.pizzaIds = pizzaIds;
    }

    public AddressParamJSON getAddressParamJSON()
    {
        return addressParamJSON;
    }

    public void setAddressParamJSON(AddressParamJSON addressParamJSON)
    {
        this.addressParamJSON = addressParamJSON;
    }
}
