package com.example.crud_pacientes_e_medicos.model

import androidx.room.*

@Entity
data class Doctor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "doctor_id")
    var idDoctor: Int,

    @ColumnInfo(name = "doctor_name")
    var nameDoctor: String,

    val doctorFk: Int

)

data class Specialty(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "specialty_id")
    var idSpecialty: Int,

    @ColumnInfo(name = "specialty_id")
    var nameSpecialty: String,

)


data class DoctorWithSpecialty(
    @Embedded
    val doctor : Doctor,
    @Relation(
        parentColumn = "doctorFk",
        entityColumn = "specialty_id"
    )
    val specialty: Specialty
)

