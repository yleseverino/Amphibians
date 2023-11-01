package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibianApiService

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibian>
}


class NetworkAmphibianRepository(
    private val amphibianService : AmphibianApiService
) : AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibian> = amphibianService.getAmpibians()
}