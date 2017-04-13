package jp.ecson.core.mustache

object MustacheArray {

    fun of(list: List<Any>): List<Item> {
        val result: MutableList<Item> = mutableListOf()
        list.mapIndexedTo(result) { index, value -> Item(index, value, list.size) }
        return result.toList()
    }

    fun of(vararg list: Any): List<Item> {
        return of(list.toList())
    }

    class Item(val index: Int, val value: Any, val listSize: Int) {

        fun first(): Boolean {
            return index == 0
        }

        fun last(): Boolean {
            return (index + 1) == listSize
        }
    }
}
