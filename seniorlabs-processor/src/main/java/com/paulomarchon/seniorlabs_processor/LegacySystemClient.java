package com.paulomarchon.seniorlabs_processor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "legacy-system",
        url = "${client.legacy-system.url}"
)
public interface LegacySystemClient {

    @PostMapping
    ResponseEntity<LegacySystemResponse> sendToLegacySystem(@RequestBody PunchClockDto punchClockDto);
}
