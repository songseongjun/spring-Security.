package com.junlevelup.clupb.repository;

import com.junlevelup.clupb.entity.ClubMember;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClubMemberRepository extends JpaRepository<ClubMember,String> {

  @EntityGraph(attributePaths = {"roleSet"},
  type = EntityGraph.EntityGraphType.LOAD
  )
  @Query("select m from ClubMember m where " +
  "m.fromSocial=:social and m.email=:email")
  Optional<ClubMember> findByEmail(String email, boolean social);


  //쿼리사용없이 JPA 로직으로 구성
  @EntityGraph(attributePaths = {"roleSet"},
          type = EntityGraph.EntityGraphType.LOAD)
  Optional<ClubMember> findByEmailAndFromSocial(String email, boolean social);



}
