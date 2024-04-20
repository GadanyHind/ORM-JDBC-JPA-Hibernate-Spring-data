package ma.enset.hospitalApp.service;

import jakarta.transaction.Transactional;
import ma.enset.hospitalApp.entities.Consultation;
import ma.enset.hospitalApp.entities.Medecin;
import ma.enset.hospitalApp.entities.Patient;
import ma.enset.hospitalApp.entities.RendezVous;
import ma.enset.hospitalApp.repository.ConsultationRepository;
import ma.enset.hospitalApp.repository.MedecinRepository;
import ma.enset.hospitalApp.repository.PatientRepository;
import ma.enset.hospitalApp.repository.RDVRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {
   private PatientRepository patientRepository;
   private MedecinRepository medecinRepository;
   private RDVRepository RDVRepository;
   private ConsultationRepository consultationRepository;

   public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, ma.enset.hospitalApp.repository.RDVRepository RDVRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.RDVRepository = RDVRepository;
        this.consultationRepository = consultationRepository;
    }
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return RDVRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
