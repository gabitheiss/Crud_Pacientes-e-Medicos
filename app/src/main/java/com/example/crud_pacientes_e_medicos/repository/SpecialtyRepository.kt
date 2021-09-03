package com.example.crud_pacientes_e_medicos.repository

import com.example.crud_pacientes_e_medicos.database.PatientDao
import com.example.crud_pacientes_e_medicos.database.SpecialtyDao
import javax.inject.Inject

class SpecialtyRepository @Inject constructor(private val specialtyDao: SpecialtyDao) {

}