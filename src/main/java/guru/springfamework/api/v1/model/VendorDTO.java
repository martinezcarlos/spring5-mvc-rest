package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by carlosmartinez on 2019-04-09 14:17
 */
@Data
public class VendorDTO {

  private Long id;
  private String name;
  @JsonProperty("vendor_url")
  private String vendorUrl;
}
