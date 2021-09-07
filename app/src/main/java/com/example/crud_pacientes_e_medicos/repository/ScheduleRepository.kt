package com.example.crud_pacientes_e_medicos.repository

import com.example.crud_pacientes_e_medicos.database.SchedulesDao
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.Schedule
import com.example.crud_pacientes_e_medicos.model.SchedulePatientsWithDoctors
import javax.inject.Inject

class ScheduleRepository@Inject constructor(private val schedulesDao: SchedulesDao) {


    fun getSchedules(): List<SchedulePatientsWithDoctors> {
        return schedulesDao.getSchedules()
    }

    fun insert(schedule: Schedule) {
        return schedulesDao.insert(schedule)
    }

    fun delete(schedule: Schedule) {
        return schedulesDao.delete(schedule)
    }

    fun update(schedule: Schedule) {
        return schedulesDao.update(schedule)
    }
}