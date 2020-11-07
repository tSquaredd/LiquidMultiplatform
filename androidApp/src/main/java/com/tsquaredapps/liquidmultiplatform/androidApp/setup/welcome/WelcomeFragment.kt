package com.tsquaredapps.liquidmultiplatform.androidApp.setup.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.TextViewCompat
import com.tsquaredapps.liquidmultiplatform.androidApp.common.BaseFragment
import com.tsquaredapps.liquidmultiplatform.androidApp.common.ext.navigate
import com.tsquaredapps.liquidmultiplatform.androidApp.databinding.FragmentWelcomeBinding
import com.tsquaredapps.liquidmultiplatform.androidApp.setup.welcome.WelcomeFragmentDirections.Companion.toUserInformationFragment

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWelcomeBinding =
        FragmentWelcomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.getStartedButton.setOnClickListener {
            navigate(toUserInformationFragment())
        }

        TextViewCompat.setAutoSizeTextTypeWithDefaults(
            binding.welcomeText,
            TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM
        )
    }
}