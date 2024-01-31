package com.koji;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. @ClassName JwtTest
 * 2. @Description TODO
 * 3. @Author ww103
 * 4. @Date 2024/1/31 22:48
 * 5. @Version 1.0
 */

public class JwtTest {

    @Test
    public void testGenJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 123);
        claims.put("name", "jack");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "koji") // 设置JWT签名加密算法和密钥、
                .setClaims(claims)  // 自定义内容（payload载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置1h后失效
                .compact();
        System.out.println(jwt);
    }

    /**
     * 解析jwt
     */
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("koji")  // 指定签名密钥
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiamFjayIsImlkIjoxMjMsImV4cCI6MTcwNjcxNzE2Nn0.Uumy_AQnV7yHsbgyy6cUN-I0YUijAJaR89txmTe7rbM")
                .getBody();
        System.out.println(claims);
    }
}
