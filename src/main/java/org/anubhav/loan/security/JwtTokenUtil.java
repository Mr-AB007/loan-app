package org.anubhav.loan.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtil {

    private static final String SECRET_KEY = "your-very-secure-secret-key-your-very-secure-secret-key";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    /**
     * Generate JWT token with username and roles
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        // Extract roles from UserDetails
        String roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        claims.put("roles", roles); // Add roles to JWT payload

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername()) // Store username
                .setIssuedAt(new Date()) // Issued time
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Expiry
                .signWith(key, SignatureAlgorithm.HS256) // Signing with secret key
                .compact();
    }

    /**
     * Extract username (subject) from JWT
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extract roles from JWT
     */
    public String extractRoles(String token) {
        return extractClaim(token, claims -> claims.get("roles", String.class));
    }

    /**
     * Extract a specific claim
     */
    private <T> T extractClaim(String token, java.util.function.Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Parse JWT and extract all claims
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Check if token is expired
     */
    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    /**
     * Validate JWT token
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
