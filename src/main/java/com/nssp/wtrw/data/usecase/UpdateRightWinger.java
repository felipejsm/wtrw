package com.nssp.wtrw.data.usecase;

import com.nssp.wtrw.data.dto.RightWingerDto;
import com.nssp.wtrw.data.model.RightWinger;

public interface UpdateRightWinger {
    RightWinger doUpdateWithDto(RightWingerDto dto);
}
