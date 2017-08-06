package com.div.test.interceptor;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethodInvoker;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;
import org.jboss.resteasy.util.Base64;

import com.div.test.service.UserService;
import com.div.test.service.UserServiceImpl;

@Provider
@ServerInterceptor
public class UserNoteRestInterceptor implements PreProcessInterceptor{
    private static final ServerResponse ACCESS_DENIED = new ServerResponse("Access denied for this resource", 401, new Headers<Object>());
    private static final ServerResponse SERVER_ERROR = new ServerResponse("server error", 500, new Headers<Object>());
   
    UserService userService = UserServiceImpl.getInstance();

	@Override
	public ServerResponse preProcess(HttpRequest request, ResourceMethodInvoker method)
			throws Failure, WebApplicationException {
		// TODO Auto-generated method stub
		
		HttpHeaders headers = request.getHttpHeaders();
		List<String> authorization = headers.getRequestHeader("Authorization");
		
		//if authrization is null then throw error
		if(authorization == null || authorization.isEmpty())
		{
			return ACCESS_DENIED;
		}
		
		String userPassEnc = authorization.get(0).replaceFirst("Basic"+ " ", "");
		String userPass;
        try {
        	// decode username & password
        	userPass = new String(Base64.decode(userPassEnc));
        } catch (IOException e) {
            return SERVER_ERROR;
        }
        
        // fetch the username:password list from DB
        List<String> userProperties = userService.listUserProperties();
        
        if(!userProperties.contains(userPass))
        {
        	return ACCESS_DENIED;
        }
		return null;
	}
}
