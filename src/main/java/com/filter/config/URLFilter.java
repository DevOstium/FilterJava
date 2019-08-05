package com.filter.config;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


//https://github.com/eugenp/tutorials/blob/master/spring-boot/src/main/java/com/baeldung/bootcustomfilters/filters/TransactionFilter.java

@Component
public class URLFilter implements Filter {

	private final static Logger LOG = LoggerFactory.getLogger(URLFilter.class);

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		LOG.info("Começar aplicação com o filter :{}", this);
	}

	//localhost:8080/teste-filter?id=45&token=ererere
	@Override
	public void doFilter( final ServletRequest  request
			             ,final ServletResponse response
			             ,final FilterChain     chain )	throws IOException, ServletException {
		
		HttpServletRequest   req = (HttpServletRequest)  request;
		HttpServletResponse  res = (HttpServletResponse) response;
		
		String token = req.getParameter("token");
		
		System.out.println("Tokne no Filter : " + token);
		
		LOG.info("Logging Request  {} : {}  ", req.getMethod(), req.getRequestURI() );
		
		chain.doFilter(request, response);
		LOG.info("Logging Response :{}", res.getContentType());
	}

	@Override
	public void destroy() {
		LOG.warn("Destructing filter :{}", this);
	}

}
