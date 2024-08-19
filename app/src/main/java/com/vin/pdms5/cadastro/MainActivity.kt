package com.vin.pdms5.cadastro

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vin.pdms5.cadastro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)

        val estados = resources.getStringArray(R.array.estados_brasil)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, estados)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        amb.sUF.adapter = adapter

        fun validateFields(): Boolean {
            return amb.etFullName.text.isNotEmpty() &&
                    amb.etTelephone.text.isNotEmpty() &&
                    amb.etMail.text.isNotEmpty() &&
                    amb.etCity.text.isNotEmpty() &&
                    amb.rgGender.checkedRadioButtonId != -1
        }

        amb.btnSave.setOnClickListener {
            if (validateFields()) {
                val selectedGenderId = amb.rgGender.checkedRadioButtonId
                val selectedGender = findViewById<RadioButton>(selectedGenderId).text.toString()

                val form = Formulario(
                    fullName = amb.etFullName.text.toString(),
                    phone = amb.etTelephone.text.toString(),
                    mail = amb.etMail.text.toString(),
                    joinEmailList = amb.cbJoinMailList.isChecked,
                    city = amb.etCity.text.toString(),
                    uf = amb.sUF.selectedItem.toString(),
                    gender = selectedGender
                )
                Toast.makeText(this, form.toString(), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Todos os campos devem ser preenchidos", Toast.LENGTH_LONG)
                    .show()
            }
        }
        amb.btnClear.setOnClickListener {
            amb.etFullName.text.clear()
            amb.etTelephone.text.clear()
            amb.etMail.text.clear()
            amb.cbJoinMailList.isChecked = false
            amb.etCity.text.clear()
            amb.sUF.setSelection(0)
            amb.rgGender.clearCheck()
        }
    }
}
