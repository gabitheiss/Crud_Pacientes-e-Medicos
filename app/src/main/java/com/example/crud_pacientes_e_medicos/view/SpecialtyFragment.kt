package com.example.crud_pacientes_e_medicos.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_pacientes_e_medicos.R
import com.example.crud_pacientes_e_medicos.adapter.SpecialtyAdapter
import com.example.crud_pacientes_e_medicos.databinding.SpecialtyFragmentBinding
import com.example.crud_pacientes_e_medicos.model.Patient
import com.example.crud_pacientes_e_medicos.model.Specialty
import com.example.crud_pacientes_e_medicos.view_model.SpecialtyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpecialtyFragment : Fragment(R.layout.specialty_fragment) {

    companion object {
        fun newInstance() = SpecialtyFragment()
    }

    private lateinit var viewModel: SpecialtyViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: SpecialtyFragmentBinding
    private var selectedSpecialty: Specialty? = null

    private val specialtyAdapter = SpecialtyAdapter(){
        selectedSpecialty = it
        valueToFields(it)
    }

    private fun valueToFields(specialty: Specialty) {
        binding.idNameSpecialty?.setText(specialty.nameSpecialty)

    }

    private val observerSpecialty = Observer<List<Specialty>>{
        specialtyAdapter.update(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SpecialtyFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(SpecialtyViewModel::class.java)
        viewModel.specialty.observe(viewLifecycleOwner,observerSpecialty)
        viewModel.getSpecialty()

        recyclerView = binding.recyclerViewListSpecialty
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = specialtyAdapter

        binding.buttonNew.setOnClickListener {
            val name = binding.idNameSpecialty.text.toString()
            if (name.isNotEmpty()) {
                viewModel.insertSpecialty(
                    Specialty(
                        nameSpecialty = name
                    )
                )
                clearFields()
            }
        }
        binding.buttonDelete.setOnClickListener {
            selectedSpecialty?.let {
                viewModel.deleteSpecialty(it)
                clearFields()
            }
        }
        binding.buttonEdit.setOnClickListener {
            selectedSpecialty?.let {
                val name = binding.idNameSpecialty
                if (name.editableText.isNotEmpty()) {
                    viewModel.updateSpecialty(
                        Specialty(
                            nameSpecialty = name.text.toString(),
                            idSpecialty = selectedSpecialty!!.idSpecialty
                        )
                    )
                    clearFields()
                }
            }
        }
    }

    private fun clearFields() {
        binding.idNameSpecialty?.setText("")

    }
}