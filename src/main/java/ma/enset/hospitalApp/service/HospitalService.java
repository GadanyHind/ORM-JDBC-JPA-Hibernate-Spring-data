package ma.enset.hospitalApp.service;

import ma.enset.hospitalApp.entities.Consultation;
import ma.enset.hospitalApp.entities.Medecin;
import ma.enset.hospitalApp.entities.Patient;
import ma.enset.hospitalApp.entities.RendezVous;

public interface HospitalService {
     Patient savePatient(Patient patient);
     Medecin saveMedecin(Medecin medecin);
     RendezVous saveRDV(RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);
}
