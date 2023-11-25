package com.natalia.ePrescription.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drugs")
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String drugName;

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "side_effects")
    private String sideEffects;

    @OneToMany(mappedBy = "drug")
    private Set<PatientDrug> patientDrugSet;

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", drugName='" + drugName + '\'' +
                ", dosage='" + dosage + '\'' +
                ", sideEffects='" + sideEffects + '\'' +
                '}';
    }
}
