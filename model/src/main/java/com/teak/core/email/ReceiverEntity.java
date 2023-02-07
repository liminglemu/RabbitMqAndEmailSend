package com.teak.core.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

/**
 * The type Receiver entity.
 *
 * @author 柚mingle木
 * @version 1.0
 * @date 2023 /2/5
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiverEntity {
    private String receiver;
    private String messageSubject;
    private String messageContent;
    private File[] files;
}
