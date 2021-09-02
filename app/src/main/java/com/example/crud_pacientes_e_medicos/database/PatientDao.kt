package com.example.crud_pacientes_e_medicos.database

import androidx.room.*
import com.example.crud_pacientes_e_medicos.model.Patient

@Dao
interface PatientDao {

    @Query ("SELECT * from Patient")
    fun getPatients() : List<Patient>

    @Insert
    fun insert(patient: Patient)

    @Delete
    fun delete(patient: Patient)

    @Update
    fun update(patient: Patient)
}