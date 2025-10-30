package com.humblecoders.humblebot.api

import com.humblecoders.humblebot.model.GeminiRequest
import com.humblecoders.humblebot.model.GeminiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface GeminiApi {
    @POST("/v1beta/models/gemini-2.5-flash:generateContent")
    suspend fun generateContent(
        @Query("key") apiKey: String,
        @Body request: GeminiRequest
    ): Response<GeminiResponse>
}

// contract
// separate what from how
// retrofit will generate the implementation at runtime
//


// internet -> API -> client
//
