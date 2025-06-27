package com.scheduled;

import com.scheduled.task.ScheduledTask;
import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class ScheduledTasksTest {

    @MockitoSpyBean
    private ScheduledTask task;

    @Test
    public void reportCurrentTime(){
        await().atMost(Duration.TEN_SECONDS).untilAsserted(() -> {
            verify(task, atLeast(2)).reportCurrentTime();
        });
    }


}
