package org.example.microservices.user.domain.dto

data class MailResponseDto(
        var from: String = "",
        var to: String = "",
        var title: String = "",
        var text: String = "",
        var success: Boolean = true,
        var error: String = ""
)