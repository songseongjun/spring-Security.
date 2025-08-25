package com.junlevelup.clupb.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import net.minidev.json.JSONObject;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;


@Log4j2
public class ApiCheckFilter extends OncePerRequestFilter {

  private AntPathMatcher antPathMatcher;
  private String pattern;

  public ApiCheckFilter(String pattern) {
    this.antPathMatcher = new AntPathMatcher();
    this.pattern = pattern;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {

    log.info(request.getRequestURI());


    if (antPathMatcher.match(pattern, request.getRequestURI())) {
    log.info("ApiCheckFilter==============================================");
    log.info("ApiCheckFilter==============================================");
    log.info("ApiCheckFilter==============================================");

    boolean checkHeader = checkAutHeader(request);

    if (checkHeader) {
      filterChain.doFilter(request, response);
      return;
    }
        else {
          response.setStatus(HttpServletResponse.SC_FORBIDDEN);
          response.setContentType("application/json;charset=UTF-8");
          JSONObject json = new JSONObject();
          String message = "FATL CHECK API TOKEN";
          json.put("code", 403);
          json.put("message", message);

          PrintWriter out = response.getWriter();
          out.print(json);
      return; // 시큐리티 필터 체인을 끝내라 라는의미이다

      }
    }

    filterChain.doFilter(request, response);
  }

  private boolean checkAutHeader(HttpServletRequest request) {
    boolean checkResult = false;

    String authHeader = request.getHeader("Authorization");
    if (StringUtils.hasText(authHeader)){
      log.info("Authorization exist:{}", authHeader);
      if (authHeader.equals("12345678 ")) {
        checkResult = true;
      }
    }
    return checkResult;
  }
}


