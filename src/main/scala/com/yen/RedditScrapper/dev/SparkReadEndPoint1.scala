package com.yen.RedditScrapper.dev

// https://towardsdatascience.com/apache-spark-stream-reading-data-from-local-http-server-d37e90e70fb0
// https://stackoverflow.com/questions/59134039/spark-read-json-with-request-parameters

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

object SparkReadEndPoint1 extends App {

  val sc = new SparkContext("local[*]", "SparkReadEndPoint1")
  val spark = SparkSession.builder().getOrCreate()

  import spark.implicits._

  val url1 = "https://api.pushshift.io/reddit/search/comment/?q=scala"
  val rawData1 = scala.io.Source.fromURL(url1).toList
  println(rawData1)

  //println(rawData1)
  //  val data1 = spark.read.json(rawData1)
  //  println(data1.take(10))
}
