package com.training.tms.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.training.tms.service.CustomUserAuthService;
import com.training.tms.util.JWTUtil;

@Component
public class JWTFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtil jWTUtil;
	
	@Autowired
	private CustomUserAuthService customUserAuthService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String header = request.getHeader("Authorization");
		String token=null;
		String userName=null;
		if (header != null && header.startsWith("Bearer")) {
			token = header.substring(7);
			userName=jWTUtil.getUsernameFromToken(token);
			System.out.println(userName);
		}
		
		if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails = customUserAuthService.loadUserByUsername(userName);
			System.out.println(userDetails);
			System.out.println(jWTUtil.validateToken(token, userDetails));
			if(jWTUtil.validateToken(token, userDetails)) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(
						userDetails,null,userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			
		}
	
		filterChain.doFilter(request, response);
	}
	}
