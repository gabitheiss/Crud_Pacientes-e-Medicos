package com.example.crud_pacientes_e_medicos.repository

import com.example.crud_pacientes_e_medicos.database.AppDatabase
import com.example.crud_pacientes_e_medicos.database.PatientDao

class PatientRepository {

    private val dao : PatientDao = AppDatabase.getDatabase().patientDao()

}