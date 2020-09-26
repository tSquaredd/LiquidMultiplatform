package com.tsquaredapps.liquidmutliplatform.androidApp.setup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.tsquaredapps.liquidmutliplatform.androidApp.R
import com.tsquaredapps.liquidmutliplatform.androidApp.databinding.ActivitySetupBinding

class SetupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySetupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetupBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.hostFragment).navigateUp()
}
