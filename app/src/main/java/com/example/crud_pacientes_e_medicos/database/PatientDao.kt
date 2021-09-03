package com.example.crud_pacientes_e_medicos.database

import androidx.room.*
import androidx.room.OnConflictStrategy.ABORT
import androidx.room.OnConflictStrategy.REPLACE
import com.example.crud_pacientes_e_medicos.model.Patient

@Dao
interface PatientDao {

    @Transaction
    @Query ("SELECT * from Patient")
    fun getPatients() : List<Patient>

    @Insert(onConflict = ABORT)
    fun insert(patient: Patient)

    @Delete
    fun delete(patient: Patient)

    @Update
    fun update(patient: Patient)
}