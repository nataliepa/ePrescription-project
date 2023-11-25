package com.natalia.ePrescription.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient_drugs")
public class PatientDrug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name= "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;

    // when the prescription is crated a timestamp is created
    // Temporal belongs to Hibernate (JPA Annotation)
    // we could use java.util.Calendar
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    public PatientDrug(Patient patient, Drug drug, Date createdAt) {
        this.patient = patient;
        this.drug = drug;
        this.createdAt = createdAt;
    }
}
