package com.tatuas.android.optional.core

class Optional<out T> {

    companion object {

        private val EMPTY = Optional<Any>()

        fun <T> ofNullable(value: T?) = if (value == null) empty() else of(value)

        fun <T> of(value: T) = Optional(value)

        @Suppress("UNCHECKED_CAST")
        fun <T> empty() = EMPTY as Optional<T>
    }

    val value: T?

    private constructor() {
        this.value = null
    }

    private constructor(value: T) {
        this.value = value
    }

    fun isPresent() = value != null

    fun <T> orElse(other: T) = value ?: other

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Optional<*>

        if (value != other.value) return false

        return true
    }

    override fun hashCode() = value?.hashCode() ?: 0

    override fun toString() = "Optional(value=$value)"
}
