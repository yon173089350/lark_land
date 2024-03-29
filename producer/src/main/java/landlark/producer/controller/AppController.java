package landlark.producer.controller;

import jakarta.servlet.http.HttpServletRequest;
import landlark.producer.response.apimodel.processor.AppProc;
import landlark.producer.response.AppResp;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

/**
 * AppController
 *
 * @author yonxu
 */
@Log4j2
@RestController
@RequestMapping(value = {"/api"})

public class AppController {

    @Autowired
    private ApplicationContext context;

    @PostMapping(value = "/{reqId}")
    public ResponseEntity<AppResp> msgHandle(@PathVariable("reqId") String reqId, @RequestBody String reqStr, HttpServletRequest request) {

        AppResp resp = AppResp.builder().timestamp(new Date()).path(request.getServletPath()).build();
        ResponseEntity<AppResp> respEntity;

        try {
            resp.setContext(((AppProc) context.getBean(reqId + "Proc")).process(reqStr));
            resp.setStatus(HttpStatus.OK.value());
            respEntity = new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (InterruptedException | IOException ex) {
            resp.setStatus(HttpStatus.BAD_REQUEST.value());
            resp.setError(ex.getMessage());
            respEntity = new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
            log.error(ExceptionUtils.getStackTrace(ex));
            Thread.currentThread().interrupt();
        }

        return respEntity;
    }
}


