package com.junlevelup.clupb.security;

import com.junlevelup.clupb.entity.ClubMember;
import com.junlevelup.clupb.entity.ClubMemberRole;
import com.junlevelup.clupb.repository.ClubMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ClubMemberTest {

  @Autowired
  private ClubMemberRepository repository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Test
  public void insertDummies(){

    IntStream.rangeClosed(1,100).forEach(i->{
      ClubMember clubMember = ClubMember.builder()
              .email("user" + i + "@gmail.com")
              .name("사용자" + i)
              .fromSocial(false)
              .password(passwordEncoder.encode("1111"))
              .build();

      clubMember.addMemberRole(ClubMemberRole.USER);
      if (i>80) {
        clubMember.addMemberRole(ClubMemberRole.MEMBER);
      }
      if (i>90) {
        clubMember.addMemberRole(ClubMemberRole.ADMIN);
      }
      repository.save(clubMember);
    });
  }

  @Test
  public void testRead() {
    Optional<ClubMember> result = repository.findByEmail("user95@gmail.com",false);
    ClubMember clubMember = result.get();
    System.out.println(clubMember);
  }

  @Test
  public void testRead2() {
    Optional<ClubMember> result = repository.findByEmailAndFromSocial("user95@gmail.com",false);
    ClubMember clubMember = result.get();
    System.out.println(clubMember);
  }
}
