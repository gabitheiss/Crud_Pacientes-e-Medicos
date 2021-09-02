package com.example.crud_pacientes_e_medicos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crud_pacientes_e_medicos.view.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}