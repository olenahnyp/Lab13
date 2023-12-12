package org.example.task1;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FacebookUser {
    private String email;
    private String userCountry;
    private LocalDateTime userActiveTime;
}
