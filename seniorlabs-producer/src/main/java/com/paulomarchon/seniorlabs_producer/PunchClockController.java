package com.paulomarchon.seniorlabs_producer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clock")
public class PunchClockController {
    private final PunchClockProducer punchClockProducer;

    public PunchClockController(PunchClockProducer punchClockProducer) {
        this.punchClockProducer = punchClockProducer;
    }

    @PostMapping
    public void processPunchClock(@RequestBody PunchClockDto punchClockDto) {
        punchClockProducer.sendMessage(punchClockDto);
    }
}
