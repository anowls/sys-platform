package org.anowls.sys.common.message

import org.anowls.sys.common.enumeration.IMessageCodeEnum
import org.anowls.sys.common.enumeration.MessageCode
import org.anowls.sys.common.enumeration.MessageLevel

class SimpleMessage extends BasicMessage {
    private String level
    private boolean showHits

    private SimpleMessage(IMessageCodeEnum code, Object data, MessageLevel level, String message, boolean showHits) {
        super(code, data, message)
        this.level = level.getKey()
        this.showHits = showHits
    }

    private SimpleMessage(IMessageCodeEnum code, MessageLevel level, String message, boolean showHits) {
        super(code, message)
        this.level = level.getKey()
        this.showHits = showHits
    }

    static SimpleMessage info(String message) {
        return new SimpleMessage(MessageCode.SUCCESS, MessageLevel.INFO, message, true)
    }

    static SimpleMessage info(String message, boolean showHits) {
        return new SimpleMessage(MessageCode.SUCCESS, MessageLevel.INFO, message, showHits)
    }

    static SimpleMessage info(Object data) {
        return new SimpleMessage(MessageCode.SUCCESS, data, MessageLevel.INFO, "", false)
    }

    static SimpleMessage info(String message, Object data) {
        return new SimpleMessage(MessageCode.SUCCESS, data, MessageLevel.INFO, message, true)
    }

    static SimpleMessage info(IMessageCodeEnum code, Object data) {
        return new SimpleMessage(code, data, MessageLevel.INFO, (String) code.getValue(), false)
    }

    static SimpleMessage warn(String message) {
        return new SimpleMessage(MessageCode.NORMAL_ERROR, MessageLevel.WARN, message, true)
    }

    static SimpleMessage warn(Object data) {
        return new SimpleMessage(MessageCode.NORMAL_ERROR, data, MessageLevel.WARN, "", false)
    }

    static SimpleMessage warn(IMessageCodeEnum code) {
        return new SimpleMessage(code, "", MessageLevel.WARN, (String) code.getValue(), true)
    }

    static SimpleMessage warn(String message, Object data) {
        return new SimpleMessage(MessageCode.NORMAL_ERROR, data, MessageLevel.WARN, message, true)
    }

    static SimpleMessage warn(IMessageCodeEnum code, Object data) {
        return new SimpleMessage(code, data, MessageLevel.WARN, (String) code.getValue(), true)
    }

    static SimpleMessage fail(String message) {
        return new SimpleMessage(MessageCode.SYS_ERROR, MessageLevel.FAIL, message, true)
    }

    static SimpleMessage fail(IMessageCodeEnum code) {
        return new SimpleMessage(code, MessageLevel.FAIL, (String) code.getValue(), true)
    }

    static SimpleMessage fail(IMessageCodeEnum code, String message) {
        return new SimpleMessage(code, MessageLevel.FAIL, message, true)
    }

    static SimpleMessage fail(IMessageCodeEnum code, Object data) {
        return new SimpleMessage(code, data, MessageLevel.FAIL, (String) code.getValue(), true)
    }

    static SimpleMessage fail(IMessageCodeEnum code, String message, Object data) {
        return new SimpleMessage(code, data, MessageLevel.FAIL, message, true)
    }

    String getLevel() {
        return this.level
    }

    boolean isShowHits() {
        return this.showHits
    }
}
