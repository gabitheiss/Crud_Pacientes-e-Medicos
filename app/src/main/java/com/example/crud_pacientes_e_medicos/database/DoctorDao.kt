package com.example.crud_pacientes_e_medicos.database

import androidx.room.*
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.DoctorWithSpecialty


@Dao
interface DoctorDao {

    @Transaction
    @Query("SELECT * from Doctor")
    fun getDoctor() : List<DoctorWithSpecialty>

    @Insert
    fun insert(doctor: Doctor)

    @Delete
    fun delete(doctor: Doctor)

    @Update
    fun update(doctor: Doctor)
}