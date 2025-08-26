package com.junlevelup.clupb.security;

import com.junlevelup.clupb.security.util.JWTUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JWTTests {

  private JWTUtil jwtUtil;


  @BeforeEach  //JWTTest를 테스트 할때마다 먼저 실행되는 메서드
  public void testBefore(){
    jwtUtil = new JWTUtil();
  }

  @Test
  public void testEncoder() throws Exception{
    String email = "user95@gmail.com";

    String str = jwtUtil.generateToken(email);

    System.out.println(str);
  }
}
