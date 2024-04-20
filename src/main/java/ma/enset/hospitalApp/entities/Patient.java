package ma.enset.hospitalApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Collection;

//Entity JPA
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
//"@Data" (lombok) ajouter les getters et les setters dans le bit code
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private LocalDate dateNaissance;
    private boolean malade;
    @OneToMany(mappedBy = "patient",fetch=FetchType.LAZY)
    private Collection<RendezVous> rendezVous;

}
