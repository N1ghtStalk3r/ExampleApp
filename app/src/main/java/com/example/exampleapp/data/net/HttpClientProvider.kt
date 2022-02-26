package com.example.exampleapp.data.net

import com.example.exampleapp.data.ConstantsProvider
import io.ktor.client.HttpClient
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.host
import io.ktor.http.URLProtocol

class HttpClientProvider(
    private val constants: ConstantsProvider
) {
    fun getHttpClient() = HttpClient {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
        defaultRequest {
            host = ConstantsProvider.getBaseUrl()
            url {
                protocol = URLProtocol.HTTPS
            }
        }
    }
}