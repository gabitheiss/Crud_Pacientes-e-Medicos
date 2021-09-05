package com.example.crud_pacientes_e_medicos.view


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_pacientes_e_medicos.R
import com.example.crud_pacientes_e_medicos.adapter.DoctorAdapter
import com.example.crud_pacientes_e_medicos.databinding.FragmentDoctorBinding
import com.example.crud_pacientes_e_medicos.databinding.MainFragmentBinding
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.Patient
import com.example.crud_pacientes_e_medicos.view_model.DoctorViewModel
import com.example.crud_pacientes_e_medicos.view_model.MainViewModel


class DoctorFragment : Fragment(R.layout.fragment_doctor) {

    companion object {
        fun newInstance() = DoctorFragment()
    }

    private lateinit var viewModel: DoctorViewModel
    private lateinit var binding: FragmentDoctorBinding
    private lateinit var recyclerView: RecyclerView
    private var selectedDoctor: Doctor? = null

    private val adapterDoctor = DoctorAdapter{
        selectedDoctor = it
    }

    private val observerPatient = Observer<List<Patient>>{
        adapterDoctor.update(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDoctorBinding.bind(view)
        viewModel = ViewModelProvider(this).get(DoctorViewModel::class.java)
    }

}
