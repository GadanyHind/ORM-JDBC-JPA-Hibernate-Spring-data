package ma.enset.hospitalApp.repository;

import ma.enset.hospitalApp.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
