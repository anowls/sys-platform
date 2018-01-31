package org.anowls.sys.common.enumeration

import org.anowls.sys.common.IEnum

enum MessageLevel implements IEnum<String, String> {

    INFO("info", "普通消息"),
    WARN("warn", "警告消息"),
    FAIL("fail", "失败消息")

    private String key
    private String value

    private MessageLevel(String key, String value) {
        this.key = key
        this.value = value
    }

    String getKey() {
        return this.key
    }

    String getValue() {
        return this.value
    }
}