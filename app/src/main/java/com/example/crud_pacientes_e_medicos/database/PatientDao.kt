package com.example.crud_pacientes_e_medicos.database

import androidx.room.*
import androidx.room.OnConflictStrategy.ABORT
import androidx.room.OnConflictStrategy.REPLACE
import com.example.crud_pacientes_e_medicos.model.Patient

@Dao
interface PatientDao {

    @Transaction
    @Query ("SELECT * from Patient order by patient_name ")
    fun getPatients() : List<Patient>

    @Insert(onConflict = REPLACE)
    fun insert(list: List<Patient>)

    @Delete
    fun delete(patient: Patient)

    @Update(onConflict = REPLACE)
    fun update(patient: Patient)
}