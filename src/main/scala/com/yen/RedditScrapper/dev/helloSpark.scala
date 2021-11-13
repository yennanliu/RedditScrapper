package com.yen.RedditScrapper.dev

import org.apache.spark.SparkContext

import com.yen.RedditScrapper.util.jsonParser

object helloSpark extends App {

  val sc = new SparkContext("local[*]", "helloSpark")

  val rdd1 = sc.parallelize(Array(1,2,3))

  println(rdd1.collect().toList)

//  val url = "https://api.pushshift.io/reddit/search/comment/?q=scala"
//  val json_parser = new jsonParser()
//  val jsonData = json_parser.parse(url)
//
//  println(jsonData.result.get("data").head)
}
