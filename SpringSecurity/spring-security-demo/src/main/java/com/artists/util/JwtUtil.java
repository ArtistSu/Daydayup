package com.artists.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtUtil {

    // Validity -> 1 hour
    public static final Long JWT_TTL = 60 * 60 * 1000L;
    // Secret key plaintext
    public static final String JWT_KEY = "artists";

    public static String getUUID(){
        String token = UUID.randomUUID().toString().replaceAll("-","");
        return token;
    }

    /**
     * Generate JWT
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String subject, Long ttlMillis){
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());
        return builder.compact();
    }

    private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if(ttlMillis == null){
            ttlMillis = JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                .setId(uuid) // unique id
                .setSubject(subject) // Topic can also be JSON data
                .setIssuer("allen") //issuer
                .setIssuedAt(now) // issue date
                .signWith(signatureAlgorithm, secretKey) // algorithm signature, 2nd parameter is secret key
                .setExpiration(expDate);
    }

    /**
     * Create token
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id, String subject, Long ttlMillis){
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);
        return builder.compact();
    }

    public static void main(String[] args) throws Exception{
        String token = "";
        Claims claims = parseJWT(token);
        System.out.println(claims);
    }

    /**
     * Create secret key
     * @return
     */
    public static SecretKey generalKey(){
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        SecretKey key = new SecretKeySpec(encodedKey,0,encodedKey.length,"AES");
        return key;
    }

    public static Claims parseJWT(String jwt) throws Exception{
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

}
