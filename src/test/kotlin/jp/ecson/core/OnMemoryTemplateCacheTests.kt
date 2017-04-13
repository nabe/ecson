package jp.ecson.core

import jp.ecson.core.mustache.MustacheTemplate
import org.junit.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class OnMemoryTemplateCacheTests {

    @Test
    fun getOrPutTest() {
        val cache: TemplateCache = OnMemoryTemplateCache()
        assertNull(cache.get("test"))

        val result = cache.getOrPut("test", {->
            MustacheTemplate("test", "{}")
        })
        assertNotNull(result)
        assertNotNull(cache.get("test"))
    }
}
