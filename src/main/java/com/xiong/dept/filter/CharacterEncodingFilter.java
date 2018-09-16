package com.xiong.dept.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
	
	private String encoding;

	public void destroy() {		
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		 
		String str = filterConfig.getInitParameter("encode");
		if(str != null && str != ""){
			encoding = str;
		}
	}

}
