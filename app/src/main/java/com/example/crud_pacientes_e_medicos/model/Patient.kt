package com.example.crud_pacientes_e_medicos.model

import androidx.room.*


@Entity
data class Patient(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "patient_id")
    var id: Int = 0,

    @ColumnInfo(name = "patient_name")
    var name: String,

    @ColumnInfo(name = "patient_gender")
    var patient_gender : String,

    @ColumnInfo(name = "patient_age")
    var age : Int

    )

