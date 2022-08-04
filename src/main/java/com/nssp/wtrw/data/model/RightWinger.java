package com.nssp.wtrw.data.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "RightWinger")
@Table(name = "right_winger")
@IdClass(RightWingerId.class)
@Data
public class RightWinger {
    @Id
    @Column(nullable = false)
    private String name;

    @Id
    @Column(nullable = false)
    private LocalDate birthdate;

    private String fullname;
    private String phrases;
    private String gender;
    private String picture;
    private String highlights;
    private String networth;
    private String bio;

    public RightWinger setName(String name) {
        this.name = name;
        return this;
    }

    public RightWinger setBirthDate(LocalDate birthDate) {
        this.birthdate = birthDate;
        return this;
    }
}

