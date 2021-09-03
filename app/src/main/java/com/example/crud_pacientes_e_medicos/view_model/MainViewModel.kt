package com.example.crud_pacientes_e_medicos.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.Patient
import com.example.crud_pacientes_e_medicos.repository.DoctorRepository
import com.example.crud_pacientes_e_medicos.repository.PatientRepository
import javax.inject.Inject


class MainViewModel @Inject constructor(private val patientRepository: PatientRepository,
                                        private val doctorRepository: DoctorRepository) : ViewModel() {

    private val _patients = MutableLiveData<List<Patient>>()
    val patients: LiveData<List<Patient>> = _patients

    private val _doctor = MutableLiveData<List<Doctor>>()
    val doctor: LiveData<List<Doctor>> = _doctor


}