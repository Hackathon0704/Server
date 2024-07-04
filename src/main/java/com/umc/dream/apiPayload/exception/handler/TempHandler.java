package com.umc.dream.apiPayload.exception.handler;

import com.umc.dream.apiPayload.code.BaseErrorCode;
import com.umc.dream.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
