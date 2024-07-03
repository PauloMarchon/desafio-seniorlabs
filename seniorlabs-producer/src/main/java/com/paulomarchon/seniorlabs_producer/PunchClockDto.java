package com.paulomarchon.seniorlabs_producer;

public record PunchClockDto(
        String includedAt,
        Integer employeeId,
        Integer employerId
) {
}
