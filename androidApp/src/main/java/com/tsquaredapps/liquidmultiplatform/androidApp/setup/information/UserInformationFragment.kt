package com.tsquaredapps.liquidmultiplatform.androidApp.setup.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.tsquaredapps.liquidmultiplatform.androidApp.R
import com.tsquaredapps.liquidmultiplatform.androidApp.common.BaseFragment
import com.tsquaredapps.liquidmultiplatform.androidApp.common.ext.hideKeyboardFrom
import com.tsquaredapps.liquidmultiplatform.androidApp.databinding.FragmentUserInformationBinding
import com.tsquaredapps.liquidmultiplatform.shared.common.LiquidUnit
import com.tsquaredapps.liquidmultiplatform.shared.setup.information.UserInformationState
import com.tsquaredapps.liquidmultiplatform.shared.setup.information.UserInformationState.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class UserInformationFragment : BaseFragment<FragmentUserInformationBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: UserInformationViewModel by viewModels { viewModelFactory }

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUserInformationBinding =
        FragmentUserInformationBinding.inflate(inflater, container, false)

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.stateLiveData.observe(viewLifecycleOwner) {
            onStateChanged(it)
        }

        binding.ozButton.setOnClickListener {
            viewModel.onUnitSelected(LiquidUnit.OZ)
        }

        binding.mlButton.setOnClickListener {
            viewModel.onUnitSelected(LiquidUnit.ML)
        }

        binding.continueButton.setOnClickListener {
            viewModel.onContinueClicked(binding.weightEditText.text.toString())
        }

        binding.weightEditText.setOnFocusChangeListener { weightEditText, hasFocus ->
            if (hasFocus) {
                (weightEditText as TextInputEditText).hint = ""
            } else {
                (weightEditText as TextInputEditText).hint = getString(R.string.weight_input_hint)
                weightEditText.context.hideKeyboardFrom(view.windowToken)
            }
        }

        setOzChecked()
    }

    private fun onStateChanged(state: UserInformationState) {
        when (state) {
            is InvalidWeight -> {
                context?.let {
                    showWeightError(state.errorMessage.toString(it))
                }
            }
            is Continue -> {
//                navigate(toDailyGoalDisplayFragment(state.weight, state.unitChoiceState))
            }
            is OzSelected -> {
                setOzChecked()
            }
            is MlSelected -> {
                setMlChecked()
            }
        }
    }

    private fun showWeightError(errorMessage: String) {
        binding.weightTextInputLayout.error = errorMessage
        binding.weightEditText.hint = ""

        setWeightTextWatcher(errorMessage)
    }

    private fun setWeightTextWatcher(errorMessage: String) {
        binding.weightEditText.addTextChangedListener {
            if (it.isNullOrBlank()) {
                binding.weightTextInputLayout.error = errorMessage
                binding.weightEditText.hint = ""
            } else {
                removeWeightError()
            }
        }
    }

    private fun removeWeightError() {
        binding.weightTextInputLayout.error = null
    }

    private fun setOzChecked() {
        binding.ozButton.isChecked = true
        binding.mlButton.isChecked = false
    }

    private fun setMlChecked() {
        binding.mlButton.isChecked = true
        binding.ozButton.isChecked = false
    }
}