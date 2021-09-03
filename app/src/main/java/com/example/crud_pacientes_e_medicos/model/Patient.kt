package com.example.crud_pacientes_e_medicos.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation


@Entity
data class Patient(

    @ColumnInfo(name = "patient_id")
    var id: String,

    @ColumnInfo(name = "patient_name")
    var name: String,

    @ColumnInfo(name = "patient_sex")
    var sex : String,

    @ColumnInfo(name = "patient_age")
    var age : String

    )

data class PatientWithDoctor(

    @Embedded
    val patient: Patient,
    @Relation(
        parentColumn = "doctor_fk",
        entityColumn = "doctor_id"
    )
    val doctor: Doctor
)
