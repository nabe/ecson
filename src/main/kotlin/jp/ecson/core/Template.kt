package jp.ecson.core

interface Template {

    val name: String

    fun build(model: Any, option: Option? = null): String
    override fun toString(): String
}
