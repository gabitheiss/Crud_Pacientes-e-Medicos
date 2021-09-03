package com.example.crud_pacientes_e_medicos.hilt

import android.content.Context
import com.example.crud_pacientes_e_medicos.database.AppDatabase
import com.example.crud_pacientes_e_medicos.database.DoctorDao
import com.example.crud_pacientes_e_medicos.database.PatientDao
import com.example.crud_pacientes_e_medicos.database.SpecialtyDao
import com.example.crud_pacientes_e_medicos.repository.DoctorRepository
import com.example.crud_pacientes_e_medicos.repository.PatientRepository
import com.example.crud_pacientes_e_medicos.repository.SpecialtyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun providePatientDao(@ApplicationContext context: Context): PatientDao {
        return AppDatabase.getDatabase(context).patientDao()
    }
    @Provides
    fun provideDoctorDao(@ApplicationContext context: Context): DoctorDao {
        return AppDatabase.getDatabase(context).doctorDao()
    }


    @Provides
    fun doctorRepository(doctorDao: DoctorDao): DoctorRepository = DoctorRepository(doctorDao)

    @Provides
    fun patientRepository(patientDao: PatientDao): PatientRepository = PatientRepository(patientDao)

    @Provides
    fun specialtyRepository(specialtyDao: SpecialtyDao): SpecialtyRepository = SpecialtyRepository(specialtyDao)
}