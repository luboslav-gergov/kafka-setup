Notes:
- We can start the consumer multiple times from the idea.(copy configuration from run configurations)
- If we have more than 1 partition when we start the second consumer, Kafka will rebalance the consumer groups and assign them partitions. Example. For consumer 1 - partition 0 and 2, for consumer 2 - partion 1
- Without the earliest property set, the consumer will not poll the previous messages stored when started and will poll only the newly produced ones.
