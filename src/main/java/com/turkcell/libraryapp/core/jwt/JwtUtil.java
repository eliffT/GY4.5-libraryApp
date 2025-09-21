package com.turkcell.libraryapp.core.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtUtil {
    private String SECRET_KEY = "f0ffdaf3265edc4be5e0d283ac850c509bf783e295d061541e35ff810ce0589cdbbd2055130722dd79a7ee44160ae61b4bb1c8f797b2f7965712221091279ec8";

    public String generateToken(String username){
        Date expirationDate = new Date(System.currentTimeMillis()+1000 * 60 * 60);

        HashMap<String, Object> claims = new HashMap<String, Object>();

        claims.put("username",username);
        claims.put("admin", true);

        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        String jwt = Jwts.builder().subject(username).issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expirationDate).claims(claims).signWith(key).compact();

        return jwt;
    }

    public Boolean validateToken(String token)
    {
        try{
            Claims claims = extractAllClaims(token);
            return claims.getExpiration().after(new Date());
        }
        catch(Exception e)
        {
            return false;
    }
    }

    public String extractUsername(String token){
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    private Claims extractAllClaims(String token)
    {
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts.parser().verifyWith(key).build()
                .parseSignedClaims(token).getPayload();
    }

}
