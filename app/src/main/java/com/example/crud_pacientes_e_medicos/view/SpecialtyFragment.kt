package com.example.crud_pacientes_e_medicos.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.crud_pacientes_e_medicos.R
import com.example.crud_pacientes_e_medicos.view_model.SpecialtyViewModel

class SpecialtyFragment : Fragment(R.layout.specialty_fragment) {

    companion object {
        fun newInstance() = SpecialtyFragment()
    }

    private lateinit var viewModel: SpecialtyViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpecialtyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}