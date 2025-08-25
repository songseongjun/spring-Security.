package com.junlevelup.clupb.controller;

import com.junlevelup.clupb.dto.NoteDTO;
import com.junlevelup.clupb.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("/notes/")
@RequiredArgsConstructor
public class NoteController {

  private final NoteService noteService;

  @PostMapping(value = "")
  public ResponseEntity<String> register(@RequestBody NoteDTO noteDto) {
    log.info("==================================");
    log.info("register");
    log.info(noteDto);

    Long num = noteService.register(noteDto);

    String message = num + "번글이 등록되었습니다.";

    return ResponseEntity.ok(message);
  }
  @GetMapping(value = "/{num}"
          ,produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<NoteDTO> read(@PathVariable("num") Long num) {
    log.info("==========================================");
    log.info("read");
    return ResponseEntity.ok(noteService.get(num));
  }

  @GetMapping(value = "/all",
  produces =  MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<NoteDTO>> getList(
          @RequestParam("email")
          String email) {
    log.info("====================================================");
    log.info(email);

    return ResponseEntity.ok(noteService.getAllWithWriter(email));
  }


  @PutMapping(value = "/{num}"
  ,produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity<String> modify(@RequestBody NoteDTO noteDto,
                                       @PathVariable("num")Long num) {
    log.info("========================");
    log.info(noteDto);

    noteDto.setNum(num);
    noteService.modify(noteDto);

    return ResponseEntity.ok("modified");
  }

  @DeleteMapping(value = "{num}")
  public ResponseEntity<String> remove(@PathVariable("num")Long num) {
    log.info("===================================================");
    log.info("num");
    noteService.remove(num);

    return ResponseEntity.ok("removed");
  }
}
