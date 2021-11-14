# RedditScrapper

## Run
```bash
# build
sbt assembly

# run
#bash bin/run.sh 2021-11-15
bash bin/run.sh <year-month-date>
```

## Ref
- Example endpoints
	- submission
		- https://api.pushshift.io/reddit/search/submission/?q=TIdaL
	- comment
		- https://api.pushshift.io/reddit/search/comment/?subreddit=TIdaL
- Doc
	- https://github.com/pushshift/api
	- https://www.reddit.com/r/TIdaL/