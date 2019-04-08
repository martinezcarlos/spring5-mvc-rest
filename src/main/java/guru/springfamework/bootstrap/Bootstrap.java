package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;
import java.util.Arrays;
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

  @Override
  public void run(final String... args) {
    final Category[] catgories = new Category[] {
        Category.builder().name("Fruits").build(), Category.builder().name("Dried").build(),
        Category.builder().name("Fresh").build(), Category.builder().name("Exotic").build(),
        Category.builder().name("Nuts").build()
    };
    categoryRepository.saveAll(Arrays.asList(catgories));
    System.out.println("Data loaded = " + categoryRepository.count());
  }
}
