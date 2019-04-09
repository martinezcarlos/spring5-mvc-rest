package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.CustomerListDTO;
import guru.springfamework.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by carlosmartinez on 2019-04-08 20:18
 */
@RequiredArgsConstructor
@RequestMapping(CustomerController.BASE_URL)
@Controller
public class CustomerController {

  public static final String BASE_URL = "/api/v1/customers";
  private final CustomerService customerService;

  @GetMapping
  public ResponseEntity<CustomerListDTO> getListofCustomers() {
    return new ResponseEntity<>(new CustomerListDTO(customerService.getAllCustomers()),
        HttpStatus.OK);
  }

  @GetMapping({"/{id}"})
  public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable final Long id) {
    return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<CustomerDTO> createCustomer(@RequestBody final CustomerDTO customerDTO) {
    return new ResponseEntity<>(customerService.createCustomer(customerDTO), HttpStatus.CREATED);
  }

  @PutMapping({"/{id}"})
  public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable final Long id,
      @RequestBody final CustomerDTO customerDTO) {
    return new ResponseEntity<>(customerService.saveCustomerByDTO(id, customerDTO), HttpStatus.OK);
  }

  @PatchMapping({"/{id}"})
  public ResponseEntity<CustomerDTO> patchCustomer(@PathVariable final Long id,
      @RequestBody final CustomerDTO customerDTO) {
    return new ResponseEntity<>(customerService.patchCustomer(id, customerDTO), HttpStatus.OK);
  }

  @DeleteMapping({"/{id}"})
  public ResponseEntity<Void> deleteCustomer(@PathVariable final Long id) {
    customerService.deleteCustomerById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
