package com.yen.RedditScrapper.dev

import play.api.libs.json._

// https://stackoverflow.com/questions/35921826/scala-get-page-content-as-json

object ReadEndPoint2 extends App {

  val url1 = "https://api.pushshift.io/reddit/search/comment/?q=scala"
  val rawData1 = scala.io.Source.fromURL(url1).mkString
  val parsedJson1:JsValue = Json.parse(rawData1)

  println("*** rawData1 = " + rawData1)
  println("*** parsedJson1 = " + parsedJson1)

}
