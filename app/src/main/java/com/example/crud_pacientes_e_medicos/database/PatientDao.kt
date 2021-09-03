package com.example.crud_pacientes_e_medicos.database

import androidx.room.*
import com.example.crud_pacientes_e_medicos.model.Patient
import com.example.crud_pacientes_e_medicos.model.PatientWithDoctor

@Dao
interface PatientDao {

    @Transaction
    @Query ("SELECT * from Patient")
    fun getPatients() : List<PatientWithDoctor>

    @Insert
    fun insert(patient: Patient)

    @Delete
    fun delete(patient: Patient)

    @Update
    fun update(patient: Patient)
}