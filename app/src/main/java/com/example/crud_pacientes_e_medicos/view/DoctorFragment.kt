package com.example.crud_pacientes_e_medicos.view


import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_pacientes_e_medicos.R
import com.example.crud_pacientes_e_medicos.adapter.DoctorAdapter
import com.example.crud_pacientes_e_medicos.databinding.FragmentDoctorBinding
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.DoctorWithSpecialty
import com.example.crud_pacientes_e_medicos.model.Patient
import com.example.crud_pacientes_e_medicos.model.Specialty
import com.example.crud_pacientes_e_medicos.view_model.DoctorViewModel
import com.example.crud_pacientes_e_medicos.view_model.SpecialtyViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class DoctorFragment : Fragment(R.layout.fragment_doctor) {

    companion object {
        fun newInstance() = DoctorFragment()
    }

    private lateinit var viewModel: DoctorViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentDoctorBinding
    private lateinit var arrayAdapter : ArrayAdapter<String>
    private var specialtyArray: List<Specialty> = listOf()
    private var objectSpecialty: Specialty? = null
    private var selectedDoctor: Doctor? = null

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
        completeArrayAdapter(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDoctorBinding.bind(view)
        viewModel = ViewModelProvider(this).get(DoctorViewModel::class.java)


        recyclerView = binding.recyclerViewListDoctors
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapterDoctor


        viewModel.doctor.observe(viewLifecycleOwner,observerDoctor)
        viewModel.getDoctor()
        viewModel.specialty.observe(viewLifecycleOwner,observerSpecialty)
        viewModel.getSpecialty()


        binding.buttonNew.setOnClickListener {
            val name = binding.idNameDotor?.text
            if(name.isNotEmpty() && objectSpecialty != null){
                viewModel.insert(Doctor(nameDoctor = name.toString(), specialtyFk = objectSpecialty?.idSpecialty!!))
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
            if(name.isNotEmpty() && objectSpecialty != null){
                viewModel.update(Doctor(nameDoctor = name.toString(), specialtyFk = objectSpecialty?.idSpecialty!!))
                clearFields()
            }
        }

    }
    fun clearFields() {
        binding.idNameDotor?.setText("")
        binding.idSpecialty?.setText("")
    }

    private fun completeArrayAdapter(list: List<Specialty>) {
        val listAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, list)
        var insertList = binding.idSpecialty as AutoCompleteTextView
        insertList.setAdapter(listAdapter)

        binding.idSpecialty.setOnItemClickListener { adapterView, view, i, l ->
            objectSpecialty = adapterView.getItemAtPosition(i) as Specialty
        }

    }

}
