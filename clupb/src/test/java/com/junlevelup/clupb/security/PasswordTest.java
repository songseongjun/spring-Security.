package com.junlevelup.clupb.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordTest {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Test
  public void testEncode(){
    String password = "1111";
    String enPw = passwordEncoder.encode(password);
    System.out.println("enPw:"+enPw);
    // matches(인코딩전 패스워드, 인코딩후 패스워드)
    boolean matchResult = passwordEncoder.matches(password, enPw);
    System.out.println("matchResult:"+matchResult);
  }
}
