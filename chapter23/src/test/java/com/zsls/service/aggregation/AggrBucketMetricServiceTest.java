package com.zsls.service.aggregation;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class AggrBucketMetricServiceTest {

    @Autowired
    private AggrBucketMetricService aggrBucketMetricService;

    @Test
    void aggregationTopHits() {
        aggrBucketMetricService.aggregationTopHits();
    }
}