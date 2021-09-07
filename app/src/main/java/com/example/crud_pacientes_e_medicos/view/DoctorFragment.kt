package com.example.crud_pacientes_e_medicos.view


import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_pacientes_e_medicos.R
import com.example.crud_pacientes_e_medicos.adapter.DoctorAdapter
import com.example.crud_pacientes_e_medicos.databinding.FragmentDoctorBinding
import com.example.crud_pacientes_e_medicos.databinding.MainFragmentBinding
import com.example.crud_pacientes_e_medicos.model.Doctor
import com.example.crud_pacientes_e_medicos.model.DoctorWithSpecialty
import com.example.crud_pacientes_e_medicos.model.Patient
import com.example.crud_pacientes_e_medicos.model.Specialty
import com.example.crud_pacientes_e_medicos.view_model.DoctorViewModel
import com.example.crud_pacientes_e_medicos.view_model.MainViewModel
import com.example.crud_pacientes_e_medicos.view_model.SpecialtyViewModel
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

       var recyclerView = binding.recyclerViewListDoctors
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapterDoctor


        viewModel.doctor.observe(viewLifecycleOwner,observerDoctor)
        viewModel.getDoctor()



        binding.buttonNew.setOnClickListener {
            val name = binding.idNameDotor.text
            if(name.isNotEmpty() && selectedSpecialty != null){
                viewModel.insertDoctor(Doctor(nameDoctor = name.toString(), specialtyFk = selectedSpecialty!!.idSpecialty))
            }
        }

        binding.buttonDelete.setOnClickListener {
            selectedDoctor?.let {
                viewModel.deleteDoctor(it)
            }
        }
        binding.buttonEdit.setOnClickListener {
            val name = binding.idNameDotor.text

            if(name.isNotEmpty() && selectedSpecialty != null){
                viewModel.updateDoctor(Doctor(nameDoctor = name.toString(), specialtyFk = selectedSpecialty!!.idSpecialty))
            }
        }

//        fun valueFields(doctorWithSpecialty: DoctorWithSpecialty) {
//            binding.idNameDotor.editText?.setText(doctorWithSpecialty.doctor?.nameDoctor)
//            binding.buttonNew.visibility = View.GONE
//
//            selectedDoctor = doctorWithSpecialty
//            selectedSpecialty = doctorWithSpecialty.specialty
//       }
    }

}
