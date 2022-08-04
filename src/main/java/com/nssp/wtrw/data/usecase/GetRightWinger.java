package com.nssp.wtrw.data.usecase;

import com.nssp.wtrw.data.dto.RightWingerDto;
import com.nssp.wtrw.data.model.RightWinger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GetRightWinger {
    Optional<RightWinger> doGetByIds(String name, String birthdate);

    Page<RightWinger> doGetListByDtoAndPage(RightWingerDto dto, Pageable page);
}
