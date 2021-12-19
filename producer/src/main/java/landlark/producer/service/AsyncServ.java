package landlark.producer.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Service
@Log4j2
public class AsyncServ {

    @Async
    public void handleData() throws InterruptedException{
        log.info("Async start");
        long startTime = System.currentTimeMillis();

        /*URL url = new URL("127.0.0.1:8080");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.disconnect();*/

        Thread.sleep(5000L);
        long endTime = System.currentTimeMillis();
        log.info("Async end, time: {}", (endTime - startTime));

    }
}
