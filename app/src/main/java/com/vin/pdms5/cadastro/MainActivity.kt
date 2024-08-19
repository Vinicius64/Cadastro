package com.vin.pdms5.cadastro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vin.pdms5.cadastro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)
    }
}