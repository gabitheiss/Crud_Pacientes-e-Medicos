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

//    @Query ("SELECT * from Patient order by patient_gender")
//    fun fetch(gender: String) : List<Patient>

    @Insert(onConflict = ABORT)
    fun insert(list: List<Patient>)

    @Delete
    fun delete(patient: Patient)

    @Update
    fun update(patient: Patient)
}