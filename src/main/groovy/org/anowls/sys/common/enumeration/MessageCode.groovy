package org.anowls.sys.common.enumeration

enum MessageCode implements IMessageCodeEnum {
    SUCCESS(0, "成功"),
    NORMAL_ERROR(1, "普通错误"),
    SYS_ERROR(10000, "系统异常"),
    SERVICE_ERROR(20000, "业务异常"),
    OAUTH_ERROR(20001, "认证异常")

    private Integer key
    private String value

    private MessageCode(Integer key, String value) {
        this.key = key
        this.value = value
    }

    Integer getKey() {
        return this.key
    }

    String getValue() {
        return this.value
    }
}