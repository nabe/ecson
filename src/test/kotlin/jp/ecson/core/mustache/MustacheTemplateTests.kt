package jp.ecson.core.mustache

import jp.ecson.core.Template
import org.junit.Test
import kotlin.test.assertEquals

class MustacheTemplateTests {

    @Test
    fun buildTest() {
        val template: Template = MustacheTemplate("test.json.mustache", """
{
  "num": {{ num }},
  "str": "{{ str }}",
  "unicode": "{{ unicode }}",
  "nest": {
    "list": [ {{#nest.list}}"{{ value }}"{{^last}},{{/last}}{{/nest.list}} ]
  }
}
""")
        val model: MutableMap<String, Any> = mutableMapOf()
        model["num"] = 12345
        model["str"] = "abcde"
        model["unicode"] = "あいうえお"
        model["nest"] = mutableMapOf(Pair("list", MustacheArray.of("a", "b", "c")))

        val result = template.build(model)
        assertEquals("""{"num":12345,"str":"abcde","unicode":"あいうえお","nest":{"list":["a","b","c"]},"from":null,"size":null,"explain":null,"version":null}""", result)
    }
}
