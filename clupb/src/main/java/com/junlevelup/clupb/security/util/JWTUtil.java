package com.junlevelup.clupb.security.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;

@Log4j2
public class JWTUtil {
    //글자수를 32자 이상을 권장(HS256)
  private String sercetKeyString = "club12345678club12345678club12345678";

  private long expire = 60 * 24 * 30;  //단위: 분 (30일)



  public String generateToken(String content) throws Exception {
        //암호화시키는것
    SecureDigestAlgorithm alg = Jwts.SIG.HS256;
    byte[] keyBytes = sercetKeyString.getBytes();
    Key key = Keys.hmacShaKeyFor(keyBytes);

    //HEAHER로 전달되는 값을 Claims 클래스에 담아서 jwts에 전달 id랑유효기간을객체로 가지고있다
    Claims claims = Jwts.claims()
            .subject(content)
            .issuedAt(new Date())
            .expiration(Date.from(ZonedDateTime.now().plusSeconds(expire).toInstant()))
            .build();

    return Jwts.builder()
            .claims(claims)
            .signWith(key,alg)
            .compact();
  }
      //토큰의 유효성 검사
  public String  validateAndExtract(String tokenStr) throws  Exception{
    byte[] keyBytes = sercetKeyString.getBytes();
    SecretKey key = Keys.hmacShaKeyFor(keyBytes);

        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(tokenStr)
                .getPayload();

        return claims.getSubject();
  }
}
