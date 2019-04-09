package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CatorgoryListDTO;
import guru.springfamework.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by carlosmartinez on 2019-04-08 18:38
 */
@RequestMapping(CategoryController.BASE_URL)
@RestController
public class CategoryController {

  static final String BASE_URL = "/api/v1/categories";
  private final CategoryService categoryService;

  public CategoryController(final CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public CatorgoryListDTO getallCatetories() {
    return new CatorgoryListDTO(categoryService.getAllCategories());
  }

  @GetMapping("/{name}")
  @ResponseStatus(HttpStatus.OK)
  public CategoryDTO getCategoryByName(@PathVariable final String name) {
    return categoryService.getCategoryByName(name);
  }
}
