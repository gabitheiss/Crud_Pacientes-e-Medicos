package com.example.crud_pacientes_e_medicos.model

import androidx.room.*

@Entity
data class Schedule(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "schedule_id")
    var idSchedule: Int = 0,
    var patientFK : Int,
    var doctorFK: Int
)


data class SchedulePatientsWithDoctors(
    @Embedded
    val schedule: Schedule?,

    @Relation(
        parentColumn = "patientFK",
        entityColumn = "patient_id"
    )
    val patient: Patient?,


    @Relation(
        parentColumn = "doctorFK",
        entityColumn = "doctor_id"
    )
    val doctor: Doctor?

)