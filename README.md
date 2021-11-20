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

### part 1) Run process

```bash
# run process
(dci_de) yennanliu@MacBook-Pro RedditScrapper % bash bin/run.sh 2021-11-21
yyyymmdd : 2021-11-21
>>> Step 1 : collect data  (data_loader.py) ...
collect comment data ...
========== check_path_exist ==========
path = data/raw/2021-11-21
collect submission data ...
========== check_path_exist ==========
path = data/raw/2021-11-21
>>> Step 2 : process & sink data (com.yen.RedditScrapper.spark.scala) ...
21/11/21 00:55:08 WARN Utils: Your hostname, MacBook-Pro.local resolves to a loopback address: 127.0.0.1; using 192.168.0.226 instead (on interface en0)
21/11/21 00:55:08 WARN Utils: Set SPARK_LOCAL_IP if you need to bind to another address
21/11/21 00:55:09 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
*** args(0) = --yyyymmdd=2021-11-21
--yyyymmdd = 2021-11-21
Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
21/11/21 00:55:09 INFO SparkContext: Running Spark version 3.0.0
21/11/21 00:55:09 INFO ResourceUtils: ==============================================================
21/11/21 00:55:09 INFO ResourceUtils: Resources for spark.driver:

21/11/21 00:55:09 INFO ResourceUtils: ==============================================================
21/11/21 00:55:09 INFO SparkContext: Submitted application: Processor
21/11/21 00:55:09 INFO SecurityManager: Changing view acls to: yennanliu
21/11/21 00:55:09 INFO SecurityManager: Changing modify acls to: yennanliu
21/11/21 00:55:09 INFO SecurityManager: Changing view acls groups to:
21/11/21 00:55:09 INFO SecurityManager: Changing modify acls groups to:
21/11/21 00:55:09 INFO SecurityManager: SecurityManager: authentication disabled; ui acls disabled; users  with view permissions: Set(yennanliu); groups with view permissions: Set(); users  with modify permissions: Set(yennanliu); groups with modify permissions: Set()
21/11/21 00:55:09 INFO Utils: Successfully started service 'sparkDriver' on port 50560.
21/11/21 00:55:09 INFO SparkEnv: Registering MapOutputTracker
21/11/21 00:55:09 INFO SparkEnv: Registering BlockManagerMaster
21/11/21 00:55:09 INFO BlockManagerMasterEndpoint: Using org.apache.spark.storage.DefaultTopologyMapper for getting topology information
21/11/21 00:55:09 INFO BlockManagerMasterEndpoint: BlockManagerMasterEndpoint up
21/11/21 00:55:09 INFO SparkEnv: Registering BlockManagerMasterHeartbeat
21/11/21 00:55:09 INFO DiskBlockManager: Created local directory at /private/var/folders/51/3j6n8rwd74g2tsjt5jhcy91w0000gn/T/blockmgr-066f154b-d61a-441e-92c6-7cde811df442
21/11/21 00:55:09 INFO MemoryStore: MemoryStore started with capacity 366.3 MiB
21/11/21 00:55:09 INFO SparkEnv: Registering OutputCommitCoordinator
21/11/21 00:55:10 INFO Utils: Successfully started service 'SparkUI' on port 4040.
21/11/21 00:55:10 INFO SparkUI: Bound SparkUI to 0.0.0.0, and started at http://192.168.0.226:4040
21/11/21 00:55:10 INFO SparkContext: Added JAR file:/Users/yennanliu/RedditScrapper/target/scala-2.11/RedditScrapper-assembly-0.0.1.jar at spark://192.168.0.226:50560/jars/RedditScrapper-assembly-0.0.1.jar with timestamp 1637427310200
21/11/21 00:55:10 INFO Executor: Starting executor ID driver on host 192.168.0.226
21/11/21 00:55:10 INFO Utils: Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 50561.
21/11/21 00:55:10 INFO NettyBlockTransferService: Server created on 192.168.0.226:50561
21/11/21 00:55:10 INFO BlockManager: Using org.apache.spark.storage.RandomBlockReplicationPolicy for block replication policy
21/11/21 00:55:10 INFO BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 192.168.0.226, 50561, None)
21/11/21 00:55:10 INFO BlockManagerMasterEndpoint: Registering block manager 192.168.0.226:50561 with 366.3 MiB RAM, BlockManagerId(driver, 192.168.0.226, 50561, None)
21/11/21 00:55:10 INFO BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 192.168.0.226, 50561, None)
21/11/21 00:55:10 INFO BlockManager: Initialized BlockManager: BlockManagerId(driver, 192.168.0.226, 50561, None)
21/11/21 00:55:10 WARN SparkContext: Using an existing SparkContext; some configuration may not take effect.
21/11/21 00:55:10 INFO SharedState: Setting hive.metastore.warehouse.dir ('null') to the value of spark.sql.warehouse.dir ('file:/Users/yennanliu/RedditScrapper/spark-warehouse').
21/11/21 00:55:10 INFO SharedState: Warehouse path is 'file:/Users/yennanliu/RedditScrapper/spark-warehouse'.
21/11/21 00:55:11 INFO InMemoryFileIndex: It took 39 ms to list leaf files for 1 paths.
21/11/21 00:55:11 INFO InMemoryFileIndex: It took 1 ms to list leaf files for 1 paths.
21/11/21 00:55:13 INFO FileSourceStrategy: Pruning directories with:
21/11/21 00:55:13 INFO FileSourceStrategy: Pushed Filters:
21/11/21 00:55:13 INFO FileSourceStrategy: Post-Scan Filters:
21/11/21 00:55:13 INFO FileSourceStrategy: Output Data Schema: struct<value: string>
21/11/21 00:55:13 INFO MemoryStore: Block broadcast_0 stored as values in memory (estimated size 284.8 KiB, free 366.0 MiB)
21/11/21 00:55:14 INFO MemoryStore: Block broadcast_0_piece0 stored as bytes in memory (estimated size 23.9 KiB, free 366.0 MiB)
21/11/21 00:55:14 INFO BlockManagerInfo: Added broadcast_0_piece0 in memory on 192.168.0.226:50561 (size: 23.9 KiB, free: 366.3 MiB)
21/11/21 00:55:14 INFO SparkContext: Created broadcast 0 from json at DFBuilder.scala:9
21/11/21 00:55:14 INFO FileSourceScanExec: Planning scan with bin packing, max size: 4194304 bytes, open cost is considered as scanning 4194304 bytes.
21/11/21 00:55:14 INFO SparkContext: Starting job: json at DFBuilder.scala:9
21/11/21 00:55:14 INFO DAGScheduler: Got job 0 (json at DFBuilder.scala:9) with 1 output partitions
21/11/21 00:55:14 INFO DAGScheduler: Final stage: ResultStage 0 (json at DFBuilder.scala:9)
21/11/21 00:55:14 INFO DAGScheduler: Parents of final stage: List()
21/11/21 00:55:14 INFO DAGScheduler: Missing parents: List()
21/11/21 00:55:14 INFO DAGScheduler: Submitting ResultStage 0 (MapPartitionsRDD[3] at json at DFBuilder.scala:9), which has no missing parents
21/11/21 00:55:14 INFO MemoryStore: Block broadcast_1 stored as values in memory (estimated size 11.9 KiB, free 366.0 MiB)
21/11/21 00:55:14 INFO MemoryStore: Block broadcast_1_piece0 stored as bytes in memory (estimated size 6.2 KiB, free 366.0 MiB)
21/11/21 00:55:14 INFO BlockManagerInfo: Added broadcast_1_piece0 in memory on 192.168.0.226:50561 (size: 6.2 KiB, free: 366.3 MiB)
21/11/21 00:55:14 INFO SparkContext: Created broadcast 1 from broadcast at DAGScheduler.scala:1200
21/11/21 00:55:14 INFO DAGScheduler: Submitting 1 missing tasks from ResultStage 0 (MapPartitionsRDD[3] at json at DFBuilder.scala:9) (first 15 tasks are for partitions Vector(0))
21/11/21 00:55:14 INFO TaskSchedulerImpl: Adding task set 0.0 with 1 tasks
21/11/21 00:55:14 INFO TaskSetManager: Starting task 0.0 in stage 0.0 (TID 0, 192.168.0.226, executor driver, partition 0, PROCESS_LOCAL, 7768 bytes)
21/11/21 00:55:14 INFO Executor: Running task 0.0 in stage 0.0 (TID 0)
21/11/21 00:55:14 INFO Executor: Fetching spark://192.168.0.226:50560/jars/RedditScrapper-assembly-0.0.1.jar with timestamp 1637427310200
21/11/21 00:55:14 INFO TransportClientFactory: Successfully created connection to /192.168.0.226:50560 after 50 ms (0 ms spent in bootstraps)
21/11/21 00:55:14 INFO Utils: Fetching spark://192.168.0.226:50560/jars/RedditScrapper-assembly-0.0.1.jar to /private/var/folders/51/3j6n8rwd74g2tsjt5jhcy91w0000gn/T/spark-60739b5c-1323-48db-aaef-3d17ef2b68ce/userFiles-bfdb944a-501e-4fae-be59-c39527fdf2df/fetchFileTemp616929069251746444.tmp
21/11/21 00:55:15 INFO Executor: Adding file:/private/var/folders/51/3j6n8rwd74g2tsjt5jhcy91w0000gn/T/spark-60739b5c-1323-48db-aaef-3d17ef2b68ce/userFiles-bfdb944a-501e-4fae-be59-c39527fdf2df/RedditScrapper-assembly-0.0.1.jar to class loader
21/11/21 00:55:15 INFO FileScanRDD: Reading File path: file:///Users/yennanliu/RedditScrapper/data/raw/2021-11-21/comment.json, range: 0-70690, partition values: [empty row]
21/11/21 00:55:15 INFO CodeGenerator: Code generated in 175.214869 ms
21/11/21 00:55:15 INFO Executor: Finished task 0.0 in stage 0.0 (TID 0). 3879 bytes result sent to driver
21/11/21 00:55:15 INFO TaskSetManager: Finished task 0.0 in stage 0.0 (TID 0) in 1252 ms on 192.168.0.226 (executor driver) (1/1)
21/11/21 00:55:15 INFO TaskSchedulerImpl: Removed TaskSet 0.0, whose tasks have all completed, from pool
21/11/21 00:55:15 INFO DAGScheduler: ResultStage 0 (json at DFBuilder.scala:9) finished in 1.390 s
21/11/21 00:55:15 INFO DAGScheduler: Job 0 is finished. Cancelling potential speculative or zombie tasks for this job
21/11/21 00:55:15 INFO TaskSchedulerImpl: Killing all running tasks in stage 0: Stage finished
21/11/21 00:55:15 INFO DAGScheduler: Job 0 finished: json at DFBuilder.scala:9, took 1.434355 s
21/11/21 00:55:16 INFO BlockManagerInfo: Removed broadcast_1_piece0 on 192.168.0.226:50561 in memory (size: 6.2 KiB, free: 366.3 MiB)
21/11/21 00:55:16 INFO BlockManagerInfo: Removed broadcast_0_piece0 on 192.168.0.226:50561 in memory (size: 23.9 KiB, free: 366.3 MiB)
21/11/21 00:55:16 WARN package: Truncated the string representation of a plan since it was too large. This behavior can be adjusted by setting 'spark.sql.debug.maxToStringFields'.
21/11/21 00:55:16 INFO FileSourceStrategy: Pruning directories with:
21/11/21 00:55:16 INFO FileSourceStrategy: Pushed Filters:
21/11/21 00:55:16 INFO FileSourceStrategy: Post-Scan Filters:
21/11/21 00:55:16 INFO FileSourceStrategy: Output Data Schema: struct<author: string, author_fullname: string, body: string, created_utc: bigint, id: string ... 5 more fields>
21/11/21 00:55:16 INFO CodeGenerator: Code generated in 22.080714 ms
21/11/21 00:55:16 INFO MemoryStore: Block broadcast_2 stored as values in memory (estimated size 284.8 KiB, free 366.0 MiB)
21/11/21 00:55:16 INFO MemoryStore: Block broadcast_2_piece0 stored as bytes in memory (estimated size 23.9 KiB, free 366.0 MiB)
21/11/21 00:55:16 INFO BlockManagerInfo: Added broadcast_2_piece0 in memory on 192.168.0.226:50561 (size: 23.9 KiB, free: 366.3 MiB)
21/11/21 00:55:16 INFO SparkContext: Created broadcast 2 from show at Processor.scala:41
21/11/21 00:55:16 INFO FileSourceScanExec: Planning scan with bin packing, max size: 4194304 bytes, open cost is considered as scanning 4194304 bytes.
21/11/21 00:55:16 INFO SparkContext: Starting job: show at Processor.scala:41
21/11/21 00:55:16 INFO DAGScheduler: Got job 1 (show at Processor.scala:41) with 1 output partitions
21/11/21 00:55:16 INFO DAGScheduler: Final stage: ResultStage 1 (show at Processor.scala:41)
21/11/21 00:55:16 INFO DAGScheduler: Parents of final stage: List()
21/11/21 00:55:16 INFO DAGScheduler: Missing parents: List()
21/11/21 00:55:16 INFO DAGScheduler: Submitting ResultStage 1 (MapPartitionsRDD[7] at show at Processor.scala:41), which has no missing parents
21/11/21 00:55:16 INFO MemoryStore: Block broadcast_3 stored as values in memory (estimated size 13.7 KiB, free 366.0 MiB)
21/11/21 00:55:16 INFO MemoryStore: Block broadcast_3_piece0 stored as bytes in memory (estimated size 6.4 KiB, free 366.0 MiB)
21/11/21 00:55:16 INFO BlockManagerInfo: Added broadcast_3_piece0 in memory on 192.168.0.226:50561 (size: 6.4 KiB, free: 366.3 MiB)
21/11/21 00:55:16 INFO SparkContext: Created broadcast 3 from broadcast at DAGScheduler.scala:1200
21/11/21 00:55:16 INFO DAGScheduler: Submitting 1 missing tasks from ResultStage 1 (MapPartitionsRDD[7] at show at Processor.scala:41) (first 15 tasks are for partitions Vector(0))
21/11/21 00:55:16 INFO TaskSchedulerImpl: Adding task set 1.0 with 1 tasks
21/11/21 00:55:16 INFO TaskSetManager: Starting task 0.0 in stage 1.0 (TID 1, 192.168.0.226, executor driver, partition 0, PROCESS_LOCAL, 7768 bytes)
21/11/21 00:55:16 INFO Executor: Running task 0.0 in stage 1.0 (TID 1)
21/11/21 00:55:16 INFO FileScanRDD: Reading File path: file:///Users/yennanliu/RedditScrapper/data/raw/2021-11-21/comment.json, range: 0-70690, partition values: [empty row]
21/11/21 00:55:16 INFO CodeGenerator: Code generated in 13.076424 ms
21/11/21 00:55:16 INFO Executor: Finished task 0.0 in stage 1.0 (TID 1). 5334 bytes result sent to driver
21/11/21 00:55:16 INFO TaskSetManager: Finished task 0.0 in stage 1.0 (TID 1) in 59 ms on 192.168.0.226 (executor driver) (1/1)
21/11/21 00:55:16 INFO TaskSchedulerImpl: Removed TaskSet 1.0, whose tasks have all completed, from pool
21/11/21 00:55:16 INFO DAGScheduler: ResultStage 1 (show at Processor.scala:41) finished in 0.068 s
21/11/21 00:55:16 INFO DAGScheduler: Job 1 is finished. Cancelling potential speculative or zombie tasks for this job
21/11/21 00:55:16 INFO TaskSchedulerImpl: Killing all running tasks in stage 1: Stage finished
21/11/21 00:55:16 INFO DAGScheduler: Job 1 finished: show at Processor.scala:41, took 0.072375 s
21/11/21 00:55:16 INFO CodeGenerator: Code generated in 18.358255 ms
+--------------------+-------+-----+----------------+---------------+----------+-----------+
|                body|     id|score|          author|author_fullname| parent_id|created_utc|
+--------------------+-------+-----+----------------+---------------+----------+-----------+
|Rainy days &amp; ...|hlegowa|    1|      uncle-anti|      t2_1671kp| t3_qy6qyo| 1637426552|
|The only theoreti...|hlea6bl|    1|           blorg|        t2_1vtw|t1_hldhxl2| 1637423712|
|You may pick up s...|hle5zg1|    1|       kpidhayny|      t2_16p94e|t1_hldorxw| 1637421859|
|           [removed]|hle5gbi|    1|       [deleted]|           null|t1_hlcae4y| 1637421613|
|           [removed]|hle5cn0|    1|       [deleted]|           null|t1_hlate7l| 1637421566|
|Hidizs s3 pro is ...|hle572b|    1|       DanielINH|    t2_3ryr524q| t3_qy11gh| 1637421494|
|Remove the profil...|hle4fdu|    1|     rhinosteveo|       t2_pm6j0|t1_hld3x73| 1637421136|
|   Try Maggot Brain.|hle4b1w|    1| steppingstone01|       t2_dva92| t3_qy6qyo| 1637421081|
|Haven't heard any...|hle26oy|    1|      Amazonkers|       t2_phk14|t1_hlc2dwg| 1637420064|
|I don't think the...|hle0wy3|    1|harshvpandey101x|    t2_601jukxb| t3_qy6qyo| 1637419446|
|No, because bluet...|hldzx6d|    1|  -GandalfTheGay|    t2_fjji5eq6| t3_qy300w| 1637418953|
|iFi Zen DAC V2 - ...|hldz5us|    1|       watanabe0|    t2_ar2h4acy| t3_qy11gh| 1637418562|
|I don’t recall ha...|hldwcrq|    1|        CryptixI|     t2_4ydnp5m| t3_qxzi2p| 1637417075|
|I would imagine t...|hldw0h7|    1|        CryptixI|     t2_4ydnp5m| t3_qxyghn| 1637416886|
|I don’t think we ...|hldtr2x|    1|           swsko|       t2_ypvhg|t1_hldsfoq| 1637415612|
|It will not make ...|hldt4b1|    1|    RealOstrich1|    t2_5rrxpfwu|t1_hldhxl2| 1637415234|
|mqa files on tida...|hldsfoq|    1|            h0su|       t2_bzs16| t3_qy3bhq| 1637414827|
|YEAAH MAN THIS AN...|hldoyrb|    1|        Jalis812|     t2_fntt3t6| t3_qww6vi| 1637412623|
|I’ve tested it on...|hldorxw|    1|  bogdansavianu2|    t2_2jcceml7|t1_hldo4tf| 1637412495|
|Yeah, you really ...|hldoch1|    1|       kpidhayny|      t2_16p94e|t1_hldjzf4| 1637412213|
+--------------------+-------+-----+----------------+---------------+----------+-----------+
only showing top 20 rows

21/11/21 00:55:16 INFO InMemoryFileIndex: It took 0 ms to list leaf files for 1 paths.
21/11/21 00:55:16 INFO InMemoryFileIndex: It took 1 ms to list leaf files for 1 paths.
21/11/21 00:55:16 INFO FileSourceStrategy: Pruning directories with:
21/11/21 00:55:16 INFO FileSourceStrategy: Pushed Filters:
21/11/21 00:55:16 INFO FileSourceStrategy: Post-Scan Filters:
21/11/21 00:55:16 INFO FileSourceStrategy: Output Data Schema: struct<value: string>
21/11/21 00:55:16 INFO MemoryStore: Block broadcast_4 stored as values in memory (estimated size 284.8 KiB, free 365.7 MiB)
21/11/21 00:55:16 INFO MemoryStore: Block broadcast_4_piece0 stored as bytes in memory (estimated size 23.9 KiB, free 365.7 MiB)
21/11/21 00:55:16 INFO BlockManagerInfo: Added broadcast_4_piece0 in memory on 192.168.0.226:50561 (size: 23.9 KiB, free: 366.2 MiB)
21/11/21 00:55:16 INFO SparkContext: Created broadcast 4 from json at DFBuilder.scala:9
21/11/21 00:55:16 INFO FileSourceScanExec: Planning scan with bin packing, max size: 4194304 bytes, open cost is considered as scanning 4194304 bytes.
21/11/21 00:55:16 INFO SparkContext: Starting job: json at DFBuilder.scala:9
21/11/21 00:55:16 INFO DAGScheduler: Got job 2 (json at DFBuilder.scala:9) with 1 output partitions
21/11/21 00:55:16 INFO DAGScheduler: Final stage: ResultStage 2 (json at DFBuilder.scala:9)
21/11/21 00:55:16 INFO DAGScheduler: Parents of final stage: List()
21/11/21 00:55:16 INFO DAGScheduler: Missing parents: List()
21/11/21 00:55:16 INFO DAGScheduler: Submitting ResultStage 2 (MapPartitionsRDD[11] at json at DFBuilder.scala:9), which has no missing parents
21/11/21 00:55:16 INFO MemoryStore: Block broadcast_5 stored as values in memory (estimated size 11.9 KiB, free 365.7 MiB)
21/11/21 00:55:16 INFO MemoryStore: Block broadcast_5_piece0 stored as bytes in memory (estimated size 6.2 KiB, free 365.7 MiB)
21/11/21 00:55:16 INFO BlockManagerInfo: Added broadcast_5_piece0 in memory on 192.168.0.226:50561 (size: 6.2 KiB, free: 366.2 MiB)
21/11/21 00:55:16 INFO SparkContext: Created broadcast 5 from broadcast at DAGScheduler.scala:1200
21/11/21 00:55:16 INFO DAGScheduler: Submitting 1 missing tasks from ResultStage 2 (MapPartitionsRDD[11] at json at DFBuilder.scala:9) (first 15 tasks are for partitions Vector(0))
21/11/21 00:55:16 INFO TaskSchedulerImpl: Adding task set 2.0 with 1 tasks
21/11/21 00:55:16 INFO TaskSetManager: Starting task 0.0 in stage 2.0 (TID 2, 192.168.0.226, executor driver, partition 0, PROCESS_LOCAL, 7771 bytes)
21/11/21 00:55:16 INFO Executor: Running task 0.0 in stage 2.0 (TID 2)
21/11/21 00:55:16 INFO FileScanRDD: Reading File path: file:///Users/yennanliu/RedditScrapper/data/raw/2021-11-21/submission.json, range: 0-406326, partition values: [empty row]
21/11/21 00:55:16 INFO Executor: Finished task 0.0 in stage 2.0 (TID 2). 5186 bytes result sent to driver
21/11/21 00:55:16 INFO TaskSetManager: Finished task 0.0 in stage 2.0 (TID 2) in 82 ms on 192.168.0.226 (executor driver) (1/1)
21/11/21 00:55:16 INFO TaskSchedulerImpl: Removed TaskSet 2.0, whose tasks have all completed, from pool
21/11/21 00:55:16 INFO DAGScheduler: ResultStage 2 (json at DFBuilder.scala:9) finished in 0.088 s
21/11/21 00:55:16 INFO DAGScheduler: Job 2 is finished. Cancelling potential speculative or zombie tasks for this job
21/11/21 00:55:16 INFO TaskSchedulerImpl: Killing all running tasks in stage 2: Stage finished
21/11/21 00:55:16 INFO DAGScheduler: Job 2 finished: json at DFBuilder.scala:9, took 0.092071 s
21/11/21 00:55:16 INFO FileSourceStrategy: Pruning directories with:
21/11/21 00:55:16 INFO FileSourceStrategy: Pushed Filters:
21/11/21 00:55:16 INFO FileSourceStrategy: Post-Scan Filters:
21/11/21 00:55:16 INFO FileSourceStrategy: Output Data Schema: struct<author: string, author_fullname: string, created_utc: bigint, id: string, link_flair_text: string ... 9 more fields>
21/11/21 00:55:16 INFO CodeGenerator: Code generated in 21.168414 ms
21/11/21 00:55:16 INFO MemoryStore: Block broadcast_6 stored as values in memory (estimated size 284.8 KiB, free 365.4 MiB)
21/11/21 00:55:16 INFO MemoryStore: Block broadcast_6_piece0 stored as bytes in memory (estimated size 23.9 KiB, free 365.4 MiB)
21/11/21 00:55:16 INFO BlockManagerInfo: Added broadcast_6_piece0 in memory on 192.168.0.226:50561 (size: 23.9 KiB, free: 366.2 MiB)
21/11/21 00:55:16 INFO SparkContext: Created broadcast 6 from show at Processor.scala:46
21/11/21 00:55:16 INFO FileSourceScanExec: Planning scan with bin packing, max size: 4194304 bytes, open cost is considered as scanning 4194304 bytes.
21/11/21 00:55:16 INFO SparkContext: Starting job: show at Processor.scala:46
21/11/21 00:55:16 INFO DAGScheduler: Got job 3 (show at Processor.scala:46) with 1 output partitions
21/11/21 00:55:16 INFO DAGScheduler: Final stage: ResultStage 3 (show at Processor.scala:46)
21/11/21 00:55:16 INFO DAGScheduler: Parents of final stage: List()
21/11/21 00:55:16 INFO DAGScheduler: Missing parents: List()
21/11/21 00:55:16 INFO DAGScheduler: Submitting ResultStage 3 (MapPartitionsRDD[15] at show at Processor.scala:46), which has no missing parents
21/11/21 00:55:16 INFO MemoryStore: Block broadcast_7 stored as values in memory (estimated size 15.9 KiB, free 365.3 MiB)
21/11/21 00:55:16 INFO MemoryStore: Block broadcast_7_piece0 stored as bytes in memory (estimated size 6.9 KiB, free 365.3 MiB)
21/11/21 00:55:16 INFO BlockManagerInfo: Added broadcast_7_piece0 in memory on 192.168.0.226:50561 (size: 6.9 KiB, free: 366.2 MiB)
21/11/21 00:55:16 INFO SparkContext: Created broadcast 7 from broadcast at DAGScheduler.scala:1200
21/11/21 00:55:16 INFO DAGScheduler: Submitting 1 missing tasks from ResultStage 3 (MapPartitionsRDD[15] at show at Processor.scala:46) (first 15 tasks are for partitions Vector(0))
21/11/21 00:55:16 INFO TaskSchedulerImpl: Adding task set 3.0 with 1 tasks
21/11/21 00:55:16 INFO TaskSetManager: Starting task 0.0 in stage 3.0 (TID 3, 192.168.0.226, executor driver, partition 0, PROCESS_LOCAL, 7771 bytes)
21/11/21 00:55:16 INFO Executor: Running task 0.0 in stage 3.0 (TID 3)
21/11/21 00:55:16 INFO FileScanRDD: Reading File path: file:///Users/yennanliu/RedditScrapper/data/raw/2021-11-21/submission.json, range: 0-406326, partition values: [empty row]
21/11/21 00:55:16 INFO CodeGenerator: Code generated in 12.809829 ms
21/11/21 00:55:16 INFO Executor: Finished task 0.0 in stage 3.0 (TID 3). 26359 bytes result sent to driver
21/11/21 00:55:16 INFO TaskSetManager: Finished task 0.0 in stage 3.0 (TID 3) in 37 ms on 192.168.0.226 (executor driver) (1/1)
21/11/21 00:55:16 INFO TaskSchedulerImpl: Removed TaskSet 3.0, whose tasks have all completed, from pool
21/11/21 00:55:16 INFO DAGScheduler: ResultStage 3 (show at Processor.scala:46) finished in 0.043 s
21/11/21 00:55:16 INFO DAGScheduler: Job 3 is finished. Cancelling potential speculative or zombie tasks for this job
21/11/21 00:55:16 INFO TaskSchedulerImpl: Killing all running tasks in stage 3: Stage finished
21/11/21 00:55:16 INFO DAGScheduler: Job 3 finished: show at Processor.scala:46, took 0.046638 s
21/11/21 00:55:16 INFO CodeGenerator: Code generated in 13.985114 ms
+--------------------+--------------------+------+------------+------------+---------------+-----+-----------+--------------------+---------------+------------+
|               title|            selftext|    id|upvote_ratio|num_comments|link_flair_text|score|created_utc|              author|author_fullname|retrieved_on|
+--------------------+--------------------+------+------------+------------+---------------+-----+-----------+--------------------+---------------+------------+
|[h] Over 6500 ord...|All accounts have...|qy9d2d|         1.0|           0|           null|    1| 1637426497|      DeepAmoeba6593|    t2_drk7ys57|  1637426507|
|[H] Affordable Hi...|Remember, All acc...|qy9cw5|         1.0|           0|           null|    1| 1637426481|        Intsikwakang|    t2_afkwmv1u|  1637426492|
|[h] Over 6500 ord...|All accounts have...|qy9clo|         1.0|           1|           null|    1| 1637426460|      DeepAmoeba6593|    t2_drk7ys57|  1637426471|
|[h] Over 6500 ord...|All accounts have...|qy9c5y|         1.0|           0|           null|    1| 1637426423|      DeepAmoeba6593|    t2_drk7ys57|  1637426434|
|[h] Over 6500 ord...|All accounts have...|qy9brf|         1.0|           0|           null|    1| 1637426391|      DeepAmoeba6593|    t2_drk7ys57|  1637426403|
|[h] Over 6500 ord...|All accounts have...|qy9bb4|         1.0|           0|           null|    1| 1637426355|      DeepAmoeba6593|    t2_drk7ys57|  1637426367|
|[h] Over 6500 ord...|All accounts have...|qy9aye|         1.0|           0|           null|    1| 1637426325|      DeepAmoeba6593|    t2_drk7ys57|  1637426337|
|[h] Over 6500 ord...|All accounts have...|qy9ah0|         1.0|           0|           null|    1| 1637426287|      DeepAmoeba6593|    t2_drk7ys57|  1637426298|
|[H] Affordable Hi...|Remember, All acc...|qy8z6w|         1.0|           0|           null|    1| 1637425369|        Intsikwakang|    t2_afkwmv1u|  1637425380|
|Should I go from ...|Hi. I'm currently...|qy8fh8|         1.0|           0| Audio Quality |    1| 1637423797|              maawen|       t2_hz0go|  1637423809|
|Playlist with all...|Is there a workar...|qy7om0|         1.0|           0|       Question|    1| 1637421585|             aarbron|       t2_6pgin|  1637421596|
|[1S1D Store] [H] ...|           [removed]|qy7k1x|         1.0|           0|           null|    1| 1637421177|     catalog6trcyhyt|    t2_aodainie|  1637421188|
|DNA DUO BEATS on ...|Check out my musi...|qy7d7s|         1.0|           0|           null|    1| 1637420619|         DNADUOBeats|    t2_8rvcxh4x|  1637420630|
|DNA DUO BEATS on ...|Check out my musi...|qy7d6u|         1.0|           0|           null|    1| 1637420616|         DNADUOBeats|    t2_8rvcxh4x|  1637420627|
|[PC] [H] Small sh...|tw subzero -3100
...|qy6axq|         1.0|           0|        :PC: PC|    1| 1637417269|       Doddleboddlle|    t2_595cau9w|  1637417280|
|Tidal hifi va hif...|So I’m currently ...|qy3bhq|         1.0|           0|       Question|    1| 1637405972|               swsko|       t2_ypvhg|  1637405983|
|[PSN] [H] a long ...|Will considers it...|qy3b5f|         1.0|           0|      :psn: PSN|    1| 1637405929|             sujannn|    t2_3yynilbd|  1637405940|
|Is TidaL Hi-Fi wo...|I get this stream...|qy300w|         1.0|           0|       Question|    1| 1637404554|   smoothslappyhours|      t2_14ttlq|  1637404565|
|[H] GRAB A PACKAG...|           [removed]|qy2x42|         1.0|           0|           null|    1| 1637404216|            AnoAvraz|    t2_2rrcpukj|  1637404228|
|[H] Guide written...|You can purchase ...|qy2r03|         1.0|           0|           null|    1| 1637403439|Jumbled_Instruction_|    t2_8fdiyeu5|  1637403450|
+--------------------+--------------------+------+------------+------------+---------------+-----+-----------+--------------------+---------------+------------+
only showing top 20 rows

21/11/21 00:55:16 INFO FileSourceStrategy: Pruning directories with:
21/11/21 00:55:16 INFO FileSourceStrategy: Pushed Filters:
21/11/21 00:55:16 INFO FileSourceStrategy: Post-Scan Filters:
21/11/21 00:55:16 INFO FileSourceStrategy: Output Data Schema: struct<author: string, author_fullname: string, body: string, created_utc: bigint, id: string ... 5 more fields>
21/11/21 00:55:16 INFO ParquetFileFormat: Using default output committer for Parquet: org.apache.parquet.hadoop.ParquetOutputCommitter
21/11/21 00:55:16 INFO FileOutputCommitter: File Output Committer Algorithm version is 1
21/11/21 00:55:16 INFO SQLHadoopMapReduceCommitProtocol: Using user defined output committer class org.apache.parquet.hadoop.ParquetOutputCommitter
21/11/21 00:55:16 INFO FileOutputCommitter: File Output Committer Algorithm version is 1
21/11/21 00:55:16 INFO SQLHadoopMapReduceCommitProtocol: Using output committer class org.apache.parquet.hadoop.ParquetOutputCommitter
21/11/21 00:55:17 INFO CodeGenerator: Code generated in 10.383247 ms
21/11/21 00:55:17 INFO MemoryStore: Block broadcast_8 stored as values in memory (estimated size 284.8 KiB, free 365.1 MiB)
21/11/21 00:55:17 INFO BlockManagerInfo: Removed broadcast_2_piece0 on 192.168.0.226:50561 in memory (size: 23.9 KiB, free: 366.2 MiB)
21/11/21 00:55:17 INFO BlockManagerInfo: Removed broadcast_6_piece0 on 192.168.0.226:50561 in memory (size: 23.9 KiB, free: 366.3 MiB)
21/11/21 00:55:17 INFO BlockManagerInfo: Removed broadcast_7_piece0 on 192.168.0.226:50561 in memory (size: 6.9 KiB, free: 366.3 MiB)
21/11/21 00:55:17 INFO MemoryStore: Block broadcast_8_piece0 stored as bytes in memory (estimated size 23.9 KiB, free 365.7 MiB)
21/11/21 00:55:17 INFO BlockManagerInfo: Added broadcast_8_piece0 in memory on 192.168.0.226:50561 (size: 23.9 KiB, free: 366.2 MiB)
21/11/21 00:55:17 INFO BlockManagerInfo: Removed broadcast_3_piece0 on 192.168.0.226:50561 in memory (size: 6.4 KiB, free: 366.2 MiB)
21/11/21 00:55:17 INFO SparkContext: Created broadcast 8 from parquet at Processor.scala:50
21/11/21 00:55:17 INFO FileSourceScanExec: Planning scan with bin packing, max size: 4194304 bytes, open cost is considered as scanning 4194304 bytes.
21/11/21 00:55:17 INFO BlockManagerInfo: Removed broadcast_4_piece0 on 192.168.0.226:50561 in memory (size: 23.9 KiB, free: 366.3 MiB)
21/11/21 00:55:17 INFO BlockManagerInfo: Removed broadcast_5_piece0 on 192.168.0.226:50561 in memory (size: 6.2 KiB, free: 366.3 MiB)
21/11/21 00:55:17 INFO SparkContext: Starting job: parquet at Processor.scala:50
21/11/21 00:55:17 INFO DAGScheduler: Got job 4 (parquet at Processor.scala:50) with 1 output partitions
21/11/21 00:55:17 INFO DAGScheduler: Final stage: ResultStage 4 (parquet at Processor.scala:50)
21/11/21 00:55:17 INFO DAGScheduler: Parents of final stage: List()
21/11/21 00:55:17 INFO DAGScheduler: Missing parents: List()
21/11/21 00:55:17 INFO DAGScheduler: Submitting ResultStage 4 (MapPartitionsRDD[18] at parquet at Processor.scala:50), which has no missing parents
21/11/21 00:55:17 INFO MemoryStore: Block broadcast_9 stored as values in memory (estimated size 155.1 KiB, free 365.8 MiB)
21/11/21 00:55:17 INFO MemoryStore: Block broadcast_9_piece0 stored as bytes in memory (estimated size 55.6 KiB, free 365.8 MiB)
21/11/21 00:55:17 INFO BlockManagerInfo: Added broadcast_9_piece0 in memory on 192.168.0.226:50561 (size: 55.6 KiB, free: 366.2 MiB)
21/11/21 00:55:17 INFO SparkContext: Created broadcast 9 from broadcast at DAGScheduler.scala:1200
21/11/21 00:55:17 INFO DAGScheduler: Submitting 1 missing tasks from ResultStage 4 (MapPartitionsRDD[18] at parquet at Processor.scala:50) (first 15 tasks are for partitions Vector(0))
21/11/21 00:55:17 INFO TaskSchedulerImpl: Adding task set 4.0 with 1 tasks
21/11/21 00:55:17 INFO TaskSetManager: Starting task 0.0 in stage 4.0 (TID 4, 192.168.0.226, executor driver, partition 0, PROCESS_LOCAL, 7768 bytes)
21/11/21 00:55:17 INFO Executor: Running task 0.0 in stage 4.0 (TID 4)
21/11/21 00:55:17 INFO FileOutputCommitter: File Output Committer Algorithm version is 1
21/11/21 00:55:17 INFO SQLHadoopMapReduceCommitProtocol: Using user defined output committer class org.apache.parquet.hadoop.ParquetOutputCommitter
21/11/21 00:55:17 INFO FileOutputCommitter: File Output Committer Algorithm version is 1
21/11/21 00:55:17 INFO SQLHadoopMapReduceCommitProtocol: Using output committer class org.apache.parquet.hadoop.ParquetOutputCommitter
21/11/21 00:55:17 INFO CodecConfig: Compression: SNAPPY
21/11/21 00:55:17 INFO CodecConfig: Compression: SNAPPY
21/11/21 00:55:17 INFO ParquetOutputFormat: Parquet block size to 134217728
21/11/21 00:55:17 INFO ParquetOutputFormat: Parquet page size to 1048576
21/11/21 00:55:17 INFO ParquetOutputFormat: Parquet dictionary page size to 1048576
21/11/21 00:55:17 INFO ParquetOutputFormat: Dictionary is on
21/11/21 00:55:17 INFO ParquetOutputFormat: Validation is off
21/11/21 00:55:17 INFO ParquetOutputFormat: Writer version is: PARQUET_1_0
21/11/21 00:55:17 INFO ParquetOutputFormat: Maximum row group padding size is 8388608 bytes
21/11/21 00:55:17 INFO ParquetOutputFormat: Page size checking is: estimated
21/11/21 00:55:17 INFO ParquetOutputFormat: Min row count for page size check is: 100
21/11/21 00:55:17 INFO ParquetOutputFormat: Max row count for page size check is: 10000
21/11/21 00:55:17 INFO ParquetWriteSupport: Initialized Parquet WriteSupport with Catalyst schema:
{
  "type" : "struct",
  "fields" : [ {
    "name" : "body",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "id",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "score",
    "type" : "long",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "author",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "author_fullname",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "parent_id",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "created_utc",
    "type" : "long",
    "nullable" : true,
    "metadata" : { }
  } ]
}
and corresponding Parquet message type:
message spark_schema {
  optional binary body (UTF8);
  optional binary id (UTF8);
  optional int64 score;
  optional binary author (UTF8);
  optional binary author_fullname (UTF8);
  optional binary parent_id (UTF8);
  optional int64 created_utc;
}


21/11/21 00:55:17 INFO CodecPool: Got brand-new compressor [.snappy]
21/11/21 00:55:17 INFO FileScanRDD: Reading File path: file:///Users/yennanliu/RedditScrapper/data/raw/2021-11-21/comment.json, range: 0-70690, partition values: [empty row]
21/11/21 00:55:17 INFO InternalParquetRecordWriter: Flushing mem columnStore to file. allocated memory: 6596
21/11/21 00:55:17 INFO FileOutputCommitter: Saved output of task 'attempt_20211121005517_0004_m_000000_4' to file:/Users/yennanliu/RedditScrapper/data/output/2021-11-21/comment/_temporary/0/task_20211121005517_0004_m_000000
21/11/21 00:55:17 INFO SparkHadoopMapRedUtil: attempt_20211121005517_0004_m_000000_4: Committed
21/11/21 00:55:17 INFO Executor: Finished task 0.0 in stage 4.0 (TID 4). 2313 bytes result sent to driver
21/11/21 00:55:17 INFO TaskSetManager: Finished task 0.0 in stage 4.0 (TID 4) in 857 ms on 192.168.0.226 (executor driver) (1/1)
21/11/21 00:55:17 INFO TaskSchedulerImpl: Removed TaskSet 4.0, whose tasks have all completed, from pool
21/11/21 00:55:17 INFO DAGScheduler: ResultStage 4 (parquet at Processor.scala:50) finished in 0.888 s
21/11/21 00:55:17 INFO DAGScheduler: Job 4 is finished. Cancelling potential speculative or zombie tasks for this job
21/11/21 00:55:17 INFO TaskSchedulerImpl: Killing all running tasks in stage 4: Stage finished
21/11/21 00:55:17 INFO DAGScheduler: Job 4 finished: parquet at Processor.scala:50, took 0.893365 s
21/11/21 00:55:17 INFO FileFormatWriter: Write Job 0feb1cf5-071a-4acb-bb9f-3964993628f3 committed.
21/11/21 00:55:17 INFO FileFormatWriter: Finished processing stats for write job 0feb1cf5-071a-4acb-bb9f-3964993628f3.
21/11/21 00:55:18 INFO FileSourceStrategy: Pruning directories with:
21/11/21 00:55:18 INFO FileSourceStrategy: Pushed Filters:
21/11/21 00:55:18 INFO FileSourceStrategy: Post-Scan Filters:
21/11/21 00:55:18 INFO FileSourceStrategy: Output Data Schema: struct<author: string, author_fullname: string, created_utc: bigint, id: string, link_flair_text: string ... 9 more fields>
21/11/21 00:55:18 INFO ParquetFileFormat: Using default output committer for Parquet: org.apache.parquet.hadoop.ParquetOutputCommitter
21/11/21 00:55:18 INFO FileOutputCommitter: File Output Committer Algorithm version is 1
21/11/21 00:55:18 INFO SQLHadoopMapReduceCommitProtocol: Using user defined output committer class org.apache.parquet.hadoop.ParquetOutputCommitter
21/11/21 00:55:18 INFO FileOutputCommitter: File Output Committer Algorithm version is 1
21/11/21 00:55:18 INFO SQLHadoopMapReduceCommitProtocol: Using output committer class org.apache.parquet.hadoop.ParquetOutputCommitter
21/11/21 00:55:18 INFO CodeGenerator: Code generated in 11.409832 ms
21/11/21 00:55:18 INFO MemoryStore: Block broadcast_10 stored as values in memory (estimated size 284.8 KiB, free 365.5 MiB)
21/11/21 00:55:18 INFO MemoryStore: Block broadcast_10_piece0 stored as bytes in memory (estimated size 23.9 KiB, free 365.5 MiB)
21/11/21 00:55:18 INFO BlockManagerInfo: Added broadcast_10_piece0 in memory on 192.168.0.226:50561 (size: 23.9 KiB, free: 366.2 MiB)
21/11/21 00:55:18 INFO SparkContext: Created broadcast 10 from parquet at Processor.scala:51
21/11/21 00:55:18 INFO FileSourceScanExec: Planning scan with bin packing, max size: 4194304 bytes, open cost is considered as scanning 4194304 bytes.
21/11/21 00:55:18 INFO SparkContext: Starting job: parquet at Processor.scala:51
21/11/21 00:55:18 INFO DAGScheduler: Got job 5 (parquet at Processor.scala:51) with 1 output partitions
21/11/21 00:55:18 INFO DAGScheduler: Final stage: ResultStage 5 (parquet at Processor.scala:51)
21/11/21 00:55:18 INFO DAGScheduler: Parents of final stage: List()
21/11/21 00:55:18 INFO DAGScheduler: Missing parents: List()
21/11/21 00:55:18 INFO DAGScheduler: Submitting ResultStage 5 (MapPartitionsRDD[23] at parquet at Processor.scala:51), which has no missing parents
21/11/21 00:55:18 INFO MemoryStore: Block broadcast_11 stored as values in memory (estimated size 157.2 KiB, free 365.3 MiB)
21/11/21 00:55:18 INFO MemoryStore: Block broadcast_11_piece0 stored as bytes in memory (estimated size 56.1 KiB, free 365.3 MiB)
21/11/21 00:55:18 INFO BlockManagerInfo: Added broadcast_11_piece0 in memory on 192.168.0.226:50561 (size: 56.1 KiB, free: 366.1 MiB)
21/11/21 00:55:18 INFO SparkContext: Created broadcast 11 from broadcast at DAGScheduler.scala:1200
21/11/21 00:55:18 INFO DAGScheduler: Submitting 1 missing tasks from ResultStage 5 (MapPartitionsRDD[23] at parquet at Processor.scala:51) (first 15 tasks are for partitions Vector(0))
21/11/21 00:55:18 INFO TaskSchedulerImpl: Adding task set 5.0 with 1 tasks
21/11/21 00:55:18 INFO TaskSetManager: Starting task 0.0 in stage 5.0 (TID 5, 192.168.0.226, executor driver, partition 0, PROCESS_LOCAL, 7771 bytes)
21/11/21 00:55:18 INFO Executor: Running task 0.0 in stage 5.0 (TID 5)
21/11/21 00:55:18 INFO FileOutputCommitter: File Output Committer Algorithm version is 1
21/11/21 00:55:18 INFO SQLHadoopMapReduceCommitProtocol: Using user defined output committer class org.apache.parquet.hadoop.ParquetOutputCommitter
21/11/21 00:55:18 INFO FileOutputCommitter: File Output Committer Algorithm version is 1
21/11/21 00:55:18 INFO SQLHadoopMapReduceCommitProtocol: Using output committer class org.apache.parquet.hadoop.ParquetOutputCommitter
21/11/21 00:55:18 INFO CodecConfig: Compression: SNAPPY
21/11/21 00:55:18 INFO CodecConfig: Compression: SNAPPY
21/11/21 00:55:18 INFO ParquetOutputFormat: Parquet block size to 134217728
21/11/21 00:55:18 INFO ParquetOutputFormat: Parquet page size to 1048576
21/11/21 00:55:18 INFO ParquetOutputFormat: Parquet dictionary page size to 1048576
21/11/21 00:55:18 INFO ParquetOutputFormat: Dictionary is on
21/11/21 00:55:18 INFO ParquetOutputFormat: Validation is off
21/11/21 00:55:18 INFO ParquetOutputFormat: Writer version is: PARQUET_1_0
21/11/21 00:55:18 INFO ParquetOutputFormat: Maximum row group padding size is 8388608 bytes
21/11/21 00:55:18 INFO ParquetOutputFormat: Page size checking is: estimated
21/11/21 00:55:18 INFO ParquetOutputFormat: Min row count for page size check is: 100
21/11/21 00:55:18 INFO ParquetOutputFormat: Max row count for page size check is: 10000
21/11/21 00:55:18 INFO ParquetWriteSupport: Initialized Parquet WriteSupport with Catalyst schema:
{
  "type" : "struct",
  "fields" : [ {
    "name" : "title",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "selftext",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "id",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "upvote_ratio",
    "type" : "double",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "num_comments",
    "type" : "long",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "link_flair_text",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "score",
    "type" : "long",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "created_utc",
    "type" : "long",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "author",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "author_fullname",
    "type" : "string",
    "nullable" : true,
    "metadata" : { }
  }, {
    "name" : "retrieved_on",
    "type" : "long",
    "nullable" : true,
    "metadata" : { }
  } ]
}
and corresponding Parquet message type:
message spark_schema {
  optional binary title (UTF8);
  optional binary selftext (UTF8);
  optional binary id (UTF8);
  optional double upvote_ratio;
  optional int64 num_comments;
  optional binary link_flair_text (UTF8);
  optional int64 score;
  optional int64 created_utc;
  optional binary author (UTF8);
  optional binary author_fullname (UTF8);
  optional int64 retrieved_on;
}


21/11/21 00:55:18 INFO FileScanRDD: Reading File path: file:///Users/yennanliu/RedditScrapper/data/raw/2021-11-21/submission.json, range: 0-406326, partition values: [empty row]
21/11/21 00:55:18 INFO InternalParquetRecordWriter: Flushing mem columnStore to file. allocated memory: 42428
21/11/21 00:55:18 INFO FileOutputCommitter: Saved output of task 'attempt_20211121005518_0005_m_000000_5' to file:/Users/yennanliu/RedditScrapper/data/output/2021-11-21/submission/_temporary/0/task_20211121005518_0005_m_000000
21/11/21 00:55:18 INFO SparkHadoopMapRedUtil: attempt_20211121005518_0005_m_000000_5: Committed
21/11/21 00:55:18 INFO Executor: Finished task 0.0 in stage 5.0 (TID 5). 2270 bytes result sent to driver
21/11/21 00:55:18 INFO TaskSetManager: Finished task 0.0 in stage 5.0 (TID 5) in 72 ms on 192.168.0.226 (executor driver) (1/1)
21/11/21 00:55:18 INFO TaskSchedulerImpl: Removed TaskSet 5.0, whose tasks have all completed, from pool
21/11/21 00:55:18 INFO DAGScheduler: ResultStage 5 (parquet at Processor.scala:51) finished in 0.100 s
21/11/21 00:55:18 INFO DAGScheduler: Job 5 is finished. Cancelling potential speculative or zombie tasks for this job
21/11/21 00:55:18 INFO TaskSchedulerImpl: Killing all running tasks in stage 5: Stage finished
21/11/21 00:55:18 INFO DAGScheduler: Job 5 finished: parquet at Processor.scala:51, took 0.103066 s
21/11/21 00:55:18 INFO FileFormatWriter: Write Job e99ca36c-2c6f-482a-b412-2ad13ef3e62b committed.
21/11/21 00:55:18 INFO FileFormatWriter: Finished processing stats for write job e99ca36c-2c6f-482a-b412-2ad13ef3e62b.
21/11/21 00:55:18 INFO SparkContext: Invoking stop() from shutdown hook
21/11/21 00:55:18 INFO SparkUI: Stopped Spark web UI at http://192.168.0.226:4040
21/11/21 00:55:18 INFO MapOutputTrackerMasterEndpoint: MapOutputTrackerMasterEndpoint stopped!
21/11/21 00:55:18 INFO MemoryStore: MemoryStore cleared
21/11/21 00:55:18 INFO BlockManager: BlockManager stopped
21/11/21 00:55:18 INFO BlockManagerMaster: BlockManagerMaster stopped
21/11/21 00:55:18 INFO OutputCommitCoordinator$OutputCommitCoordinatorEndpoint: OutputCommitCoordinator stopped!
21/11/21 00:55:18 INFO SparkContext: Successfully stopped SparkContext
21/11/21 00:55:18 INFO ShutdownHookManager: Shutdown hook called
21/11/21 00:55:18 INFO ShutdownHookManager: Deleting directory /private/var/folders/51/3j6n8rwd74g2tsjt5jhcy91w0000gn/T/spark-60739b5c-1323-48db-aaef-3d17ef2b68ce
21/11/21 00:55:18 INFO ShutdownHookManager: Deleting directory /private/var/folders/51/3j6n8rwd74g2tsjt5jhcy91w0000gn/T/spark-e70ac22e-e7c1-403e-bdde-36421542c1d3
(dci_de) yennanliu@MacBook-Pro RedditScrapper %
```

### part 2) QA

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