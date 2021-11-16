# RedditScrapper
> Process Reddit comment data via Spark & scripts

## Run
```bash
# build
sbt assembly

# run
#bash bin/run.sh 2021-11-15
bash bin/run.sh <year-month-date>
```

## Test
```bash
sbt test
```

## Demo

<details>
<summary>Demo</summary>

```bash
Welcome to
      ____              __
     / __/__  ___ _____/ /__
    _\ \/ _ \/ _ `/ __/  '_/
   /___/ .__/\_,_/_/ /_/\_\   version 3.0.0
      /_/

Using Scala version 2.12.10 (OpenJDK 64-Bit Server VM, Java 1.8.0_252)
Type in expressions to have them evaluated.
Type :help for more information.

scala> import spark.implicits._
import spark.implicits._

scala> val comment_output =  spark.read.parquet("./data/output/2021-11-13/comment")
comment_output: org.apache.spark.sql.DataFrame = [body: string, id: string ... 5 more fields]

scala> comment_output.show()
+--------------------+-------+-----+--------------------+---------------+----------+-----------+
|                body|     id|score|              author|author_fullname| parent_id|created_utc|
+--------------------+-------+-----+--------------------+---------------+----------+-----------+
|Uapp is better th...|hkf7mw1|    1|       FlowersPowerz|     t2_50ls85f|t1_hjz12my| 1636777906|
|🤷🏻‍♂️I like the...|hkf2t5z|    1|          Gundam_net|    t2_9ku39crx|t1_hiuxjyd| 1636775263|
|Yeah i like tidal...|hkdajqh|    1|           ashtar123|    t2_3pjt3hbj| t3_qksyuu| 1636745276|
|   Not really for me|hkdagrb|    1|           ashtar123|    t2_3pjt3hbj| t3_qkp49s| 1636745240|
|3 bucks a month??...|hkd9ez5|    1|           ashtar123|    t2_3pjt3hbj|t1_hjqv4ah| 1636744790|
|   I'll check it out|hkd9a76|    1|           ashtar123|    t2_3pjt3hbj|t1_hjrbudi| 1636744733|
|    Congrats i guess|hkd96hu|    1|           ashtar123|    t2_3pjt3hbj| t3_qp5y19| 1636744690|
|I just use samson...|hkd8zml|    1|           ashtar123|    t2_3pjt3hbj| t3_qptzax| 1636744608|
|     Damn only in us|hkd82ua|    1|           ashtar123|    t2_3pjt3hbj|t1_hk7cquz| 1636744218|
| Dayum that's a deal|hkd6z14|    1|           ashtar123|    t2_3pjt3hbj|t1_hk7cquz| 1636743748|
|Have you let Tida...|hkd60uq|    1|            nelamvr6|       t2_8e9al|t1_hi1qpzk| 1636743345|
|High is 320 AAC (...|hkck0nj|    1|      Smart-Time6212|    t2_7nt5ye01| t3_qse6ue| 1636734384|
|Sounds like a bad...|hkb0lt5|    1|          Nightbull_|       t2_zg325|t1_hk8kj1b| 1636700068|
|Just saw this, 77...|hkai8b8|    1|      Smart-Time6212|    t2_7nt5ye01|t1_haecrmk| 1636689308|
|           [removed]|hka5z83|    1|           [deleted]|           null|t1_hk8vwgs| 1636683570|
| I’m going with now!|hka573r|    1|            Drippy-G|     t2_kglklgt| t3_ixyra4| 1636683218|
|This happened to ...|hk9cye2|    1|Hopeful-Research3547|    t2_abvhbj1s|t1_hk7u7hr| 1636669916|
|Verify on another...|hk95ff5|    1|    boozeBeforeBoobs|    t2_177y4qm4| t3_qrskkk| 1636666729|
|Damn. I really wa...|hk8xifl|    1|         EarlMarshal|     t2_ke872zy|t1_hk8oqwj| 1636663470|
|Apple photography...|hk8vwgs|    1|           anodyne88|       t2_4tfx5| t3_qptzax| 1636662807|
+--------------------+-------+-----+--------------------+---------------+----------+-----------+
only showing top 20 rows


scala>
scala> val submission_output =  spark.read.parquet("./data/output/2021-11-13/submission")
submission_output: org.apache.spark.sql.DataFrame = [title: string, selftext: string ... 9 more fields]

scala> comment_output.show()
+--------------------+-------+-----+--------------------+---------------+----------+-----------+
|                body|     id|score|              author|author_fullname| parent_id|created_utc|
+--------------------+-------+-----+--------------------+---------------+----------+-----------+
|Uapp is better th...|hkf7mw1|    1|       FlowersPowerz|     t2_50ls85f|t1_hjz12my| 1636777906|
|🤷🏻‍♂️I like the...|hkf2t5z|    1|          Gundam_net|    t2_9ku39crx|t1_hiuxjyd| 1636775263|
|Yeah i like tidal...|hkdajqh|    1|           ashtar123|    t2_3pjt3hbj| t3_qksyuu| 1636745276|
|   Not really for me|hkdagrb|    1|           ashtar123|    t2_3pjt3hbj| t3_qkp49s| 1636745240|
|3 bucks a month??...|hkd9ez5|    1|           ashtar123|    t2_3pjt3hbj|t1_hjqv4ah| 1636744790|
|   I'll check it out|hkd9a76|    1|           ashtar123|    t2_3pjt3hbj|t1_hjrbudi| 1636744733|
|    Congrats i guess|hkd96hu|    1|           ashtar123|    t2_3pjt3hbj| t3_qp5y19| 1636744690|
|I just use samson...|hkd8zml|    1|           ashtar123|    t2_3pjt3hbj| t3_qptzax| 1636744608|
|     Damn only in us|hkd82ua|    1|           ashtar123|    t2_3pjt3hbj|t1_hk7cquz| 1636744218|
| Dayum that's a deal|hkd6z14|    1|           ashtar123|    t2_3pjt3hbj|t1_hk7cquz| 1636743748|
|Have you let Tida...|hkd60uq|    1|            nelamvr6|       t2_8e9al|t1_hi1qpzk| 1636743345|
|High is 320 AAC (...|hkck0nj|    1|      Smart-Time6212|    t2_7nt5ye01| t3_qse6ue| 1636734384|
|Sounds like a bad...|hkb0lt5|    1|          Nightbull_|       t2_zg325|t1_hk8kj1b| 1636700068|
|Just saw this, 77...|hkai8b8|    1|      Smart-Time6212|    t2_7nt5ye01|t1_haecrmk| 1636689308|
|           [removed]|hka5z83|    1|           [deleted]|           null|t1_hk8vwgs| 1636683570|
| I’m going with now!|hka573r|    1|            Drippy-G|     t2_kglklgt| t3_ixyra4| 1636683218|
|This happened to ...|hk9cye2|    1|Hopeful-Research3547|    t2_abvhbj1s|t1_hk7u7hr| 1636669916|
|Verify on another...|hk95ff5|    1|    boozeBeforeBoobs|    t2_177y4qm4| t3_qrskkk| 1636666729|
|Damn. I really wa...|hk8xifl|    1|         EarlMarshal|     t2_ke872zy|t1_hk8oqwj| 1636663470|
|Apple photography...|hk8vwgs|    1|           anodyne88|       t2_4tfx5| t3_qptzax| 1636662807|
+--------------------+-------+-----+--------------------+---------------+----------+-----------+
only showing top 20 rows


scala>
```

</details>

## Ref
- Example endpoints
	- submission
		- https://api.pushshift.io/reddit/search/submission/?q=TIdaL
	- comment
		- https://api.pushshift.io/reddit/search/comment/?subreddit=TIdaL
- Doc
	- https://github.com/pushshift/api
	- https://www.reddit.com/r/TIdaL/