package com.stackroute.HealthMonitoring.Service;

import org.springframework.stereotype.Service;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Priyanshu Singh
 */
@Service
public class JwtToken {


  @Value("${jwt.secretKey}")
  private String secretKey;

  public  String generateToken(String username) {
   Date now = new Date();
   Date expiryDate = new Date(now.getTime() + 10000);

   return Jwts.builder()
           .setSubject(username)
           .setIssuedAt(now)
           .setExpiration(expiryDate)
           .signWith(SignatureAlgorithm.HS512, secretKey)
           .compact();

  }

 }

