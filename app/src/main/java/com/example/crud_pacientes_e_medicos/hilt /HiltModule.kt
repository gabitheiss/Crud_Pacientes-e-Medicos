package com.example.crud_pacientes_e_medicos.hilt

import android.content.Context
import com.example.crud_pacientes_e_medicos.database.AppDatabase
import com.example.crud_pacientes_e_medicos.database.DoctorDao
import com.example.crud_pacientes_e_medicos.database.PatientDao
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

}