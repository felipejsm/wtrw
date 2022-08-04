package com.nssp.wtrw.data.usecase;

import com.nssp.wtrw.data.dto.RightWingerDto;
import com.nssp.wtrw.data.model.RightWinger;
import com.nssp.wtrw.data.repository.RightWingerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class CreateRightWingerImpl implements CreateRightWinger {

    private RightWingerRepository repository;

    @Override
    @Transactional
    public void doCreateWithDto(RightWingerDto dto) {
        var rightWingerToPersist = new RightWinger();
        BeanUtils.copyProperties(dto,rightWingerToPersist);
        rightWingerToPersist.setBirthDate(dto.getBirthdate());
        repository.save(rightWingerToPersist);
    }
}
