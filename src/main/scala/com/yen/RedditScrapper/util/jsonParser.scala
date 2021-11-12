package com.yen.RedditScrapper.util

import play.api.libs.json._

class jsonParser {

  def parse(url:String):JsValue= {
    val rawData1 = scala.io.Source.fromURL(url).mkString
    Json.parse(rawData1)
  }

}
