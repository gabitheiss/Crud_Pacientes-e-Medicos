package com.example.crud_pacientes_e_medicos.view


import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crud_pacientes_e_medicos.R
import com.example.crud_pacientes_e_medicos.adapter.DoctorAdapter
import com.example.crud_pacientes_e_medicos.databinding.FragmentDoctorBinding
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.DoctorWithSpecialty
import com.example.crud_pacientes_e_medicos.model.Patient
import com.example.crud_pacientes_e_medicos.model.Specialty
import com.example.crud_pacientes_e_medicos.view_model.DoctorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoctorFragment : Fragment(R.layout.fragment_doctor) {

    companion object {
        fun newInstance() = DoctorFragment()
    }

    private lateinit var viewModel: DoctorViewModel
    private lateinit var binding: FragmentDoctorBinding
    private lateinit var arrayAdapter : ArrayAdapter<String>

    private var selectedDoctor: Doctor? = null
    private var selectedSpecialty: Specialty? = null

    private val adapterDoctor = DoctorAdapter{
        valueToFields(it)
    }
    private fun valueToFields(doctorWithSpecialty: DoctorWithSpecialty) {
        binding.idNameDotor?.setText(doctorWithSpecialty.doctor?.nameDoctor)

    }

    private val observerDoctor = Observer<List<DoctorWithSpecialty>>{
        adapterDoctor.update(it)
    }

    private val observerSpecialty = Observer<List<Specialty>>{
        val listSpecialty = it.map {specialty ->
            specialty.nameSpecialty
        }
        arrayAdapter.addAll(listSpecialty)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDoctorBinding.bind(view)
        viewModel = ViewModelProvider(this).get(DoctorViewModel::class.java)

        completeArrayAdapter()

       var recyclerView = binding.recyclerViewListDoctors
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapterDoctor


        viewModel.doctor.observe(viewLifecycleOwner,observerDoctor)
        viewModel.getDoctor()
        viewModel.specialty.observe(viewLifecycleOwner,observerSpecialty)
        viewModel.getSpecialty()



        binding.buttonNew.setOnClickListener {
            val name = binding.idNameDotor?.text.toString()
            if(name.isNotEmpty() && selectedSpecialty != null){
                viewModel.insert(Doctor(nameDoctor = name.toString(), specialtyFk = selectedSpecialty!!.idSpecialty))
                clearFields()
            }
        }

        binding.buttonDelete.setOnClickListener {
            selectedDoctor?.let {
                viewModel.delete(it)
                clearFields()
            }
        }
        binding.buttonEdit.setOnClickListener {
            val name = binding.idNameDotor.text
            if(name.isNotEmpty() && selectedSpecialty != null){
                viewModel.update(Doctor(nameDoctor = name.toString(), specialtyFk = selectedSpecialty!!.idSpecialty))
                clearFields()
            }
        }

    }
    fun clearFields() {
        binding.idNameDotor?.setText("")
        binding.idSpecialist?.setText("")
        selectedSpecialty = null
        selectedDoctor = null
    }

    private fun completeArrayAdapter() {
        arrayAdapter =
            ArrayAdapter<String>(requireContext(), R.layout.itens_list_specialty)
        val autoCompleteBrand: AutoCompleteTextView? =
            binding.idSpecialist.text as? AutoCompleteTextView
        autoCompleteBrand?.setAdapter(arrayAdapter)
        autoCompleteBrand?.setOnItemClickListener { parent, view, position, id ->
            val selected = parent.getItemAtPosition(position) as String
            viewModel.specialty.value?.first { specialty -> (specialty.nameSpecialty.equals(selected, true)) }
                ?.let {
                    selectedSpecialty = it
                }
        }
    }

}
