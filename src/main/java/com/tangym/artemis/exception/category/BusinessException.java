package com.tangym.artemis.exception.category;


import com.tangym.artemis.exception.error.details.BusinessErrorCode;
import com.tangym.artemis.exception.error.CommonErrorCode;

/**
 * {@link RuntimeException} 通用业务异常
 *
 * @author backtym@live.cn
 */
public class BusinessException extends RuntimeException {

    private final String code;
    private final boolean isShowMsg = true;

    public String getCode() {
        return code;
    }

    public boolean isShowMsg() {
        return isShowMsg;
    }

    /**
     * 使用枚举传参
     *
     * @param errorCode 异常枚举
     */
    public BusinessException(BusinessErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    /**
     * 使用CommonErrorCode枚举传参
     *
     * @param errorCode 异常枚举
     */
    public BusinessException(CommonErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    /**
     * 使用自定义消息
     *
     * @param code 值
     * @param msg  详情
     */
    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
    }

}
