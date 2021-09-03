package com.example.crud_pacientes_e_medicos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_pacientes_e_medicos.R
import com.example.crud_pacientes_e_medicos.databinding.ItensDoctorsBinding
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.Patient

class DoctorAdapter(val onClick: (Doctor) -> Unit) : RecyclerView.Adapter<DoctorViewHolder>() {

    private var listOfDoctors = mutableListOf<Doctor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.itens_doctors, parent, false).let {
                DoctorViewHolder(it, onClick)
            }
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        listOfDoctors[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = listOfDoctors.size

    fun update(list: List<Doctor>) {
        listOfDoctors = mutableListOf()
        listOfDoctors.addAll(list)
        notifyDataSetChanged()
    }
}


class DoctorViewHolder(itemView: View, val onClick: (Doctor) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    private val binding = ItensDoctorsBinding.bind(itemView)

    fun bind(doctor: Doctor) {
        binding.idNameDoctor.text = doctor.nameDoctor
        //binding.idSpecialtyDoctor.text = doctor.
    }
}