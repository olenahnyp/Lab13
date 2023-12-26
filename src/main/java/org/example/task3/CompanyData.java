package org.example.task3;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder @Setter @Getter
public class CompanyData {
    private String domain;
    private String description;
    private String logo;
    private String name;
}
