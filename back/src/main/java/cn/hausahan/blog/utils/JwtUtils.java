package cn.hausahan.blog.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;


@Data
@Component
public class JwtUtils {

    private long expire = 604800;
    private String secret = "BWGGbHackPjwtP1PSeCretpNevEruSed";
    private String header = "Authorization";

    // Generate JWT
    public String generateToken(String username){
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + 1000*expire);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(username)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    // Analyse JWT
    public Claims getClaimByToken(String jwt){

        try{
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (Exception e){
            ////////// Don't return NULL !!!!!!!!!!!!
            return null;
        }
    }

    // Check expire
    public boolean isTokenExpired(Claims claims){
        return claims.getExpiration().before(new Date());
    }
}







