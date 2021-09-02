package com.example.crud_pacientes_e_medicos.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.crud_pacientes_e_medicos.model.Patient


@Database(
    entities = [Patient::class],
    version = 1
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun patientDao() : PatientDao

    companion object{


        fun getDatabase(): AppDatabase {
            return Room.databaseBuilder(
                CRUDApplication.contextCRUDApp!!,
                AppDatabase::class.java,
                "crud_app"
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}