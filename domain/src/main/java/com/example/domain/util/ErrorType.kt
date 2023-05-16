package com.example.domain.util

enum class ErrorType {
    NETWORK, // IO
    TIMEOUT, // Socket
    UNKNOWN, //Anything else
    API_AUTH,
    LOCATION,
    HTML
}