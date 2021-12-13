package landlark.produce.processor.impl;

import landlark.entity.mapper.MessageMapper;
import landlark.entity.model.Message;
import landlark.produce.processor.AppProc;
import landlark.produce.processor.base.Proc;
import landlark.produce.request.apimodel.SendReq;
import landlark.produce.response.apimodel.SendResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

@Component("sendProc")
public class SendProc extends Proc implements AppProc {
    @Autowired
    MessageMapper messageMapper;

    @Override
    @Transactional
    public Object process(String reqStr) {

        super.init(reqStr,"send");

        SendReq req = gson.fromJson(reqStr, SendReq.class);
        if(StringUtils.hasText(req.getMsgId())){
            for(Message msg:messageMapper.selectNonCompleteByMsgId(req.getMsgId())){
                msg.setStatus("9");
                messageMapper.updateByPrimaryKey(msg);
            }
        }

        Date date = new Date();
        String uId = UUID.randomUUID().toString();
        Message message = new Message();
        message.setUid(uId);
        message.setCreateDatetime(date);
        message.setUpdateDatetime(date);
        message.setStatus("0");
        message.setContent(reqStr);
        message.setMsgId(req.getMsgId());

        messageMapper.insert(message);

        SendResp resp = new SendResp();
        resp.setUid(uId);
        return resp;
    }
}
