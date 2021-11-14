echo "yyyymmdd: $1"

echo '>>> Step 1 : collect data  (data_loader.py) ...'
python src/main/python/data_loader.py -yyyymmdd $yyyymmdd

echo '>>> Step 2 : process & sink data (com.yen.RedditScrapper.spark.scala) ...'
spark-submit \
 --class com.yen.RedditScrapper.spark.Processor \
 target/scala-2.11/RedditScrapper-assembly-0.0.1.jar