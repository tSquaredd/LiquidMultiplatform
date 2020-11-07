package com.tsquaredapps.liquidmultiplatform.androidApp.setup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.tsquaredapps.liquidmultiplatform.androidApp.R
import com.tsquaredapps.liquidmultiplatform.androidApp.databinding.ActivitySetupBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
