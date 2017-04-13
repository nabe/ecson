package jp.ecson.core

class OnMemoryTemplateCache : TemplateCache {

    private object Cache {
        val values = mutableMapOf<String, Template>()
    }

    override fun get(name: String): Template? {
        return Cache.values[name]
    }

    override fun getOrPut(name: String, defaultValue: () -> Template): Template {
        return Cache.values.getOrPut(name, defaultValue)
    }

    override fun set(template: Template): String {
        Cache.values[template.name] = template
        return template.name
    }
}
