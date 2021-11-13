package com.yen.RedditScrapper.spark

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

object Processer extends App {

  val sc = new SparkContext("local[*]", "helloSpark")
  val spark = SparkSession.builder().appName("Processer").getOrCreate()

  import spark.implicits._

  // load raw data

  // comment
  val commentRawPath = "/Users/yennanliu/RedditScrapper/data/raw/comment.json"
  val commentFilterCols = ("body","id","score","author","author_fullname","parent_id","created_utc")
  val commentDF = spark.read.json(commentRawPath).select("body","id","score","author","author_fullname","parent_id","created_utc")
  commentDF.show()

  // submission
  val submissionRawPath = "/Users/yennanliu/RedditScrapper/data/raw/submission.json"
  val submissionFilterCols = ("title","selftext","id","upvote_ratio","num_comments","link_flair_text","score","created_utc","author","author_fullname","retrieved_on")
  val submissionDF = spark.read.json(submissionRawPath)select("title","selftext","id","upvote_ratio","num_comments","link_flair_text","score","created_utc","author","author_fullname","retrieved_on")
  submissionDF.show()
}
