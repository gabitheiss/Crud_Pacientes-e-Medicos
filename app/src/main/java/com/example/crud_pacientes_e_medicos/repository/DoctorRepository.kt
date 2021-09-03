package com.example.crud_pacientes_e_medicos.repository

import com.example.crud_pacientes_e_medicos.database.DoctorDao
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.DoctorWithSpecialty
import javax.inject.Inject

class DoctorRepository @Inject constructor (private val doctorDao: DoctorDao){

    fun getDoctors(): List<DoctorWithSpecialty> {
        return doctorDao.getDoctor()
    }

    fun insert(doctor: Doctor) {
        return doctorDao.insert(doctor)
    }

    fun delete(doctor: Doctor) {
        return doctorDao.delete(doctor)
    }

    fun update(doctor: Doctor) {
        return doctorDao.update(doctor)
    }
}