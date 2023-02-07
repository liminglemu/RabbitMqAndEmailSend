package com.teak.core.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Email result enum.
 *
 * @author 柚mingle木
 * @version 1.0
 * @date 2023 /2/6
 */
@Getter
@AllArgsConstructor
public enum EmailResultEnum {
    /**
     * Success email result enum.
     */
    SUCCESS(200, "消息发送成功"),
    /**
     * Fail email result enum.
     */
    FAIL(400, "消息发送失败");

    private final Integer code;
    private final String message;
}
