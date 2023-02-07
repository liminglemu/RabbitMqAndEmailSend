package com.teak.core.result;

import lombok.Data;

/**
 * The type Email result.
 *
 * @param <T> the type parameter
 * @author 柚mingle木
 * @version 1.0
 * @date 2023 /2/6
 */
@Data
public class EmailResult<T> {

    private Integer code;
    private String message;
    private T data;

    /**
     * Instantiates a new Email result.
     *
     * @param emailResultEnum the email result enum
     * @param data            the data
     */
    public EmailResult(EmailResultEnum emailResultEnum, T data) {
        this.code = emailResultEnum.getCode();
        this.message = emailResultEnum.getMessage();
        this.data = data;
    }
}
