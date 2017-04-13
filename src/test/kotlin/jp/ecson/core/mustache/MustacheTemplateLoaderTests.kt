package jp.ecson.core.mustache

import jp.ecson.core.Template
import jp.ecson.core.TemplateLoader
import org.junit.Test
import kotlin.test.assertEquals

class MustacheTemplateLoaderTests {

    @Test
    fun loadTest() {
        val loader: TemplateLoader = MustacheTemplateLoader()
        val template: Template = loader.load(resource = "test.json.mustache")
        assertEquals("test.json.mustache", template.name)
        assertEquals("""{
  "num": 12345,
  "str": "abcde",
  "unicode": "あいうえお",
  "nest": {
    "list": ["a", "b", "c"]
  }
}
""", template.toString())
    }
}
