package com.example.crud_pacientes_e_medicos

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.crud_pacientes_e_medicos.database.AppDatabase
import com.example.crud_pacientes_e_medicos.database.PatientDao
import com.example.crud_pacientes_e_medicos.model.Patient
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class PatientTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: PatientDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.patientDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun testing_insert_patient_returns_true() {
        val newPatient1 = Patient(name = "Teste", age = "30", patient_gender = "M")
        val newPatient2 = Patient(name = "Teste 2", age = "29", patient_gender = "F")
        val newPatient3 = Patient(name = "Teste 3", age = "28", patient_gender = "F")
        val listToInsert = arrayListOf(newPatient1, newPatient2, newPatient3)
        dao.insert(listToInsert)

        val results = dao.getPatients()
        assertThat(results).hasSize(listToInsert.size)
    }

    @Test
    fun testing_update() {
        val newPatient1 = Patient(1, name = "Teste", age = "30", patient_gender = "M")
        val newPatient2 = Patient(2, name = "Teste 2", age = "29", patient_gender = "F")
        val newPatient3 = Patient(3, name = "Teste 3", age = "28", patient_gender = "F")
        val listToInsert = arrayListOf(newPatient1, newPatient2, newPatient3)
        dao.insert(listToInsert)

        val patientForUpdate = Patient(id = newPatient2.id, name = "P2Updated", age = "23", patient_gender = "M")
        val listToInsert1 = arrayListOf(patientForUpdate)
        dao.insert(listToInsert1)


        val result = dao.getPatients()
        assertThat(result).contains(patientForUpdate)

    }

    @Test
    fun testing_delete_return_true() {
        val newPatient1 = Patient(name = "Teste", age = "30", patient_gender = "M")
        val newPatient2 = Patient(name = "Teste 2", age = "29", patient_gender = "F")
        val newPatient3 = Patient(name = "Teste 3", age = "28", patient_gender = "F")
        val listToInsert = arrayListOf(newPatient1, newPatient2, newPatient3)
        dao.insert(listToInsert)

        dao.delete(newPatient1)

        val result = dao.getPatients()
        assertThat(result).doesNotContain(newPatient2)
    }


}