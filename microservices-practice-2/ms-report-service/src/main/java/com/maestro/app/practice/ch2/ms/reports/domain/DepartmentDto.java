package com.maestro.app.practice.ch2.ms.reports.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private long id;
    private String deptNum;
    private String name;
}
