package com.yen.RedditScrapper.dev

// https://github.com/json4s/json4s

import org.json4s._
import org.json4s.jackson.JsonMethods._

object ReadEndPoint1 extends App {

  val url1 = "https://api.pushshift.io/reddit/search/comment/?q=scala"
  val rawData1 = scala.io.Source.fromURL(url1).toString()//.replace("non",null)

  //println(rawData1.foreach(println(_)))

  println(parse(""" { "numbers" : [1, 2, 3, 4] } """))
  println(parse("""{"name":"Toy","price":35.35}""", useBigDecimalForDouble = true))

  //println(parse(rawData1))
}
