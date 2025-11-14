package com.truckapp.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityHeadersFilter extends OncePerRequestFilter {
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    // ISO/IEC 25010: Security – fortalecer cabeceras por defecto
    response.setHeader("X-Content-Type-Options", "nosniff");
    response.setHeader("X-Frame-Options", "DENY");
    response.setHeader("Referrer-Policy", "no-referrer");
    response.setHeader("Permissions-Policy", "geolocation=(), camera=(), microphone=(), fullscreen=(self)");
    // Para APIs JSON, una CSP básica que no permite ser embebida
    response.setHeader("Content-Security-Policy", "default-src 'self'; frame-ancestors 'none'");

    filterChain.doFilter(request, response);
  }
}