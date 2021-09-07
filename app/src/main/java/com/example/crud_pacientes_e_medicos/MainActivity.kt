package com.example.crud_pacientes_e_medicos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.crud_pacientes_e_medicos.databinding.MainActivityBinding
import com.example.crud_pacientes_e_medicos.view.DoctorFragment
import com.example.crud_pacientes_e_medicos.view.MainFragment
import com.example.crud_pacientes_e_medicos.view.ScheduleFragment
import com.example.crud_pacientes_e_medicos.view.SpecialtyFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottomNav()
        changeFrag(MainFragment.newInstance())
    }

    private fun changeFrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
    private fun bottomNav() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navPatient -> {
                    changeFrag(MainFragment.newInstance())
                }
                R.id.navDoctors -> {
                    changeFrag(DoctorFragment.newInstance())
                }
                R.id.navSpecialty -> {
                    changeFrag(SpecialtyFragment.newInstance())
                }
                R.id.navSchedules -> {
                    changeFrag(ScheduleFragment.newInstance())
                }
            }
            true
        }
    }
}