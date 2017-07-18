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

@Controller
public class RestTesterController{
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private Environment env;
    private ResourceLoader resourceLoader;

    @Autowired
    public void setEnv(Environment env) { this.env = env; }

    @RequestMapping(value="/")
    public @ResponseBody void getJson(HttpServletRequest request, HttpServletResponse response){
           String json = env.getProperty("link");
           try{
               JSONObject jsonObject = new JSONObject(json);
    }catch(Exception e){
        logger.warn(e.getMessage());
    }

    }
}