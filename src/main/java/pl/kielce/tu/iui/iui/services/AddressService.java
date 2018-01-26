package pl.kielce.tu.iui.iui.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kielce.tu.iui.iui.entity.Address;
import pl.kielce.tu.iui.iui.repository.AddressRepository;

@Service
public class AddressService
{
    @Autowired
    private AddressRepository addressRepository;

    public void insert(Address address)
    {
        addressRepository.save(address);
    }
}
