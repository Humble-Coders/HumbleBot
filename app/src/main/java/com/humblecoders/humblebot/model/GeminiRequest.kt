package com.humblecoders.humblebot.model

data class GeminiRequest(
    val contents: List<Content>
)

data class Content(
    val parts: List<Part>
)

data class Part(
    val text: String
)




/*

{
    "contents": [
    {
        "parts": [
        {
            "text": "Write a poem about sunrise"
        }
        ]
    }
    ]
}

*/