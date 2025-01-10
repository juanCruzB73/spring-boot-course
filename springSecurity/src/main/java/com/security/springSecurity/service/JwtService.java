package com.security.springSecurity.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static String SECRET="586E3272357538782F413F4428472B4B6250655368566B597033733676397924";

    public String getToken(UserDetails user){
        return getToken(new HashMap<>(),user);
    }

    private String getToken(Map<String,Object>extractClaims,UserDetails user){

        return Jwts.builder()
                .setClaims(extractClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getKey(){
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getUsernameFromToken(String token){
        return getClaim(token, Claims::getSubject);
    }

    public boolean isValidToken(String token,UserDetails userDetails){
        final String username=getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())&&!isTokenExpired(token));
    }

    public Claims getAllClaims(String token){
       return Jwts.parserBuilder()
               .setSigningKey(getKey())
               .build()
               .parseClaimsJws(token)
               .getBody();
    }

    public <T>T getClaim(String token, Function<Claims,T>claaimsResolver){
        final Claims claims=getAllClaims(token);
        return claaimsResolver.apply(claims);
    }

    private Date getExpirationDate(String token){
        return getClaim(token,Claims::getExpiration);
    }
    private boolean isTokenExpired(String token){
        return getExpirationDate(token).before(new Date());
    }

}
