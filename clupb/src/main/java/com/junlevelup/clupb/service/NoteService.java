package com.junlevelup.clupb.service;

import com.junlevelup.clupb.dto.NoteDTO;
import com.junlevelup.clupb.entity.ClubMember;
import com.junlevelup.clupb.entity.Note;

import java.util.List;

public interface NoteService {
  Long register(NoteDTO noteDto);

  NoteDTO get(Long num);

  void modify(NoteDTO noteDTO);

  void  remove(Long num);

  List<NoteDTO> getAllWithWriter(String writerEmail);

  default Note dtoToEntity(NoteDTO noteDTO) {
    Note note = Note.builder()
            .num(noteDTO.getNum())
            .title(noteDTO.getTitle())
            .content(noteDTO.getContent())
            .writer(ClubMember.builder()
                    .email(noteDTO.getWriterEmail())
            .build())
            .build();

            return note;
  }

  default NoteDTO entityToDto(Note note) {
    NoteDTO noteDTO = NoteDTO.builder()
            .num(note.getNum())
            .title(note.getTitle())
            .content(note.getContent())
            .writerEmail(note.getWriter().getEmail())
            .regDate(note.getRegDate())
            .modDate(note.getModDate())
            .build();

    return noteDTO;
  }
}