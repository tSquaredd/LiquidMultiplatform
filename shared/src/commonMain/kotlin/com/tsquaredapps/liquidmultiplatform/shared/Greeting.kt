package com.tsquaredapps.liquidmultiplatform.shared


class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
