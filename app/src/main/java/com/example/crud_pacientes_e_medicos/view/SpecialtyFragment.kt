package com.example.crud_pacientes_e_medicos.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_pacientes_e_medicos.R
import com.example.crud_pacientes_e_medicos.adapter.PatientAdapter
import com.example.crud_pacientes_e_medicos.adapter.SpecialtyAdapter
import com.example.crud_pacientes_e_medicos.databinding.MainFragmentBinding
import com.example.crud_pacientes_e_medicos.databinding.SpecialtyFragmentBinding
import com.example.crud_pacientes_e_medicos.model.Patient
import com.example.crud_pacientes_e_medicos.model.Specialty
import com.example.crud_pacientes_e_medicos.view_model.MainViewModel
import com.example.crud_pacientes_e_medicos.view_model.SpecialtyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpecialtyFragment : Fragment(R.layout.specialty_fragment) {

    companion object {
        fun newInstance() = SpecialtyFragment()
    }

    private lateinit var viewModel: SpecialtyViewModel

    private lateinit var binding: SpecialtyFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private var selectedPatient: Specialty? = null

    private val specialtyAdapter = SpecialtyAdapter(){
        selectedPatient = it
    }
    private val observerPatient = Observer<List<Specialty>>{
        specialtyAdapter.update(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SpecialtyFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(SpecialtyViewModel::class.java)
    }
}