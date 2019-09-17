package com.example.myapplication2


/**
author :shengsheng
date :2019/9/17
i despised my soul when i committed a wrong,and comforted myself that others also commit wrong.
 */

fun main() {
    val parames: HashMap<String, Any>? = HashMap()
    parames?.put("keyid", "1004")
    parames?.put("time", "1568698705624")
    parames?.put("userid", "294066")
    parames?.put("app_version", "5.5.3")
    parames?.put("appid", "100004")
    parames?.put("uutp", "android")
    parames?.put("uuid", "ffffffff-dfe4-a66d-24b0-59af559c6620")
    parames?.put("usertoken", "9390faed9a5a0db2818c2233e6c2ffc9")
    parames?.put("ip", "172.17.100.15")


    parames?.put("pagesize", "20")
    parames?.put("parentid", "805")
    parames?.put("type", "public")
    parames?.put("modules", "childcat:1")
    parames?.put("page", "2")


    var resultMD5 = SignUtil.a(parames)
    print(resultMD5)
}



