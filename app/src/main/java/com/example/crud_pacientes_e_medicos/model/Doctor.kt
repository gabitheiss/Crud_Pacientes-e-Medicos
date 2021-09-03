package com.example.crud_pacientes_e_medicos.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class Doctor(

    @ColumnInfo(name = "doctor_id")
    var idDoctor: String,

    @ColumnInfo(name = "doctor_name")
    var nameDoctor: String,

)

data class Specialty(

    @ColumnInfo(name = "specialty_id")
    var idSpecialty: String,

    @ColumnInfo(name = "specialty_id")
    var nameSpecialty: String,

)


data class DoctorWithSpecialty(
    @Embedded
    val doctor : Doctor,
    @Relation(
        parentColumn = "doctor_fk",
        entityColumn = "doctor_id"
    )
    val specialty: Specialty
)

