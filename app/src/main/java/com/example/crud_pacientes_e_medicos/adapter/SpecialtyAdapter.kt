package com.example.crud_pacientes_e_medicos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_pacientes_e_medicos.R
import com.example.crud_pacientes_e_medicos.databinding.ItensSpecialtyBinding
import com.example.crud_pacientes_e_medicos.model.Specialty


class SpecialtyAdapter(val onClick: (Specialty)->Unit) : RecyclerView.Adapter<SpecialtyViewHolder>() {

    private var listOfSpecialties = mutableListOf<Specialty>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtyViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.itens_specialty,parent, false).let {
                SpecialtyViewHolder(it, onClick)
            }
    }

    override fun onBindViewHolder(holder: SpecialtyViewHolder, position: Int) {
        listOfSpecialties[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int  = listOfSpecialties.size
}


class SpecialtyViewHolder(itemView: View, val onClick: (Specialty) -> Unit ) : RecyclerView.ViewHolder(itemView){


    private val binding = ItensSpecialtyBinding.bind(itemView)

    fun bind(specialty: Specialty){
        binding.idNameSpecialty.text = specialty.nameSpecialty
        itemView.setOnClickListener{ onClick(specialty) }
    }

}