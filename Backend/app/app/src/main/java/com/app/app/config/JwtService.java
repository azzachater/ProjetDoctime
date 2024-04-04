package com.app.app.config;

import com.app.app.dto.AuthentificationDTO;
import com.app.app.entities.User;
import com.app.app.services.UserServiceImp;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service
public class JwtService {
    private final String ENCRIPTION_KEY = "608f36e92dc66d97d5933f0e6371493cb4fc05b1aa8f8de64014732472303a7c";
    @Autowired
    private UserServiceImp userService;
    public Map<String,String> generate(String username){

        User user= (User) this.userService.loadUserByUsername(username);
        return this.generateJwt(user);
    }

    private Map<String, String> generateJwt(User user) {
        final long currentTime=System.currentTimeMillis();
        final long expirationTime=currentTime+30*60*1000;
        final Map<String, Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        claims.put(Claims.EXPIRATION, new Date(expirationTime));
        claims.put(Claims.SUBJECT, user.getEmail());
        /*final Map<String, Object> claims=Map.of("username",user.getUsername(),
                Claims.EXPIRATION, new Date(expirationTime),
                Claims.SUBJECT, user.getEmail()
        );*/

        final String bearer =Jwts.builder()
                .setIssuedAt(new Date(currentTime))
                .setIssuedAt(new Date(expirationTime))
                .setSubject(user.getEmail())
                .setClaims(claims)
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
        //return Map.of("bearer",bearer) ;
        return Collections.singletonMap("bearer", bearer); // Utilisation de Collections.singletonMap pour créer un Map

    }

    private Key getKey() {
        final byte[] decoder= Decoders.BASE64.decode(ENCRIPTION_KEY);

        return Keys.hmacShaKeyFor(decoder);
    }

    public String extractUsername(String token) {
        return this.getClaim(token, Claims::getSubject);
    }

    public boolean isTokenExpired(String token) {
        Date expirationDate = getExpirationDateFromToken(token);
        return expirationDate.before(new Date());
    }

    private Date getExpirationDateFromToken(String token) {
        return this.getClaim(token, Claims::getExpiration);
    }
    private <T> T getClaim(String token, Function<Claims, T> function) {
        Claims claims = getAllClaims(token);
        return function.apply(claims);
    }

    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(this.getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
