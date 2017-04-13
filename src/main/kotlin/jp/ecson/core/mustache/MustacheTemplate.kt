package jp.ecson.core.mustache

import com.github.mustachejava.DefaultMustacheFactory
import jp.ecson.core.Json
import jp.ecson.core.Option
import jp.ecson.core.Template
import java.io.Reader
import java.io.StringReader
import java.io.StringWriter
import java.io.Writer

class MustacheTemplate(override val name: String, val json: String) : Template {

    override fun build(model: Any, option: Option?): String {
        val json = Mustache.build(name, json, model)
        val map = Json.fromJson(json)
        map["from"] = option?.from
        map["size"] = option?.size
        map["explain"] = option?.explain
        map["version"] = option?.version
        return Json.toJson(map)
    }

    override fun toString(): String {
        return json
    }
}

object Mustache {
    val factory = DefaultMustacheFactory()

    fun build(name: String, json: String, model: Any? = null): String {
        val writer = StringWriter()
        build(name, StringReader(json), writer, model)
        return writer.toString()
    }

    fun build(name: String, json: Reader, writer: Writer, model: Any? = null) {
        val mustache = factory.compile(json, name)
        mustache.execute(writer, model)
    }
}
