package com.tsquaredapps.liquidmutliplatform.androidApp.setup.welcome

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.TextViewCompat
import com.tsquaredapps.liquidmutliplatform.androidApp.common.BaseFragment
import com.tsquaredapps.liquidmutliplatform.androidApp.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWelcomeBinding =
        FragmentWelcomeBinding.inflate(inflater, container, false)

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.getStartedButton.setOnClickListener {
//            navigate(toUserInformationFragment())
        }

        TextViewCompat.setAutoSizeTextTypeWithDefaults(
            binding.welcomeText,
            TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM
        )
    }
}