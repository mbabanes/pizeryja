package pl.kielce.tu.iui.iui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kielce.tu.iui.iui.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>
{
}
