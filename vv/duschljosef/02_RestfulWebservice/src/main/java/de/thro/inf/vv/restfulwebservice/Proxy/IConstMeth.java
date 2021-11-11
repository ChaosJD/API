package de.thro.inf.vv.restfulwebservice.Proxy;

import org.omg.CORBA.Current;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/12/31
 */
public interface IConstMeth {
    String REST_SERVICE_URI = "http://localhost:8080";
    RestTemplate restTemplate = new RestTemplate();

    /**
     * Creates a line with 50 - in the Console
     */
    default void line(){
        System.out.println("line");
        for(int i =0; i < 50; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
