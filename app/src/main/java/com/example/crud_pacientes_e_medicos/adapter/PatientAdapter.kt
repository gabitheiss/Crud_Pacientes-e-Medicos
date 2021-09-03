package com.example.crud_pacientes_e_medicos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_pacientes_e_medicos.R
import com.example.crud_pacientes_e_medicos.databinding.ItensPatientsBinding
import com.example.crud_pacientes_e_medicos.model.Patient

class PatientAdapter(val onClick: (Patient)->Unit) : RecyclerView.Adapter<PatientViewHolder>(){


    private var listOfPatients = mutableListOf<Patient>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.itens_patients,parent, false).let {
                PatientViewHolder(it, onClick)
            }
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        listOfPatients[position].let {
            holder.bind(it)
        }

    }

    override fun getItemCount(): Int = listOfPatients.size


    fun update(newList: List<Patient>){
        listOfPatients = mutableListOf()
        listOfPatients.addAll(newList)
        notifyDataSetChanged()
    }
}


class PatientViewHolder(itemView: View, val onClick: (Patient) -> Unit ) : RecyclerView.ViewHolder(itemView){

    private val binding = ItensPatientsBinding.bind(itemView)

    fun bind(patient: Patient){
        binding.idName.text = patient.name
        itemView.setOnClickListener{ onClick(patient) }
    }

}