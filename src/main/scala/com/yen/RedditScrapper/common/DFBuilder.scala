package com.yen.RedditScrapper.common

import org.apache.spark.sql
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col

class DFBuilder {
  def prepareDF(spark:SparkSession, srcFile:String, dfCols:List[String]): sql.DataFrame = {
    val df = spark.read.json(srcFile).select(dfCols.map(col): _*)
    df
  }
}
