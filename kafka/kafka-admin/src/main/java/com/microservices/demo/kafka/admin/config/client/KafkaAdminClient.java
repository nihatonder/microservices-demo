package com.microservices.demo.kafka.admin.config.client;

import com.microservices.demo.config.KafkaConfigData;
import com.microservices.demo.config.RetryConfigData;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaAdminClient {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaAdminClient.class);

    private KafkaConfigData kafkaConfigData;

    private RetryConfigData retryConfigData;

    private AdminClient adminClient;

    private RetryTemplate retryTemplate;

    public KafkaAdminClient(KafkaConfigData config,
                            RetryConfigData retryConfigData,
                            AdminClient client,
                            RetryTemplate template) {
        this.kafkaConfigData = config;
        this.retryConfigData = retryConfigData;
        this.adminClient = client;
        this.retryTemplate = template;
    }

    public void createTopics() {
        CreateTopicsResult createTopicsResult;
        createTopicsResult = retryTemplate.execute(this::doCreateTopics);
    }

    private CreateTopicsResult doCreateTopics(RetryContext retryContext) {
        return null;
    }
}
