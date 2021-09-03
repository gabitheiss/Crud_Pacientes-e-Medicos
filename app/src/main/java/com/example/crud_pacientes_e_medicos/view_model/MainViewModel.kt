package com.example.crud_pacientes_e_medicos.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.PatientWithDoctor
import com.example.crud_pacientes_e_medicos.repository.PatientRepository

class MainViewModel : ViewModel() {

    private val _patients = MutableLiveData<List<PatientWithDoctor>>()
    val patients: LiveData<List<PatientWithDoctor>> = _patients

    private val _doctor = MutableLiveData<List<Doctor>>()
    val doctor: LiveData<List<Doctor>> = _doctor

    private val patientRepository = PatientRepository()

}