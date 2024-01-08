package Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import Raw.RawAccount;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

public class jwtHandler {
    private static final String key = "TuanAnhdeptraiprovipno1";
    private static final Algorithm algorithm = Algorithm.HMAC256(key);


    public static String createJWT(RawAccount user) {
        return JWT.create()
                .withIssuer(key)
                .withSubject("Authorized account")
                .withClaim("username", user.getUsername())
                .withClaim("password", user.getPassword())
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + 555500000L))
                .withJWTId(UUID.randomUUID().toString())
                .withNotBefore(new Date(System.currentTimeMillis() + 1000L))
                .sign(algorithm);
    }
    public static RawAccount verify(String jwtToken) {
        try{
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(key)
                    .build();
            DecodedJWT decodedJWT = verifier.verify(jwtToken);
            if(decodedJWT.getExpiresAt()
                    .compareTo(new Time(System.currentTimeMillis())) > 0) {
                String username = decodedJWT.getClaim("username").toString();
                String password = decodedJWT.getClaim("password").toString();
                System.out.println("username: " + username + " password: " + password);
                return new RawAccount(username.substring(1, username.length() - 1), password.substring(1, password.length() - 1));
            }
        } catch (JWTVerificationException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
