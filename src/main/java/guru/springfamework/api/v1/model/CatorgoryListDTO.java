package guru.springfamework.api.v1.model;

/**
 * Created by carlosmartinez on 2019-04-08 18:51
 */

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatorgoryListDTO {

  List<CategoryDTO> categories;
}
