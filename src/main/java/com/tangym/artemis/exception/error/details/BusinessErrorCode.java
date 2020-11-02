package com.tangym.artemis.exception.error.details;

/**
 * 业务通用异常枚举
 *
 * @author backtym@live.cn
 */
public enum BusinessErrorCode {

    /**
     * 通用业务异常
     */
    BUSINESS_ERROR("CLOUD800", "业务异常"),
    ;

    private final String code;

    private final String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    BusinessErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
