package guru.springfamework.repositories;

import guru.springfamework.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by carlosmartinez on 2019-04-09 14:22
 */
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
