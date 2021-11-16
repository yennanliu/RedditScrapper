package com.yen.RedditScrapper.model

import org.scalatest.{FunSuite}

import com.yen.RedditScrapper.model.Schema

class SchemaSuite extends FunSuite{

  val mySchema = new Schema()

  assert (mySchema.commentFilterCols == List("body", "id", "score", "author", "author_fullname", "parent_id", "created_utc"))
  assert (mySchema.submissionFilterCols == List("title", "selftext", "id", "upvote_ratio", "num_comments", "link_flair_text", "score", "created_utc", "author", "author_fullname", "retrieved_on"))
}
