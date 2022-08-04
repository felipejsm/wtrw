package com.nssp.wtrw.usecase;

import com.nssp.wtrw.data.dto.RightWingerDto;
import com.nssp.wtrw.data.model.RightWinger;
import com.nssp.wtrw.data.model.RightWingerId;
import com.nssp.wtrw.data.repository.RightWingerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CreateRightWingerDtoTest {

    RightWingerDto rightWingerDto;
    RightWinger rightWinger;
    @Autowired
    RightWingerRepository repository;
    @BeforeEach
    void setup() {
        rightWinger = new RightWinger();
        rightWinger.setBirthDate(LocalDate.of(1984, 1, 15));
        rightWinger.setName("Ben Shapiro");
        rightWinger.setBio("""
                        Benjamin Aaron Shapiro is an American conservative political commentator,media host, attorney, and columnist. 
                        At age 17, he became the youngest nationally syndicated columnist in the United States.
                        """);
        rightWinger.setNetworth("20 millions dollars");
        rightWinger.setHighlights("https://www.youtube.com/watch?v=X9FGRkqUdf8");
        rightWinger.setGender("male");
        rightWinger.setFullname("Benjamin Aaron Shapiro");
        rightWinger.setPicture("ben.jpg");
    }

    @Test
    @DisplayName("Create a right winger")
    void should_create_a_right_winger_dto() {
        rightWingerDto = new RightWingerDto(
            "Ben Shapiro",
                LocalDate.of(1984, 1, 15),
                "Benjamin Aaron Shapiro",
                "male",
                "ben.jpg",
                "https://www.youtube.com/watch?v=X9FGRkqUdf8",
                "20 millions dollars",
                "21763",
                """
                        Benjamin Aaron Shapiro is an American conservative political commentator,media host, attorney, and columnist. 
                        At age 17, he became the youngest nationally syndicated columnist in the United States.
                        """);
        Assertions.assertNotNull(rightWingerDto.toString());

    }

    @Test
    void should_persist_a_right_winger() {
        var result = this.repository.save(rightWinger);
        Assertions.assertNotNull(result);
    }

    @Test
    void should_get_any_right_winger() {
        this.repository.save(rightWinger);
        var op = this.repository.findOne(Example.of(rightWinger));
        Assertions.assertNotNull(op.get());

    }

    @Test
    void should_get_right_winger_by_name_and_birthdate() {
        this.repository.save(rightWinger);
        RightWingerId rightWingerId = new RightWingerId();
        rightWingerId.setName(this.rightWinger.getName());
        rightWingerId.setBirthdate(this.rightWinger.getBirthdate());
        var op = this.repository.findById(rightWingerId);
        Assertions.assertTrue(op.isPresent());
    }

    @Test
    void should_not_get_right_winger_by_name_and_birthdate() {
        this.repository.save(rightWinger);
        RightWingerId rightWingerId = new RightWingerId();
        rightWingerId.setName("Ben Shabibo");
        rightWingerId.setBirthdate(this.rightWinger.getBirthdate());
        var op = this.repository.findById(rightWingerId);
        Assertions.assertFalse(op.isPresent());
    }

    @Test
    void should_delete_right_winger() {
        this.repository.save(rightWinger);
        this.repository.delete(rightWinger);
        RightWingerId rightWingerId = new RightWingerId();
        rightWingerId.setName(this.rightWinger.getName());
        rightWingerId.setBirthdate(this.rightWinger.getBirthdate());
        var op = this.repository.findById(rightWingerId);
        Assertions.assertFalse(op.isPresent());
    }

    @Test
    void should_update_right_winger() {
        this.repository.save(rightWinger);
        rightWinger.setNetworth("21 millions dollars");
        this.repository.save(rightWinger);
        RightWingerId rightWingerId = new RightWingerId();
        rightWingerId.setName(this.rightWinger.getName());
        rightWingerId.setBirthdate(this.rightWinger.getBirthdate());
        var op = this.repository.findById(rightWingerId);
        Assertions.assertEquals(op.get().getNetworth(), "21 millions dollars");
    }

    @Test
    void should_raise_exception() {
        RightWinger almostSameRightWinger = new RightWinger();
        almostSameRightWinger.setName(rightWinger.getName());
        almostSameRightWinger.setBirthDate(rightWinger.getBirthdate());
        almostSameRightWinger.setBio("Whatever");
        almostSameRightWinger.setPicture("xoxo.gif");
        almostSameRightWinger.setFullname("Someone Else With Same Id");
        this.repository.save(rightWinger);
        this.repository.save(almostSameRightWinger);

        RightWingerId rightWingerId = new RightWingerId();
        rightWingerId.setName(this.rightWinger.getName());
        rightWingerId.setBirthdate(this.rightWinger.getBirthdate());

        this.repository.findById(rightWingerId);
    }
}
