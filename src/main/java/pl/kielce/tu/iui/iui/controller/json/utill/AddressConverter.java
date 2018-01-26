package pl.kielce.tu.iui.iui.controller.json.utill;

import pl.kielce.tu.iui.iui.controller.json.AddressJSON;
import pl.kielce.tu.iui.iui.entity.Address;

public class AddressConverter
{
    public static Address convertToAddress(AddressJSON addressParam)
    {
        Address address = new Address();
        address.setCity(addressParam.getCity());
        address.setHouseNumber(addressParam.getHouseNumber());
        address.setStreet(addressParam.getStreet());

        return address;
    }

    public static AddressJSON convertToAddressJSON(Address address)
    {
        AddressJSON addressJSON = new AddressJSON();
        addressJSON.setCity(address.getCity());
        addressJSON.setHouseNumber(address.getHouseNumber());
        addressJSON.setStreet(address.getStreet());

        return addressJSON;
    }
}
