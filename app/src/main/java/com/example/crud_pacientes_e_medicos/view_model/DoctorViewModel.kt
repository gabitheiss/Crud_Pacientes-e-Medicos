package com.example.crud_pacientes_e_medicos.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.DoctorWithSpecialty
import com.example.crud_pacientes_e_medicos.model.Specialty
import com.example.crud_pacientes_e_medicos.repository.DoctorRepository
import com.example.crud_pacientes_e_medicos.repository.SpecialtyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DoctorViewModel @Inject constructor(private val doctorRepository: DoctorRepository,
                                          private val specialtyRepository: SpecialtyRepository) : ViewModel() {

    private val _doctor = MutableLiveData<List<DoctorWithSpecialty>>()
    val doctor: LiveData<List<DoctorWithSpecialty>> = _doctor

    private val _specialty = MutableLiveData<List<Specialty>>()
    val specialty : LiveData<List<Specialty>> = _specialty

    fun getDoctor() {
        _doctor.value = doctorRepository.getDoctors()
    }

    fun insert(doctor: Doctor) {
        doctorRepository.insert(doctor)
        getDoctor()
    }

    fun delete(doctor: Doctor){
        doctorRepository.delete(doctor)
        getDoctor()
    }

    fun update(doctor: Doctor){
        doctorRepository.update(doctor)
        getDoctor()
    }

    fun getSpecialty() {
        _specialty.value = specialtyRepository.getSpecialty()
    }

}