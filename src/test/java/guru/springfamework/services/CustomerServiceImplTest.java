package guru.springfamework.services;

import guru.springfamework.api.v1.mappers.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Created by carlosmartinez on 2019-04-08 20:28
 */
public class CustomerServiceImplTest {

  @Mock
  private CustomerRepository customerRepository;

  private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

  private CustomerService customerService;

  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    customerService = new CustomerServiceImpl(customerMapper, customerRepository);
  }

  @Test
  public void getAllCustomers() throws Exception {
    //given
    final Customer customer1 = new Customer();
    customer1.setId(1l);
    customer1.setFirstname("Michale");
    customer1.setLastname("Weston");

    final Customer customer2 = new Customer();
    customer2.setId(2l);
    customer2.setFirstname("Sam");
    customer2.setLastname("Axe");

    when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

    //when
    final List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

    //then
    assertEquals(2, customerDTOS.size());
  }

  @Test
  public void getCustomerById() throws Exception {
    //given
    final Customer customer1 = new Customer();
    customer1.setId(1l);
    customer1.setFirstname("Michale");
    customer1.setLastname("Weston");

    when(customerRepository.findById(anyLong())).thenReturn(
        java.util.Optional.ofNullable(customer1));

    //when
    final CustomerDTO customerDTO = customerService.getCustomerById(1L);

    assertEquals("Michale", customerDTO.getFirstname());
  }
}
