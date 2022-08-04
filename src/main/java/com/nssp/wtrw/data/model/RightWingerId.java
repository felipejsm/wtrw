package com.nssp.wtrw.data.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class RightWingerId implements Serializable {
    private String name;
    private LocalDate birthdate;

}
