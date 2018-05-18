package edu.wisc.my.apps.resttester.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.StringWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.util.ResourceUtils;
import java.io.ByteArrayOutputStream;
import java.io.BufferedInputStream;


@Controller
public class RestTesterController{
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private Environment env;
    private ResourceLoader resourceLoader;
    private String responseType = null;

    @Autowired
    public void setEnv(Environment env) { this.env = env; }


    @RequestMapping(value="/xml")
    public @ResponseBody void getXml(HttpServletRequest request, HttpServletResponse response){
        responseType = "application/xml";
        getResponse(request, response);
    }

    

    @RequestMapping(value="/")
    public @ResponseBody void getResponse(HttpServletRequest request, HttpServletResponse response){
    try {
          String linkLocation = env.getProperty("link");
          logger.error(linkLocation);
  
    File filio = ResourceUtils.getFile("classpath:config/xmlToReturn.xml");
    InputStream is = new FileInputStream(filio);
    StringWriter writer = new StringWriter();
    BufferedInputStream bis = new BufferedInputStream(is);
    ByteArrayOutputStream buf = new ByteArrayOutputStream();
   int i = bis.read();
while(i != -1) {
    buf.write((byte) i);
    i = bis.read();
}
// StandardCharsets.UTF_8.name() > JDK 7

    String responseObj= buf.toString();
    
    logger.error("Filio " + filio.exists());
 
          response.getWriter().write(responseObj);
          if(responseType == null) { 
              responseType = "application/json";
          }
          response.setContentType(responseType);
          response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            logger.error("Issues happened while trying to write Status", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}