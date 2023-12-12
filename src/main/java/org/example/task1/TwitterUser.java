package org.example.task1;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TwitterUser {
    private String userMail;
    private String country;
    private LocalDateTime lastActiveTime;
}
