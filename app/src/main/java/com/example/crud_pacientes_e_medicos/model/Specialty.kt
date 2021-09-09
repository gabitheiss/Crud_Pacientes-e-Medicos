package com.example.crud_pacientes_e_medicos.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Specialty(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "specialty_id")
    var idSpecialty: Int = 0,

    @ColumnInfo(name = "specialty_name")
    var nameSpecialty: String,

){
    override fun toString(): String {
        return nameSpecialty
    }
}
