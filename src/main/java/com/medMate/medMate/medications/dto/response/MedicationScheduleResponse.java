package com.medMate.medMate.medications.dto.response;

import com.medMate.medMate.auth.dto.response.BaseResponse;
import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.data.models.MedicationSchedule;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class MedicationScheduleResponse extends BaseResponse {
    private MedicationSchedule medicationSchedule;

    public MedicationScheduleResponse(boolean isSuccessful, int responseCode, String message, LocalDateTime timeStamp
            ,MedicationSchedule  medicationSchedule) {
        super(isSuccessful, responseCode, message, timeStamp);
        this.medicationSchedule =medicationSchedule;
    }

}
