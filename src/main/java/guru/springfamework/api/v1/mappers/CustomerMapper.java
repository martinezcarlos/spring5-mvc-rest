package guru.springfamework.api.v1.mappers;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by carlosmartinez on 2019-04-08 20:17
 */
@Mapper
public interface CustomerMapper {
  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  CustomerDTO entityToDTO(Customer customer);

  Customer dtoToEntity(CustomerDTO customerDTO);
}
