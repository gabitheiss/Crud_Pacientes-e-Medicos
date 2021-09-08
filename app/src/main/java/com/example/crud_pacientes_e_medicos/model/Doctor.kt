package com.example.crud_pacientes_e_medicos.model

import androidx.room.*

@Entity
data class Doctor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "doctor_id")
    var idDoctor: Int = 0,

    @ColumnInfo(name = "doctor_name")
    var nameDoctor: String,

    val specialtyFk: Int

)


data class DoctorWithSpecialty(
    @Embedded
    val doctor: Doctor?,
    @Relation(
        parentColumn = "specialtyFk",
        entityColumn = "specialty_id"
    )
    val specialty: Specialty?
)

