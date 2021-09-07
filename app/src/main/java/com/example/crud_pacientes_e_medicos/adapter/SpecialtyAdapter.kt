package com.example.crud_pacientes_e_medicos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_pacientes_e_medicos.R
import com.example.crud_pacientes_e_medicos.databinding.ItensSpecialtyBinding
import com.example.crud_pacientes_e_medicos.model.Patient
import com.example.crud_pacientes_e_medicos.model.Specialty


class SpecialtyAdapter(val onClick: (Specialty)->Unit) : RecyclerView.Adapter<SpecialtyViewHolder>() {

    private var listOfSpecialties = mutableListOf<Specialty>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtyViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.itens_specialty,parent, false).let {
                SpecialtyViewHolder(it)
            }
    }

    override fun onBindViewHolder(holder: SpecialtyViewHolder, position: Int) {
        listOfSpecialties[position].apply {
            holder.bind(this)
            holder.itemView.setOnClickListener{
                onClick(this)
            }
        }
    }

    override fun getItemCount(): Int  = listOfSpecialties.size

    fun update(newList: List<Specialty>){
        listOfSpecialties = mutableListOf()
        listOfSpecialties.addAll(newList)
        notifyDataSetChanged()
    }
}


class SpecialtyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


    private val binding = ItensSpecialtyBinding.bind(itemView)

    fun bind(specialty: Specialty){
        binding.idNameSpecialty.text = specialty.nameSpecialty

    }

}