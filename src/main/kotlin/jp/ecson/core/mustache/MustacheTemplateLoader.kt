package jp.ecson.core.mustache

import jp.ecson.core.Template
import jp.ecson.core.TemplateLoader
import java.io.InputStream
import java.io.Reader
import java.nio.charset.Charset

class MustacheTemplateLoader : TemplateLoader {

    override fun load(resource: String, loader: ClassLoader): Template {
        return load(resource, loader.getResourceAsStream(resource))
    }

    override fun load(name: String, input: InputStream, charset: Charset): Template {
        return load(name, input.bufferedReader(charset))
    }

    override fun load(name: String, reader: Reader): Template {
        val json = reader.readText()
        return MustacheTemplate(name, json)
    }
}
