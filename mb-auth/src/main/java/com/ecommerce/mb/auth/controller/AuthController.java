package com.ecommerce.mb.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.mb.auth.models.entity.UserEntity;
import com.ecommerce.mb.auth.models.repository.CustomerRepository;
import com.ecommerce.mb.auth.models.repository.UserRepository;
import com.ecommerce.mb.auth.models.request.TokenValidate;
import com.ecommerce.mb.auth.security.JwtService;
import com.ecommerce.mb.auth.utils.Messenger;
import com.ecommerce.mb.commons.exceptions.InvalidCredentialsException;
import com.ecommerce.mb.commons.models.entity.Customer;
import com.ecommerce.mb.commons.models.enums.CodeEnum;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user/v1")
@Tag(name = "Autenticacion", description = "Endpoints para autenticar usuarios y registrar Invitados.")
public class AuthController {
	

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtService jwtService;
	@Autowired
	private CustomerRepository perfilRepository;
	@Autowired
	private Messenger messenger;

	private Logger logger = LoggerFactory.getLogger(UserAuthController.class);
	
	@Operation(hidden = true)
	@GetMapping(value = "/autenticar-token")
	public ResponseEntity<?> getRoles(@RequestHeader("Authorization") String authHeader) {
		try {

			if (authHeader != null) {

				String user = jwtService.extractUsername(authHeader);
				String role = jwtService.extractRole(authHeader);

				UserEntity userEntity = userRepository.findByEmail(user).orElseThrow(
						() -> new InvalidCredentialsException(messenger.getMessage(CodeEnum.BAD_CREDENTIALS)));
				Customer profile = perfilRepository.getByUserId(userEntity.getId()).orElse(new Customer());

				TokenValidate response = new TokenValidate();
				response.setIdProfile(profile.getId());
				response.setRole(role);

				return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
			} else {
				throw new InvalidCredentialsException(messenger.getMessage(CodeEnum.BAD_CREDENTIALS));
			}
		} catch (ExpiredJwtException ex) {
			String errorMessage = "Token has expired.";
			logger.error("Token expired: {}", ex.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
		} catch (JwtException ex) {
			String errorMessage = "Invalid token.";
			logger.error("Invalid token: {}", ex.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
		} catch (Exception e) {
			String errorMessage = "An error occurred.";
			logger.error("Exception: {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorMessage);
		}
	}
}
