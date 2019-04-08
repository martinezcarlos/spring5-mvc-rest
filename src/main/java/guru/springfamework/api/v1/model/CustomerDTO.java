package guru.springfamework.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by carlosmartinez on 2019-04-08 20:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

  private String firstname;
  private String lastname;
  private String customerUrl;
}
