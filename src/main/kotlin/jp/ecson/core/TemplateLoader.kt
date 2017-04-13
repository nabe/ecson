package jp.ecson.core

import java.io.InputStream
import java.io.Reader
import java.nio.charset.Charset

interface TemplateLoader {

    fun load(resource: String, loader: ClassLoader = this.javaClass.classLoader): Template

    fun load(name: String, input: InputStream, charset: Charset = Charsets.UTF_8): Template

    fun load(name: String, reader: Reader): Template
}
