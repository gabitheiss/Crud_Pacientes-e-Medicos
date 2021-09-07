package com.example.crud_pacientes_e_medicos.database

import androidx.room.*
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.Specialty

@Dao
interface SpecialtyDao {


    @Query("SELECT * FROM Specialty")
    fun getSpecialty() : List<Specialty>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(list: List<Specialty>)

    @Delete
    fun delete(specialty: Specialty)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(specialty: Specialty)
}