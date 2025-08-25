package com.junlevelup.clupb.security.util;


import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.Date;

@Log4j2
public class JWTUtil {

  private String sercetKey = "club12345678";

  private long expire = 60 * 24 * 30;  //단위: 분 (30일)

  public String generateToken(String content) throws Exception {
    return Jwts.builder()
            .issuedAt(new Date())
            .expiration(Date.from(ZonedDateTime.now().plusSeconds(expire).toInstant()))
            .claim("sub", content)
            .signWith(SignatureAlgorithm.HS256, sercetKey.getBytes("UTF_8"))
            .compact();
//  }
//
//  public  validateAndExtract(String tokenStr) throws  Exception{
//    String contentValue = null;
//
//    try{
//      Jws
//    }
  }
}
