package com.example.crud_pacientes_e_medicos.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crud_pacientes_e_medicos.model.Specialty
import com.example.crud_pacientes_e_medicos.repository.SpecialtyRepository
import javax.inject.Inject

class SpecialtyViewModel @Inject constructor(private val specialtyRepository: SpecialtyRepository) : ViewModel(){


    private val _specialty = MutableLiveData<List<Specialty>>()
    val specialty: LiveData<List<Specialty>> = _specialty

    fun getDoctor() {
        _specialty.value = specialtyRepository.getSpecialty()
    }

    fun insertSpecialty(specialty: Specialty) {
        specialtyRepository.insert(specialty)
        getDoctor()
    }

    fun deleteSpecialty(specialty: Specialty){
        specialtyRepository.delete(specialty)
        getDoctor()
    }

    fun updateSpecialty(specialty: Specialty){
        specialtyRepository.update(specialty)
        getDoctor()
    }

}