package com.example.amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.amphibians.R
import com.example.amphibians.model.Amphibian

@Composable
fun HomeScreen(amphibiansUiState: AmphibiansUiState, retryAction :  ()->Unit , modifier: Modifier = Modifier) {
    when (amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is AmphibiansUiState.Success -> AmphibiansScreen(
            amphibiansUiState.data, modifier = modifier.fillMaxWidth()
        )

        is AmphibiansUiState.Error -> ErrorScreen(retryAction,modifier = modifier.fillMaxSize())
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Icon(
        Icons.Default.Refresh,
        modifier = modifier.size(200.dp),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
fun ErrorScreen(retryAction: () -> Unit,modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.Warning,
            modifier = modifier.size(200.dp),
            contentDescription = "Erro de conexão"
        )
        Text(text ="Erro", modifier = Modifier.padding(16.dp))
        Button(onClick =retryAction) {
            Text(text = "Tentar novamente")
        }
    }
}

@Composable
fun AmphibiansScreen(images: Int, modifier: Modifier = Modifier){
    Text(text = "Numero de sapos ${images}")
}