package br.com.klenne.common

import br.com.klenne.remote.IGoogleAPIService
import br.com.klenne.remote.RetrofitClient

object Common {
    private val GOOGLE_API_URL="https://maps.googleapis.com"
    val googleApiService:IGoogleAPIService
    get()=RetrofitClient.getClient(GOOGLE_API_URL).create(IGoogleAPIService::class.java)



}