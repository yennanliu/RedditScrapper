package com.yen.RedditScrapper.dev

// https://github.com/json4s/json4s

import org.json4s._
import org.json4s.jackson.JsonMethods._

import play.api.libs.json._

object ReadEndPoint1 extends App {

  val url1 = "https://api.pushshift.io/reddit/search/comment/?q=scala"
  val rawData1 = scala.io.Source.fromURL(url1).toString()//.replace("non",null)

  /** -------- test 1 ------- */

  println(parse(""" { "numbers" : [1, 2, 3, 4] } """))
  println(parse("""{"name":"Toy","price":35.35}""", useBigDecimalForDouble = true))
  //println(parse(rawData1))
  //println(rawData1.foreach(println(_)))

  /** -------- test 2 ------- */
  // via play
  // https://www.playframework.com/documentation/ja/2.4.x/ScalaJson
  val json: JsValue = Json.parse("""
    {
      "name" : "Watership Down",
      "location" : {
        "lat" : 51.235685,
        "long" : -1.309197
      },
      "residents" : [ {
        "name" : "Fiver",
        "age" : 4,
        "role" : null
      }, {
        "name" : "Bigwig",
        "age" : 6,
        "role" : "Owsla"
      } ]
    }
    """)
  println(json)
  println(json.result.get("name"))
  println(json.result.get("residents").toString())

}
