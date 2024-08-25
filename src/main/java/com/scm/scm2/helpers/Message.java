package com.scm.scm2.helpers;

import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    private String content;
    @Builder.Default
    private MessageType type=MessageType.blue;
}
