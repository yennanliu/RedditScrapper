package com.yen.RedditScrapper.model

class Schema {
  // attr
  var commentFilterCols: List[String] = List("body", "id", "score", "author", "author_fullname", "parent_id", "created_utc")
  var submissionFilterCols: List[String] = List("title", "selftext", "id", "upvote_ratio", "num_comments", "link_flair_text", "score", "created_utc", "author", "author_fullname", "retrieved_on")

  // constructor
  def this(commentFilterCols:List[String], submissionFilterCols:List[String]){
    this
    this.commentFilterCols = commentFilterCols
    this.submissionFilterCols = submissionFilterCols
  }
}
