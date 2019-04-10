package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.api.v1.model.VendorListDTO;
import guru.springfamework.services.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by carlosmartinez on 2019-04-09 16:23
 */
@RequiredArgsConstructor
@RequestMapping(VendorController.BASE_URL)
@RestController
public class VendorController {

  public static final String BASE_URL = "/api/v1/vendors";

  private final VendorService vendorService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public VendorDTO createVendor(@RequestBody final VendorDTO vendorDTO) {
    return vendorService.createVendor(vendorDTO);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public VendorListDTO getAllVendors() {
    final VendorListDTO dto = new VendorListDTO();
    dto.setVendors(vendorService.getAllVendors());
    return dto;
  }

  @GetMapping({"/{id}"})
  @ResponseStatus(HttpStatus.OK)
  public VendorDTO getVendorById(@PathVariable final Long id) {
    return vendorService.getVendorById(id);
  }

  @DeleteMapping({"/{id}"})
  @ResponseStatus(HttpStatus.OK)
  public void deleteVendorById(@PathVariable final Long id) {
    vendorService.deleteVendorById(id);
  }

  @PutMapping({"/{id}"})
  @ResponseStatus(HttpStatus.OK)
  public VendorDTO updateVendor(@PathVariable final Long id,
      @RequestBody final VendorDTO vendorDTO) {
    return vendorService.saveVendorByDTO(id, vendorDTO);
  }

  @PatchMapping({"/{id}"})
  @ResponseStatus(HttpStatus.OK)
  public VendorDTO patchVendor(@PathVariable final Long id,
      @RequestBody final VendorDTO vendorDTO) {
    return vendorService.patchVendor(id, vendorDTO);
  }
}
