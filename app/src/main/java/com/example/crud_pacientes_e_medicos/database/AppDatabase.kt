package com.example.crud_pacientes_e_medicos.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.Patient
import com.example.crud_pacientes_e_medicos.model.Schedule
import com.example.crud_pacientes_e_medicos.model.Specialty


@Database(
    entities = [Patient::class, Doctor::class, Schedule::class, Specialty::class],

    version = 1
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun patientDao() : PatientDao
    abstract fun doctorDao() : DoctorDao

    companion object{


        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context,AppDatabase::class.java, "crud")
                .allowMainThreadQueries()
                .build()
        }
    }
}