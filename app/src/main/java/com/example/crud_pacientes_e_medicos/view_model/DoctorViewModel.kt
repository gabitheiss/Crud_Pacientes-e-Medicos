package com.example.crud_pacientes_e_medicos.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.DoctorWithSpecialty
import com.example.crud_pacientes_e_medicos.model.Specialty
import com.example.crud_pacientes_e_medicos.repository.DoctorRepository
import javax.inject.Inject

class DoctorViewModel @Inject constructor(private val doctorRepository: DoctorRepository) : ViewModel() {

    private val _doctor = MutableLiveData<List<DoctorWithSpecialty>>()
    val doctor: LiveData<List<DoctorWithSpecialty>> = _doctor

    private val _specialty = MutableLiveData<List<Specialty>>()
    val specialty : LiveData<List<Specialty>> = _specialty

    fun getDoctor() {
        _doctor.value = doctorRepository.getDoctors()
    }

    fun insertDoctor(doctor: Doctor) {
        doctorRepository.insert(doctor)
        getDoctor()
    }

    fun deleteDoctor(doctor: Doctor){
        doctorRepository.delete(doctor)
        getDoctor()
    }

    fun updateDoctor(doctor: Doctor){
        doctorRepository.update(doctor)
        getDoctor()
    }

}