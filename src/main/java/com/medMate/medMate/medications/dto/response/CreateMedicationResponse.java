package com.medMate.medMate.medications.dto.response;

import com.medMate.medMate.auth.dto.response.BaseResponse;
import com.medMate.medMate.medications.data.models.Medication;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class CreateMedicationResponse  extends BaseResponse {
    private Medication medication;

    public CreateMedicationResponse(boolean isSuccessful, int responseCode, String message, LocalDateTime timeStamp
            ,Medication  medication) {
        super(isSuccessful, responseCode, message, timeStamp);
        this.medication =medication;
    }
}
