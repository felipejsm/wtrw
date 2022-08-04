package com.nssp.wtrw.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightWingerDto {
    private String name;
    private LocalDate birthdate;
    private String fullname;
    private String gender;
    private String picture;
    private String highlights;
    private String phrases;
    private String networth;
    private String bio;
}
