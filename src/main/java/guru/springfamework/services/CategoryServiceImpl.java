package guru.springfamework.services;

import guru.springfamework.api.v1.mappers.CategoryMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.repositories.CategoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by carlosmartinez on 2019-04-08 17:24
 */
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryMapper categoryMapper;
  private final CategoryRepository categoryRepository;

  @Override
  public List<CategoryDTO> getAllCategories() {
    return categoryRepository.findAll()
        .stream()
        .map(categoryMapper::entityToDTO)
        .collect(Collectors.toList());
  }

  @Override
  public CategoryDTO getCategoryByName(final String name) {
    return categoryMapper.entityToDTO(categoryRepository.findByName(name));
  }
}
