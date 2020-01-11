
# kafka

消息中间件的应用场景：先说一下消息队列的常见使用场景吧，其实场景有很多，但是比较核心的有3个：解耦、异步、削峰。举个非常简单的例子，就拿一个电商平台的注册功能来简单分析下，用
户注册这一个服务，不单单只是insert一条数据到数据库里面就完事了，还需要发送激活邮件、发送新
人红包或者积分、发送营销短信等一系列操作。假如说这里面的每一个操作，都需要消耗1s，那么整个
注册过程就需要耗时4s才能响应给用户。所以我们可以对这些子操作进行来实现异
步化执行，类似于多线程并行处理的概念。这个是分布式消息队列的第一个解决场景【异步处理】

![image](./iamges/异步处理流程图.png)




kafka的特点其实很明显，就是仅仅提供较少的核心功能，但是提供超高的吞吐量，ms级的延迟，极高的可用性以及可靠性，而且分布式可以任意扩展
同时kafka最好是支撑较少的topic数量即可，保证其超高吞吐量。



## 基础配置分析
### group.id

consumer group是kafka提供的可扩展且具有容错性的消费者机制。既然是一个组，那么组内必然可以
有多个消费者或消费者实例(consumer instance)，它们共享一个公共的ID，即group ID。组内的所有
消费者协调在一起来消费订阅主题(subscribed topics)的所有分区(partition)。当然，每个分区只能由
同一个消费组内的一个consumer来消费.


![image](./iamges/group.id图.png)
 
### enable.auto.commit
消费者消费消息以后自动提交，只有当消息提交以后，该消息才不会被再次接收到，还可以配合auto.commit.interval.ms控制自动提交的频率。
当然，我们也可以通过consumer.commitSync()的方式实现手动提交

### auto.offset.reset
这个参数是针对新的groupid中的消费者而言的，当有新groupid的消费者来消费指定的topic时，对于该参数的配置，会有不同的语义。
auto.offset.reset=latest情况下，新的消费者将会从其他消费者最后消费的offset处开始消费Topic下的消息。
auto.offset.reset= earliest情况下，新的消费者会从该topic最早的消息开始消费。
auto.offset.reset=none情况下，新的消费者加入以后，由于之前不存在offset，则会直接抛出异常。

### max.poll.records
此设置限制每次调用poll返回的消息数，这样可以更容易的预测每次poll间隔要处理的最大值。通过调整此值，可以减少poll间隔


## 关于Topic和Partition



## 消息分发机制


## 消息消费原理

## 分区分配策略

## 如何保存消费端的消费位置


## 分区的副本和选举机制

