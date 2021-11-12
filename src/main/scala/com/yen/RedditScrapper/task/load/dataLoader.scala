package com.yen.RedditScrapper.task.load

import java.io._
import spray.json._
import java.io.{BufferedWriter, FileWriter}

import com.yen.RedditScrapper.util.jsonParser

object dataLoader extends App {

  val url = "https://api.pushshift.io/reddit/search/comment/?q=scala"
  val json_parser = new jsonParser()
  val jsonData = json_parser.parse(url)

  println(jsonData.result.get("data").head)

  // write
  //  val w = new BufferedWriter(new FileWriter("output.txt"))
  //  w.write(jsonData.toJson.prettyPrint)
  //  w.close
}
