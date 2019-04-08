package guru.springfamework.repositories;

import guru.springfamework.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by carlosmartinez on 2019-04-08 20:12
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
