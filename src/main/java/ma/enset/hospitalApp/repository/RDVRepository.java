package ma.enset.hospitalApp.repository;

import ma.enset.hospitalApp.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RDVRepository extends JpaRepository<RendezVous,Long> {
}
