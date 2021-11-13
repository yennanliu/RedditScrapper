package com.yen.RedditScrapper.spark

import org.apache.spark.SparkContext
import org.apache.spark.sql.{SparkSession}

import com.yen.RedditScrapper.common.DFBuilder

object Processor extends App {

  val sc = new SparkContext("local[*]", "helloSpark")
  val spark = SparkSession.builder().appName("Processer").getOrCreate()

  import spark.implicits._
  import org.apache.spark.sql.functions._

  /** Load */

  val df_builder = new DFBuilder()
  // comment
  val commentRawPath = "/Users/yennanliu/RedditScrapper/data/raw/comment.json"
  val commentFilterCols:List[String] = List("body","id","score","author","author_fullname","parent_id","created_utc")
  val commentDF = df_builder.prepareDF(spark, commentRawPath, commentFilterCols)
  commentDF.show()

  // submission
  val submissionRawPath = "/Users/yennanliu/RedditScrapper/data/raw/submission.json"
  val submissionFilterCols:List[String] = List("title","selftext","id","upvote_ratio","num_comments","link_flair_text","score","created_utc","author","author_fullname","retrieved_on")
  val submissionDF = df_builder.prepareDF(spark, submissionRawPath, submissionFilterCols)
  submissionDF.show()

  /** Save */
  // save to parquet
  commentDF.write.parquet("/Users/yennanliu/RedditScrapper/data/output/comment.parquet")
  submissionDF.write.parquet("/Users/yennanliu/RedditScrapper/data/output/submission.parquet")
}
