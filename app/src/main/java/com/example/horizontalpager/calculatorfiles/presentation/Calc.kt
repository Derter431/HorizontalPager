package com.example.horizontalpager.calculatorfiles.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.horizontalpager.calculatorfiles.Calculator
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.horizontalpager.calculatorfiles.CalculatorViewModel

@Composable
fun Calc() {
    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state

    Calculator(
        state = state,
        onAction = viewModel::onAction,
        modifier = Modifier
            .fillMaxSize()


    )

    }

