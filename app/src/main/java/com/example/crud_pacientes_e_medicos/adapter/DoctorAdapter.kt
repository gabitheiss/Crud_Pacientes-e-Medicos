package com.example.crud_pacientes_e_medicos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_pacientes_e_medicos.R
import com.example.crud_pacientes_e_medicos.databinding.ItensDoctorsBinding
import com.example.crud_pacientes_e_medicos.model.DoctorWithSpecialty


class DoctorAdapter(val onClick: (DoctorWithSpecialty) -> Unit) : RecyclerView.Adapter<DoctorViewHolder>() {

    private var listOfDoctorsAndSpecialty = mutableListOf<DoctorWithSpecialty>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.itens_doctors, parent, false).let {
                DoctorViewHolder(it)
            }
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        listOfDoctorsAndSpecialty[position].apply {
            holder.bind(this)
            holder.itemView.setOnClickListener{
                onClick(this)
            }
        }
    }

    override fun getItemCount(): Int = listOfDoctorsAndSpecialty.size

    fun update(list: List<DoctorWithSpecialty>) {
        listOfDoctorsAndSpecialty = mutableListOf()
        listOfDoctorsAndSpecialty.addAll(list)
        notifyDataSetChanged()
    }
}


class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItensDoctorsBinding.bind(itemView)

    fun bind(doctorWithSpecialty: DoctorWithSpecialty) {
        binding.idNameDoctor.text = doctorWithSpecialty.doctor?.nameDoctor
        binding.idSpecialtyDoctor.text = doctorWithSpecialty.specialty?.nameSpecialty
    }
}