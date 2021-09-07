package com.example.crud_pacientes_e_medicos.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.Patient
import com.example.crud_pacientes_e_medicos.repository.DoctorRepository
import com.example.crud_pacientes_e_medicos.repository.PatientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val patientRepository: PatientRepository) : ViewModel() {

    private val _patients = MutableLiveData<List<Patient>>()
    val patients: LiveData<List<Patient>> = _patients


    fun getPatient() {
        _patients.value = patientRepository.getPatients()
    }

    fun insertPatient(patient: Patient) {
        patientRepository.insert(patient)
        getPatient()
    }

    fun deletePatient(patient: Patient){
        patientRepository.delete(patient)
        getPatient()
    }

    fun updatePatient(patient: Patient){
        patientRepository.update(patient)
        getPatient()
    }

}