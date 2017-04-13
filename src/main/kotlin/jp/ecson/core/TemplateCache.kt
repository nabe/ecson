package jp.ecson.core

interface TemplateCache {

    fun get(name: String): Template?
    fun getOrPut(name: String, defaultValue: () -> Template): Template
    fun set(template: Template): String
}
