package com.nstudiosappdev.core.error

interface ErrorFactory {

    fun createUnknownError(): Error

    fun createApiError(code: Int, message: String?): Error

    fun createErrorFromThrowable(t: Throwable): Error

    fun createBusinessError(code: Int, message: String?): Error
}
