package io.github.tracer021.kotlin

import io.restassured.RestAssured



fun main(args: Array<String>) {
    System.err.close();
    System.setErr(System.out);

    val start = System.currentTimeMillis()
    val accessKey = System.getenv("accessKey");

    val url = "http://api.ipstack.com/check?access_key=$accessKey"
    val jsonPath = RestAssured.given()
            .get(url)
            .jsonPath()

    val ip  = jsonPath.get<String>("ip")
    val country =  jsonPath.get<String>("country_name")
    val city =  jsonPath.get<String>("city")
    println("IP: $ip Country is $country, City: $city")
    val diff = (System.currentTimeMillis() - start ) / 1000
    println("Took $diff seconds")
}
