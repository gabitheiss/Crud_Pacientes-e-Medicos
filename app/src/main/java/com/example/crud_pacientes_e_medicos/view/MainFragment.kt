package com.example.crud_pacientes_e_medicos.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_pacientes_e_medicos.R
import com.example.crud_pacientes_e_medicos.adapter.PatientAdapter
import com.example.crud_pacientes_e_medicos.databinding.MainActivityBinding
import com.example.crud_pacientes_e_medicos.databinding.MainFragmentBinding
import com.example.crud_pacientes_e_medicos.model.Patient
import com.example.crud_pacientes_e_medicos.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private var selectedPatient: Patient? = null

    private val adapterPatient = PatientAdapter(){
        selectedPatient = it
    }

    private val observerPatient = Observer<List<Patient>>{
        adapterPatient.update(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recyclerView = binding.recyclerViewListPatients
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapterPatient

        viewModel.patients.observe(viewLifecycleOwner,observerPatient)
        viewModel.getPatient()

        binding.buttonNew.setOnClickListener {
            val name = binding.idNamePatient.text
            val gender = binding.idGender.text
            val age = binding.idAge.text

            //veriificar se nao esta nulo
            if(name.toString().isNotEmpty()&& gender.toString().isNotEmpty() && age.toString().isNotEmpty()){
                viewModel.insertPatient(Patient(name = name.toString(), patient_gender = gender.toString(), age = age.toString()))
            }
        }
        binding.buttonDelete.setOnClickListener {
            selectedPatient?.let {
                viewModel.deletePatient(it)
            }
        }

        binding.buttonEdit.setOnClickListener {
            selectedPatient?.let {
                val name = binding.idNamePatient.text
                val age = binding.idAge.text
                val gender = binding.idGender.text

                if (name.isNotEmpty() && age.isNotEmpty() && gender != null) {
                    viewModel.updatePatient( Patient(
                        name = name.toString(),
                        age = age.toString(),
                        patient_gender = gender.toString())
                    )
                }
            }
        }
    }

}