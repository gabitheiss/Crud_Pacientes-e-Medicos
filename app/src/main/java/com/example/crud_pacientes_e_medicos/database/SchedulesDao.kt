package com.example.crud_pacientes_e_medicos.database

import androidx.room.*
import androidx.room.OnConflictStrategy.ABORT
import com.example.crud_pacientes_e_medicos.model.Schedule
import com.example.crud_pacientes_e_medicos.model.SchedulePatientsWithDoctors

@Dao
interface SchedulesDao {

    @Transaction
    @Query("Select * from Schedule")
    fun getSchedules(): List<SchedulePatientsWithDoctors>

    @Transaction
    @Query("Select * from Schedule where schedule_id = :idSchedule")
    fun fetch(idSchedule: Int): SchedulePatientsWithDoctors

    @Transaction
    @Query("Select * from Schedule inner join Doctor on doctor.doctor_id = doctorFK where doctor.doctor_name like '%' || :nameDoctor || '%'")
    fun fetchDoctor(nameDoctor: String): List<SchedulePatientsWithDoctors>

    @Transaction
    @Query("Select * from Schedule inner join Doctor on doctor.doctor_id = doctorFK where doctor.specialtyFk in (:idSpecialty)")
    fun fetchDoctorSpecialty(idSpecialty: List<Int>): List<SchedulePatientsWithDoctors>

    @Transaction
    @Query("Select * from Schedule inner join Patient on patient.patient_id = patientFK where patient_gender = :patient_gender")
    fun fetchGender(patient_gender: String): List<SchedulePatientsWithDoctors>

    @Insert(onConflict = ABORT)
    fun insert(schedule: Schedule)


    @Update
    fun update(schedule: Schedule)

    @Delete
    fun delete(schedule: Schedule)


}