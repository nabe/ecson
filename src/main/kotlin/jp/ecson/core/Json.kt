package jp.ecson.core

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper

object Json {
    val mapper = ObjectMapper()

    fun toJson(value: Any?): String {
        return mapper.writeValueAsString(value)
    }

    fun fromJson(json: String): MutableMap<String, Any?> {
        return mapper.readValue(json, MutableMapTypeReference())
    }

    class MutableMapTypeReference : TypeReference<MutableMap<String, Any?>>()
}
