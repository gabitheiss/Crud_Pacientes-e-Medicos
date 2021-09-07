package com.example.crud_pacientes_e_medicos.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.crud_pacientes_e_medicos.R
import com.example.crud_pacientes_e_medicos.view_model.ScheduleViewModel

class ScheduleFragment : Fragment(R.layout.schedule_fragment) {

    companion object {
        fun newInstance() = ScheduleFragment()
    }

    private lateinit var viewModel: ScheduleViewModel



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScheduleViewModel::class.java)
    }

}