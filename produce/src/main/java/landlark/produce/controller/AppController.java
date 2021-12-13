package landlark.produce.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import landlark.produce.processor.AppProc;
import landlark.produce.response.AppResp;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.everit.json.schema.ValidationException;
import org.json.JSONException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


        AppResp resp = new AppResp();
        ResponseEntity<AppResp> respEntity;

        resp.setTimestamp(new Date());
        resp.setPath(request.getServletPath());

        try {
            resp.setContext(((AppProc) context.getBean(reqId + "Proc")).process(reqStr));
            resp.setStatus(HttpStatus.OK.value());
            respEntity = new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (Exception ex) {
            resp.setStatus(HttpStatus.BAD_REQUEST.value());
            resp.setError(ex.getMessage());
            respEntity = new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
            log.error(ExceptionUtils.getStackTrace(ex));
        }

        return respEntity;
    }
}

