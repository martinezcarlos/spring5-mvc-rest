package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.CustomerListDTO;
import guru.springfamework.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by carlosmartinez on 2019-04-08 20:18
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
@Controller
public class CustomerController {

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
}
