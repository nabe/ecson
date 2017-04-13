package jp.ecson.core

import org.junit.Test
import kotlin.test.assertEquals

class JsonTests {

    @Test
    fun toJsonTest() {
        val map = mutableMapOf<String, Any?>()
        map["num"] = 12345
        map["str"] = "abcde"
        map["unicode"] = "あいうえお"
        map["nest"] = mutableMapOf(Pair("list", listOf("a", "b", "c")))

        val json = Json.toJson(map)
        assertEquals("""{"num":12345,"str":"abcde","unicode":"あいうえお","nest":{"list":["a","b","c"]}}""", json)
    }

    @Test
    fun fromJsonTest() {
        val json = """
{
  "num": 12345,
  "str": "abcde",
  "unicode": "あいうえお",
  "nest": {
    "list": ["a", "b", "c"]
  }
}
"""
        val map = Json.fromJson(json)
        assertEquals(12345, map["num"])
        assertEquals("abcde", map["str"])
        assertEquals("あいうえお", map["unicode"])
        assertEquals(mapOf(Pair("list", listOf("a", "b", "c"))), map["nest"])
    }
}
