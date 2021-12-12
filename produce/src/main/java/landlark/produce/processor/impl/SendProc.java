package landlark.produce.processor.impl;

import landlark.entity.mapper.MessageMapper;
import landlark.entity.model.Message;
import landlark.produce.processor.AppProc;
import landlark.produce.processor.base.Proc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sendProc")
public class SendProc extends Proc implements AppProc {
    @Autowired
    MessageMapper messageMapper;

    @Override
    public Object process(String req) {
        Message message=new Message();
        message.setContent(req);
        return messageMapper.insert(message);
    }
}
