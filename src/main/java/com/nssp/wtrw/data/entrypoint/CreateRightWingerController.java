package com.nssp.wtrw.data.entrypoint;

import com.nssp.wtrw.data.dto.RightWingerDto;
import com.nssp.wtrw.data.usecase.CreateRightWinger;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class CreateRightWingerController {

    private CreateRightWinger createRightWinger;

    @PostMapping("/create")
    public ResponseEntity<RightWingerDto> create(@RequestBody RightWingerDto body) {
        createRightWinger.doCreateWithDto(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }
}
