package com.example.demo

import org.springframework.stereotype.Component

@Component
class JapaneseGreeter : Greeter {

    override fun hello(name: String): String = "こんにちは、$name !"

}