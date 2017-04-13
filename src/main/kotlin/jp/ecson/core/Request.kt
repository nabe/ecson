package jp.ecson.core

class Request(var index: Array<out String>? = null,
              var type: Array<out String>? =null,
              var template: Template? = null,
              var option: Option? = null) {

    companion object {
        fun index(vararg index: String): Request {
            val request = Request(index)
            return request
        }
    }

    fun index(vararg index: String): Request {
        this.index = index
        return this
    }

    fun type(vararg type: String): Request {
        this.type = type
        return this
    }

    fun template(template: Template): Request {
        this.template = template
        return this
    }

    fun option(option: Option): Request {
        this.option = option
        return this
    }
}
