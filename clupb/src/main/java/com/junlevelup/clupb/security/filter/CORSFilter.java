package com.junlevelup.clupb.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


// CORS: Cross-Origin Resource Sharing
// 서버의 주소 또는 포트가 다른경우 데이터를 주고 받을 수 있도록 합니다.
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter extends OncePerRequestFilter {
  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {
    //허용하고자하는 주소(url)를 설정
    // "*": 모든 주소를 허용
    // 2번째 인자에 스트링한개의 값만 허용
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");


    //2개 이상 포트를 허용하고 싶을때
//    List<String> allowOrigin = Arrays.asList(
//            "http://localhost:3000",
//            "http://localhost:4000"
//    );
//
//    String originHeader = request.getHeader("Origin");
//    if (allowOrigin.contains(originHeader)) {
//      response.setHeader("Access-Control-Allow-Origin", originHeader);
//    }

    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Allow-Methods", "*");
//    response.setHeader("Access-Control-Allow-Credentials", "POST,GET,OPTIONS,DELETE,PUT");
    response.setHeader("Access-Control-Max-Age", "3600"); //초단위설정
    // preflight
    // OPTIONS로 먼저 데이터를 전송하여 사전확인작업
    // POST /api/data HTTP/1.1
    // Origin: Http://localhost:3000
    // Content-Type: application/json
    // Authorization: Bearer ~~~~~

    // OPTIONS /api/data HTTP/1.1
    // Origin: Http://localhost:3000
    // Content-Type: application/json
    // Authorization: Bearer ~~~~~

//    response.setHeader("Access-Control-Allow-Headers", "*");
    response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,Key, Authorization");
    // Origin : 요청주소, 포트
    // X-Requested-With: Ajax요청(비동기요청시 만들어짐) XMLhttoRequest
    //Content-Type: Body내용의 데이터형식
    // Accept : 응답받을때 데이터 형식(application/json, text/html, text/plain)
    // Key: 사용자헤더(브라우저가 생성하는것은 아니다)
    // Authorization :인증정보


    if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
      response.setStatus(HttpServletResponse.SC_OK);
    }
    else {
      filterChain.doFilter(request,response);
    }
  }
}
