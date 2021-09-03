package com.example.crud_pacientes_e_medicos.repository

import com.example.crud_pacientes_e_medicos.database.AppDatabase
import com.example.crud_pacientes_e_medicos.database.PatientDao
import com.example.crud_pacientes_e_medicos.model.Patient
import com.example.crud_pacientes_e_medicos.model.PatientWithDoctor
import javax.inject.Inject

class PatientRepository @Inject constructor(private val patientDao: PatientDao) {



    fun getProducts(): List<PatientWithDoctor> {
        return patientDao.getPatients()
    }

    fun insert(patient: Patient) {
        return patientDao.insert(patient)
    }

    fun delete(patient: Patient) {
        return patientDao.delete(patient)
    }

    fun update(patient: Patient) {
        return patientDao.update(patient)
    }

}