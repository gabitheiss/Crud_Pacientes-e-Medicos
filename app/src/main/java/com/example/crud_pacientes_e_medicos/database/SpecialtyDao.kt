package com.example.crud_pacientes_e_medicos.database

import androidx.room.*
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.Specialty

@Dao
interface SpecialtyDao {

    @Transaction
    @Query("SELECT * FROM Specialty")
    fun getSpecialty() : List<Specialty>

    @Insert
    fun insert(specialty: Specialty)

    @Delete
    fun delete(specialty: Specialty)

    @Update
    fun update(specialty: Specialty)
}