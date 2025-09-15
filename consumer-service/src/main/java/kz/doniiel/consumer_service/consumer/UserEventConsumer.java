package kz.doniiel.consumer_service.consumer;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserEventConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "userdbserver.public.users", groupId = "user-consumer")
    public void consume(String message) throws IOException {
        var event = objectMapper.readTree(message);
        var after = event.get("after");
        if (after != null) {
            log.info("New User: id={}, name={}, email={}",
            after.get("id").asLong(),
            after.get("name").asText(),
            after.get("email").asText());
        }
    }
}
