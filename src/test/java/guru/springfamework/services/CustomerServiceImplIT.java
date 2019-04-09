package guru.springfamework.services;

import guru.springfamework.api.v1.mappers.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.bootstrap.Bootstrap;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by carlosmartinez on 2019-04-09 11:03
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class CustomerServiceImplIT {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  private CustomerService customerService;

  @BeforeEach
  void setUp() {
    System.out.println("Loading Customer Data");
    System.out.println(customerRepository.findAll().size());

    //setup data for testing
    final Bootstrap bootstrap = new Bootstrap(categoryRepository, customerRepository);
    bootstrap.run(); //load data

    customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
  }

  @Test
  void patchCustomerUpdateFirstName() {
    final String updatedName = "UpdatedName";
    final long id = getCustomerIdValue();

    final Customer originalCustomer = customerRepository.getOne(id);
    assertNotNull(originalCustomer);
    //save original first name
    final String originalFirstName = originalCustomer.getFirstname();
    final String originalLastName = originalCustomer.getLastname();

    final CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setFirstname(updatedName);

    customerService.patchCustomer(id, customerDTO);

    final Customer updatedCustomer = customerRepository.findById(id).orElse(null);

    assertNotNull(updatedCustomer);
    assertEquals(updatedName, updatedCustomer.getFirstname());
    assertThat(originalFirstName, not(equalTo(updatedCustomer.getFirstname())));
    assertThat(originalLastName, equalTo(updatedCustomer.getLastname()));
  }

  private Long getCustomerIdValue() {
    final List<Customer> customers = customerRepository.findAll();

    System.out.println("Customers Found: " + customers.size());

    //return first id
    return customers.get(0).getId();
  }

  @Test
  void patchCustomerUpdateLastName() {
    final String updatedName = "UpdatedName";
    final long id = getCustomerIdValue();

    final Customer originalCustomer = customerRepository.getOne(id);
    assertNotNull(originalCustomer);

    //save original first/last name
    final String originalFirstName = originalCustomer.getFirstname();
    final String originalLastName = originalCustomer.getLastname();

    final CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setLastname(updatedName);

    customerService.patchCustomer(id, customerDTO);

    final Customer updatedCustomer = customerRepository.findById(id).orElse(null);

    assertNotNull(updatedCustomer);
    assertEquals(updatedName, updatedCustomer.getLastname());
    assertThat(originalFirstName, equalTo(updatedCustomer.getFirstname()));
    assertThat(originalLastName, not(equalTo(updatedCustomer.getLastname())));
  }
}
