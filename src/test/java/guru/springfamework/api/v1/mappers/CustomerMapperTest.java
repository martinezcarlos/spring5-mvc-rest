package guru.springfamework.api.v1.mappers;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by carlosmartinez on 2019-04-08 20:23
 */
class CustomerMapperTest {

  private static final String FIRSTNAME = "Jimmy";
  private static final String LASTNAME = "Fallon";
  private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

  @Test
  public void entityToDTO() throws Exception {
    //given
    final Customer customer = new Customer();
    customer.setFirstname(FIRSTNAME);
    customer.setLastname(LASTNAME);

    //when
    final CustomerDTO customerDTO = customerMapper.entityToDTO(customer);

    //then
    assertEquals(FIRSTNAME, customerDTO.getFirstname());
    assertEquals(LASTNAME, customerDTO.getLastname());
  }
}