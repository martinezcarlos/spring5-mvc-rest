package guru.springfamework.services;

import guru.springfamework.api.v1.model.CategoryDTO;
import java.util.List;

/**
 * Created by carlosmartinez on 2019-04-08 17:22
 */
public interface CategoryService {

  List<CategoryDTO> getAllCategories();

  CategoryDTO getCategoryByName(String name);
}
