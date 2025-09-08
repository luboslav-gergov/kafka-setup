Notes:
- We can start the consumer multiple times from the idea.(copy configuration from run configurations)
- If we have more than 1 partition when we start the second consumer, Kafka will rebalance the consumer groups and assign them partitions. Example. For consumer 1 - partition 0 and 2, for consumer 2 - partion 1
- Without the earliest property set, the consumer will not poll the previous messages stored when started and will poll only the newly produced ones.
- Practically, the earliest and the latest properties are important only when a new consumer is started or for uncommitted lost messages.
<img width="1244" height="579" alt="image" src="https://github.com/user-attachments/assets/5e5d0d81-2ff7-4285-a893-a5d2891f66ec" />
