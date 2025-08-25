package com.junlevelup.clupb.service;


import com.junlevelup.clupb.dto.NoteDTO;
import com.junlevelup.clupb.entity.Note;
import com.junlevelup.clupb.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

  private  final NoteRepository noteRepository;

  @Override
  public Long register(NoteDTO noteDto) {
    Note note = dtoToEntity(noteDto);
    log.info("===============================");
    log.info(note);
    noteRepository.save(note);
    return note.getNum();
  }

  @Override
  public NoteDTO get(Long num) {
    Optional<Note> result = noteRepository.getWithWriter(num);
    if (result.isPresent()) {
      return entityToDto(result.get());
    }
    return null;
  }

  @Override
  public void modify(NoteDTO noteDTO) {

    Long num = noteDTO.getNum();
    Optional<Note> result = noteRepository.findById(num);

    if (result.isPresent()) {
      Note note = result.get();
      note.changeTitle(noteDTO.getContent());
      note.changeContent(noteDTO.getContent());
    }
  }

  @Override
  public void remove(Long num) {

    noteRepository.deleteById(num);
  }

  @Override
  public List<NoteDTO> getAllWithWriter(String writerEmail) {
    List<Note> noteList = noteRepository.getList(writerEmail);

    return noteList.stream()
            .map(note -> entityToDto(note))
            .collect(Collectors.toList());
  }

}
