package com.nssp.wtrw.data.usecase;

import com.nssp.wtrw.data.dto.RightWingerDto;
import com.nssp.wtrw.data.model.RightWinger;
import com.nssp.wtrw.data.model.RightWingerId;
import com.nssp.wtrw.data.repository.RightWingerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GetRightWingerImpl implements GetRightWinger {
    private RightWingerRepository repository;
    @Override
    public Optional<RightWinger> doGetByIds(String name, String birthdate) {
        var rightWingerId = new RightWingerId();
        rightWingerId.setBirthdate(LocalDate.parse(birthdate));
        rightWingerId.setName(name);
        return this.repository.findById(rightWingerId);
    }

    @Override
    public Page<RightWinger> doGetListByDtoAndPage(RightWingerDto dto, Pageable page) {
        var response = this.repository.getByDto(dto.getBio(),
                dto.getBirthdate().toString(),
                dto.getFullname(),
                dto.getGender(),
                dto.getHighlights(),
                dto.getName(),
                dto.getPhrases(),
                dto.getNetworth(),
                dto.getPicture(), page);
        return response;
    }
}
