package com.example.crud_pacientes_e_medicos.repository


import com.example.crud_pacientes_e_medicos.database.SpecialtyDao

import com.example.crud_pacientes_e_medicos.model.Specialty
import javax.inject.Inject

class SpecialtyRepository @Inject constructor(private val specialtyDao: SpecialtyDao) {

    fun getSpecialty(): List<Specialty> {
        return specialtyDao.getSpecialty()
    }

    fun insert(specialty: Specialty) {
        return specialtyDao.insert(arrayListOf(specialty))
    }

    fun delete(specialty: Specialty) {
        return specialtyDao.delete(specialty)
    }

    fun update(specialty: Specialty) {
        return specialtyDao.update(specialty)
    }

}