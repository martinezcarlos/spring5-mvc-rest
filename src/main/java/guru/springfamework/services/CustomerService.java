package guru.springfamework.services;

import guru.springfamework.api.v1.model.CustomerDTO;
import java.util.List;

/**
 * Created by carlosmartinez on 2019-04-08 20:13
 */
public interface CustomerService {

  List<CustomerDTO> getAllCustomers();

  CustomerDTO getCustomerById(Long id);

  CustomerDTO createCustomer(CustomerDTO customerDTO);

  CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO);
}
