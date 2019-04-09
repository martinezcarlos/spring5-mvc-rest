package guru.springfamework.services;

import guru.springfamework.api.v1.mappers.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by carlosmartinez on 2019-04-08 20:14
 */
@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

  private final CustomerMapper customerMapper;
  private final CustomerRepository customerRepository;

  @Override
  public List<CustomerDTO> getAllCustomers() {
    return customerRepository.findAll().stream().map(customer -> {
      CustomerDTO customerDTO = customerMapper.entityToDTO(customer);
      customerDTO.setCustomerUrl(String.format("/api/v1/customers/%d", customer.getId()));
      return customerDTO;
    }).collect(Collectors.toList());
  }

  @Override
  public CustomerDTO getCustomerById(final Long id) {

    return customerRepository.findById(id).map(c -> {
      CustomerDTO dto = customerMapper.entityToDTO(c);
      dto.setCustomerUrl(String.format("/api/v1/customer/%d", id));
      return dto;
    }).orElseThrow(RuntimeException::new); //todo implement better exception handling
  }

  @Override
  public CustomerDTO createCustomer(final CustomerDTO customerDTO) {
    return saveAndReturnDTO(customerMapper.dtoToEntity(customerDTO));
  }

  @Override
  public CustomerDTO saveCustomerByDTO(final Long id, final CustomerDTO customerDTO) {
    final Customer customer = customerMapper.dtoToEntity(customerDTO);
    customer.setId(id);
    return saveAndReturnDTO(customer);
  }

  @Override
  public CustomerDTO patchCustomer(final Long id, final CustomerDTO customerDTO) {
    return customerRepository.findById(id).map(customer -> {

      if (customerDTO.getFirstname() != null) {
        customer.setFirstname(customerDTO.getFirstname());
      }

      if (customerDTO.getLastname() != null) {
        customer.setLastname(customerDTO.getLastname());
      }

      return saveAndReturnDTO(customer);
    }).orElseThrow(RuntimeException::new); //todo implement better exception handling;
  }

  private CustomerDTO saveAndReturnDTO(final Customer customer) {
    final Customer savedCustomer = customerRepository.save(customer);
    final CustomerDTO returningDTO = customerMapper.entityToDTO(savedCustomer);
    returningDTO.setCustomerUrl("/api/v1/customer/" + savedCustomer.getId());
    return returningDTO;
  }
}
