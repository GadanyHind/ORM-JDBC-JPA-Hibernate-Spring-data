package ma.enset.hospitalApp;

import ma.enset.hospitalApp.entities.*;
import ma.enset.hospitalApp.repository.MedecinRepository;
import ma.enset.hospitalApp.repository.PatientRepository;
import ma.enset.hospitalApp.repository.RDVRepository;
import ma.enset.hospitalApp.service.HospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {

        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean /*executer au demmarage
    - retourner un objet , l'objet devient un composent spring */
    CommandLineRunner start(HospitalService hospitalService,
                            PatientRepository patientRepository,
                            RDVRepository rdvRepository,
                            MedecinRepository medecinRepository ){
        return args -> {
            Stream.of("Mohammed","Hassan","Khadija")
                    .forEach(name ->{
            Patient patient=new Patient();
            patient.setNom(name);
            patient.setDateNaissance(LocalDate.of(1972,1,11));
            patient.setMalade(false);
            hospitalService.savePatient(patient);
            });
            Stream.of("Hind","Ayman","Malak")
                    .forEach(name ->{
                        Medecin medecin=new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);
                    });

            Patient patient= patientRepository.findById(1L).orElse(null);
            List<Patient> patient1=patientRepository.findByNom("Hassan");
            Medecin medecin=medecinRepository.findByNom("Hind");
            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.Pending);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            hospitalService.saveRDV(rendezVous);

            RendezVous rendezVous1=rdvRepository.findById(2L).orElse(null);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de consultation .....");
            hospitalService.saveConsultation(consultation);

        };
    }
}
