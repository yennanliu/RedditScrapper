package com.yen.RedditScrapper.spark

import org.apache.spark.SparkContext
import org.apache.spark.sql.{SparkSession}

import com.yen.RedditScrapper.common.DFBuilder
import com.yen.RedditScrapper.model.Schema

object Processor extends App {

  val sc = new SparkContext("local[*]", "helloSpark")
  val spark = SparkSession.builder().appName("Processer").getOrCreate()

  import spark.implicits._
  import org.apache.spark.sql.functions._

  /** Load */
  val df_builder = new DFBuilder()
  val schema = new Schema()

  // comment
  val commentRawPath = "/Users/yennanliu/RedditScrapper/data/raw/comment.json"
  val commentDF = df_builder.prepareDF(spark, commentRawPath, schema.commentFilterCols)
  commentDF.show()

  // submission
  val submissionRawPath = "/Users/yennanliu/RedditScrapper/data/raw/submission.json"
  val submissionDF = df_builder.prepareDF(spark, submissionRawPath, schema.submissionFilterCols)
  submissionDF.show()

  /** Save */
  // save to parquet
  commentDF.write.parquet("/Users/yennanliu/RedditScrapper/data/output/comment.parquet")
  submissionDF.write.parquet("/Users/yennanliu/RedditScrapper/data/output/submission.parquet")
}
