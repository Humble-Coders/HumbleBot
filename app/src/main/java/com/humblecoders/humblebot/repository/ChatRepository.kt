package com.humblecoders.humblebot.repository

import com.humblecoders.humblebot.api.NetworkClient
import com.humblecoders.humblebot.model.Content
import com.humblecoders.humblebot.model.GeminiRequest
import com.humblecoders.humblebot.model.Part


class ChatRepository {
    private val geminiApi = NetworkClient.geminiApi

    suspend fun sendMessage(message: String): Result<String> {
        return try {
            val request = GeminiRequest(
                listOf(
                    Content(
                        listOf(
                            Part(text = message))
                    )
                )
            )

            val response = geminiApi.generateContent(
                //Put your API key here
                apiKey = "",
                request = request
            )

            if (response.isSuccessful) {
                val geminiResponse = response.body()
                val reply = geminiResponse?.candidates?.firstOrNull()?.content?.parts?.firstOrNull()?.text
                Result.success(reply ?: "No response from Gemini")
            } else {
                Result.failure(Exception("API Error"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}