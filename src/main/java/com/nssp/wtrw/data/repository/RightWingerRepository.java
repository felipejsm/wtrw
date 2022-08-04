package com.nssp.wtrw.data.repository;

import com.nssp.wtrw.data.model.RightWinger;
import com.nssp.wtrw.data.model.RightWingerId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RightWingerRepository extends JpaRepository<RightWinger, RightWingerId> {

    @Query("select  r"
    +" from RightWinger r"
    +" where (r.bio is null or r.bio = ?1) and "
    +" (r.birthdate is null or r.birthdate = ?2) and "
    +" (r.fullname is null or r.fullname = ?3) and "
    +" (r.gender is null or r.gender = ?4) and "
    +" (r.highlights is null or r.highlights = ?5) and "
    +" (r.name is null or r.name = ?6) and "
    +" (r.phrases is null or r.phrases = ?7) and "
    +" (r.networth is null or r.networth = ?8) and "
    +" (r.picture is null or r.picture = ?9)"
    )
    Page<RightWinger> getByDto(String bio,
          String birthdate,
          String fullname,
          String gender,
          String highlights,
          String name,
          String phrases,
          String networth,
          String picture,
          Pageable page);
}
