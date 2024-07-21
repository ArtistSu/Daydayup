package com.artists.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtils {

    /**
     * Rendering a string to the client
     * @param response Render object
     * @param string The string to be rendered
     * @return
     */
    public static String renderString(HttpServletResponse response, String string){
        try{
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
