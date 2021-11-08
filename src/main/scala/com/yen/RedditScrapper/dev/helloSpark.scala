package com.yen.RedditScrapper.dev

import org.apache.spark.SparkContext

object helloSpark extends App {

  val sc = new SparkContext("local[*]", "helloSpark")

  val rdd1 = sc.parallelize(Array(1,2,3))

  println(rdd1.collect().toList)
}
