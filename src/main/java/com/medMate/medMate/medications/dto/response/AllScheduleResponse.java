package com.medMate.medMate.medications.dto.response;

import com.medMate.medMate.auth.dto.response.BaseResponse;
import com.medMate.medMate.medications.data.models.Medication;
import com.medMate.medMate.medications.data.models.MedicationSchedule;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class AllScheduleResponse extends BaseResponse {
    private List<MedicationSchedule> medicationSchedules;

    public AllScheduleResponse(boolean isSuccessful, int responseCode, String message, LocalDateTime timeStamp
            ,List<MedicationSchedule> medicationSchedules) {
        super(isSuccessful, responseCode, message, timeStamp);
        this.medicationSchedules =medicationSchedules;
    }
}
