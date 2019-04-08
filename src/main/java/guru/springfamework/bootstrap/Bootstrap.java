package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by carlosmartinez on 2019-04-08 15:18
 */
@RequiredArgsConstructor
@Component
public class Bootstrap implements CommandLineRunner {

  private final CategoryRepository categoryRepository;
  private final CustomerRepository customerRepository;

  @Override
  public void run(final String... args) {
    loadCategories();
    loadCustomers();
  }

  private void loadCategories() {
    final List<Category> catgories = Arrays.asList(Category.builder().name("Fruits").build(),
        Category.builder().name("Dried").build(), Category.builder().name("Fresh").build(),
        Category.builder().name("Exotic").build(), Category.builder().name("Nuts").build());
    categoryRepository.saveAll(catgories);
    System.out.println("Categories loaded = " + categoryRepository.count());
  }

  private void loadCustomers() {
    final List<Customer> customers = Arrays.asList(
        Customer.builder().firstname("Michale").lastname("Weston").build(),
        Customer.builder().firstname("Sam").lastname("Axe").build());
    customerRepository.saveAll(customers);
    System.out.println("Customers loaded = " + customerRepository.count());
  }
}
