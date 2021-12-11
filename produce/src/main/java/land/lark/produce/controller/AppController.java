package land.lark.produce.controller;

import java.util.Date;

import land.lark.produce.processor.AppProc;
import land.lark.produce.response.AppResp;
import lombok.extern.log4j.Log4j2;
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
    public ResponseEntity<AppResp> msgHandle(@PathVariable("reqId") String reqId, @RequestBody String msg) {

        AppResp resp = new AppResp();
        resp.setStartTime(new Date());
        ResponseEntity<AppResp> respEntity = new ResponseEntity<>(resp, HttpStatus.OK);

        try {
            resp.setContext(((AppProc) context.getBean(reqId + "Proc")).process(msg));
        } catch (BeansException ex) {
            resp.setErrCode("400");
            String errMsg = String.format("Request ID[%s] is not available", reqId);
            resp.setErrMsg(errMsg);
            log.error(errMsg);
        }

        resp.setEndTime(new Date());
        return respEntity;
    }
}


