package landlark.produce.processor.impl;

import landlark.entity.mapper.MessageMapper;
import landlark.entity.model.Message;
import landlark.produce.processor.AppProc;
import landlark.produce.processor.base.Proc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component("sendProc")
public class SendProc extends Proc implements AppProc {
    @Autowired
    MessageMapper messageMapper;

    @Override
    public Object process(String req) {

        Date date=new Date();

        String uuidAsString = UUID.randomUUID().toString();

        Message message = new Message();
        message.setMsgId(uuidAsString);
        message.setCreateDatetime(date);
        message.setUpdateDatetime(date);
        message.setContent(req);
        messageMapper.insert(message);

        return uuidAsString;
    }
}
