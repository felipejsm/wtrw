package com.nssp.wtrw.data.entrypoint;

import com.nssp.wtrw.data.dto.RightWingerDto;
import com.nssp.wtrw.data.usecase.GetRightWinger;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class GetRightWingerController {
    private final GetRightWinger getRightWinger;

    @GetMapping("/get")
    public ResponseEntity<RightWingerDto> get(@RequestParam("birth_date") String birthDate,
                                              @RequestParam String name) {

        var rightWinger = getRightWinger.doGetByIds(name, birthDate);
        var response = rightWinger.orElse(null);
        if(response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        var dto = new RightWingerDto();
        BeanUtils.copyProperties(response, dto );
        return ResponseEntity.status(HttpStatus.FOUND).body(dto);
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<RightWingerDto>> getByFilter(@RequestBody RightWingerDto dto,
            @RequestParam Pageable page) {
        var response = this.getRightWinger.doGetListByDtoAndPage(dto, page);
        var emptyDto = new RightWingerDto();
        Page<RightWingerDto> responseDto = new PageImpl<>(List.of(emptyDto), page, 1);
        BeanUtils.copyProperties(response, responseDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
