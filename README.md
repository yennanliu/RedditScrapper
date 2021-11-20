# RedditScrapper
> Process Reddit comment data via Spark & scripts

## Run
```bash
# test
sbt test

# build
sbt assembly

# run
#bash bin/run.sh 2021-11-15
bash bin/run.sh <year-month-date>
```

## File structure
```
├── README.md
├── bin    : main run script
├── build.sbt
├── data   : raw/output data
├── doc 
├── project
├── src    : main application code (spark, python)
└── target

# built jar : target/scala-2.11/RedditScrapper-assembly-0.0.1.jar
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

scala> submission_output.show()
+--------------------+--------------------+------+------------+------------+--------------------+-----+-----------+--------------------+---------------+------------+
|               title|            selftext|    id|upvote_ratio|num_comments|     link_flair_text|score|created_utc|              author|author_fullname|retrieved_on|
+--------------------+--------------------+------+------------+------------+--------------------+-----+-----------+--------------------+---------------+------------+
|8g of tidal waves...|                    |qst3r0|         1.0|           0|                null|    1| 1636777041|            tillaxo6|    t2_frvt7a0n|  1636777053|
|[SHARE] An Evenin...|aHR0cHM6Ly90aGVmb...|qss1d5|         1.0|           0|            UPLOADED|    1| 1636773334|    harshvpandey101x|    t2_601jukxb|  1636773344|
|[1S1D Store] [H] ...|**Shop Link:**   ...|qsriap|         1.0|           1|                null|    1| 1636771522|     catalog6trcyhyt|    t2_aodainie|  1636771533|
|Question regardin...|Since learning th...|qspt2z|         1.0|           0|                null|    1| 1636765957|          tedfreitag|    t2_83gyzkhe|  1636765968|
|[SHARE] Tidal Req...|Hi there! I have ...|qspp4l|         1.0|           0|            UPLOADED|    1| 1636765603|Melodic_Purpose_3120|    t2_ghk1l74w|  1636765614|
|How bout a WIngs ...|Idk I love Marble...|qspldh|         1.0|           0|                null|    1| 1636765284|      Paranoid_Shark|    t2_81x7dwz8|  1636765294|
|Jason and Michael...|“Ah!” Jason grunt...|qspa4n|         1.0|           0|                TEXT|    1| 1636764292|            Light401|    t2_64s29eic|  1636764304|
|560s good on a ph...|Hey guys, looking...|qsotwj|         1.0|           1|Headphones - Open...|    1| 1636762887|          danmyers22|       t2_a6jg2|  1636762898|
|Just thought of a...|Forgive me if thi...|qso4b6|         1.0|           0|          Discussion|    1| 1636760700|     broken-cucumber|    t2_3t85nbb1|  1636760712|
|    Newcomer's guide|Hi, i searched a ...|qsn1k6|         1.0|           1|Headphones - Clos...|    1| 1636757491|       ZdenekGrygera|       t2_h854b|  1636757503|
|I Dread Retiring!...|When I started my...|qsmh10|         1.0|           0|                null|    1| 1636755819|   AUTISTICWEREWOLF2|    t2_cj60qwj5|  1636755830|
|[SHARE] Hans Zimm...|aHR0cHM6Ly9kcml2Z...|qsm76f|         1.0|           0|            UPLOADED|    1| 1636755006|             iAmmar9|    t2_16zvorau|  1636755017|
|Is my tank oversr...|20 gallon long pl...|qslu2f|         1.0|           0|                null|    1| 1636753972| Apprehensive_Bar306|    t2_a6evnpdu|  1636753983|
|[H] 350+ Orders S...|Discord - La Quic...|qslgch|         1.0|           0|                null|    1| 1636752850|           XLaQuicaX|    t2_cllpozmr|  1636752860|
|[H] 350+ Orders S...|Discord - La Quic...|qslg6l|         1.0|           0|                null|    1| 1636752836|           XLaQuicaX|    t2_cllpozmr|  1636752847|
|How do I upgrade ...|Current plan: SWA...|qslg3h|         1.0|           0|               Plans|    1| 1636752828|                NYB1|    t2_fle7hw80|  1636752839|
|[H] 350+ Orders S...|Discord - La Quic...|qslfx5|         1.0|           0|                null|    1| 1636752811|           XLaQuicaX|    t2_cllpozmr|  1636752822|
|[H] 350+ Orders S...|Discord - La Quic...|qslfqx|         1.0|           0|                null|    1| 1636752798|           XLaQuicaX|    t2_cllpozmr|  1636752810|
|[H] 350+ Orders S...|Discord - La Quic...|qslfkm|         1.0|           0|                null|    1| 1636752785|           XLaQuicaX|    t2_cllpozmr|  1636752797|
|[H] 350+ Orders S...|Discord - La Quic...|qslfck|         1.0|           0|                null|    1| 1636752768|           XLaQuicaX|    t2_cllpozmr|  1636752779|
+--------------------+--------------------+------+------------+------------+--------------------+-----+-----------+--------------------+---------------+------------+
only showing top 20 rows


scala>
```

</details>

## Ref
- [ref.md](https://github.com/yennanliu/RedditScrapper/blob/main/doc/ref.md)
