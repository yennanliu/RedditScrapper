package com.yen.RedditScrapper.common

import org.scalatest.{FunSuite}
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

import com.yen.RedditScrapper.common.DFBuilder

class DFBuilderSuite extends FunSuite {

  val sc = new SparkContext("local[*]", "DFBuilderSuite")
  val spark = SparkSession.builder().appName("DFBuilderSuite").getOrCreate()

  val df_builder = new DFBuilder()

  val mySchema = List("id", "name", "age")
  val myDF = df_builder.prepareDF(spark, "./data/test/test.json", mySchema)

  myDF.show()

  assert (myDF.columns.toList == mySchema)
  assert (myDF.count() == 3)
}
