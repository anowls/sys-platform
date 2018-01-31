package org.anowls.sys.common.message

import org.anowls.sys.common.enumeration.IMessageCodeEnum

abstract class BasicMessage {
    private Object data
    private String message
    private IMessageCodeEnum code

    BasicMessage(IMessageCodeEnum code) {
        this.code = code
        this.data = ""
        this.message = (String) code.getValue()
    }

    BasicMessage(IMessageCodeEnum code, Object data) {
        this.code = code
        this.data = data
        this.message = (String) code.getValue()
    }

    BasicMessage(IMessageCodeEnum code, String message) {
        this.code = code
        this.data = ""
        this.message = message
    }

    BasicMessage(IMessageCodeEnum code, Object data, String message) {
        this.code = code
        this.data = data
        this.message = message
    }

    Integer getCode() {
        return (Integer) this.code.getKey()
    }

    Object getData() {
        return this.data
    }

    String getMessage() {
        return this.message
    }
}
