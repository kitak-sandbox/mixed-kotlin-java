package demo

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody

fun getGreeting(): String {
    val words = mutableListOf<String>()
    words.add("Hello,")
    words.add("world!")

    return words.joinToString(separator = " ")
}

fun main(args: Array<String>) {
    println(getGreeting())
    val client = OkHttpClient()
    val req = Request.Builder()
        .url("https://api.github.com/repos/square/okhttp/contributors")
        .build()
    val res = client.newCall(req).execute()
    val body: String? = res.body()?.string()
    if(body != null) {
        println(body)
    }
}