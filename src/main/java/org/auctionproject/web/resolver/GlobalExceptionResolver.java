package org.auctionproject.web.resolver;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bishal on 3/30/17.
 */
public class GlobalExceptionResolver  extends SimpleMappingExceptionResolver {

    @Override
    public String buildLogMessage(Exception ex, HttpServletRequest request) {
        return "Spring MVC exception: " + ex.getLocalizedMessage();
    }
}
