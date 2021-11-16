package com.yen.RedditScrapper.spark

import org.apache.spark.SparkContext
import org.apache.spark.sql.{SparkSession}

import com.yen.RedditScrapper.common.DFBuilder
import com.yen.RedditScrapper.model.Schema

object Processor{

  def main(args: Array[String]): Unit = {

    var yearMonthDate:String = null

    if (args.length == 0){
      println("argument missing! : --yyyymmdd, will use today")
      yearMonthDate = java.time.LocalDate.now.toString
    }else{
      println("*** args(0) = " + args(0).toString)
      yearMonthDate = args(0).split("=")(1)
    }

    // println("args = " + args.toString)
    // val yearMonthDate:String = args(0)

    println(s"--yyyymmdd = $yearMonthDate")

    val sc = new SparkContext("local[*]", "Processor")
    val spark = SparkSession.builder().appName("Processor").getOrCreate()

    import spark.implicits._
    import org.apache.spark.sql.functions._

    val df_builder = new DFBuilder()
    val schema = new Schema()

    /** Load */
    // comment
    val commentRawPath = s"./data/raw/$yearMonthDate/comment.json"
    val commentDF = df_builder.prepareDF(spark, commentRawPath, schema.commentFilterCols)
    commentDF.show()

    // submission
    val submissionRawPath = s"./data/raw/$yearMonthDate/submission.json"
    val submissionDF = df_builder.prepareDF(spark, submissionRawPath, schema.submissionFilterCols)
    submissionDF.show()

    /** Save */
    // save to parquet
    commentDF.write.parquet(s"./data/output/$yearMonthDate/comment")
    submissionDF.write.parquet(s"./data/output/$yearMonthDate/submission")
  }
}
