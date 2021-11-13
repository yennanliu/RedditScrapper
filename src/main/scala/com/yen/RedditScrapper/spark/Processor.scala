package com.yen.RedditScrapper.spark

import org.apache.spark.SparkContext
import org.apache.spark.sql.{SparkSession}

import com.yen.RedditScrapper.common.DFBuilder
import com.yen.RedditScrapper.model.Schema

object Processor{

  def main(args: Array[String]): Unit = {

//    if (args == 0){
//      println("argument missing! : --yyyymmdd")
//    }else{
//
//      println("will use default one : yyyymmdd = later")
//      java.time.LocalDate.now
//    }

    val yearMonthDate:String = java.time.LocalDate.now.toString //args(0)

    println(s"--yyyymmdd = $yearMonthDate")

    val sc = new SparkContext("local[*]", "Processor")
    val spark = SparkSession.builder().appName("Processor").getOrCreate()

    import spark.implicits._
    import org.apache.spark.sql.functions._

    /** Load */
    val df_builder = new DFBuilder()
    val schema = new Schema()

    // comment
    val commentRawPath = s"/Users/yennanliu/RedditScrapper/data/raw/$yearMonthDate/comment.json"
    val commentDF = df_builder.prepareDF(spark, commentRawPath, schema.commentFilterCols)
    commentDF.show()

    // submission
    val submissionRawPath = s"/Users/yennanliu/RedditScrapper/data/raw/$yearMonthDate/submission.json"
    val submissionDF = df_builder.prepareDF(spark, submissionRawPath, schema.submissionFilterCols)
    submissionDF.show()

    /** Save */
    // save to parquet
    commentDF.write.parquet(s"/Users/yennanliu/RedditScrapper/data/output/$yearMonthDate/comment")
    submissionDF.write.parquet(s"/Users/yennanliu/RedditScrapper/data/output/$yearMonthDate/submission")
  }
}
