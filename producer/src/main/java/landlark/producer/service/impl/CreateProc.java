package landlark.producer.service.impl;

import landlark.entity.mapper.ProductMapper;
import landlark.entity.model.Product;
import landlark.producer.processor.AppProc;
import landlark.producer.processor.base.Proc;
import landlark.producer.request.apimodel.CreateReq;
import landlark.producer.response.apimodel.CreateResp;
import landlark.producer.service.AsyncServ;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Component("createProc")
@Log4j2
public class CreateProc extends Proc implements AppProc {
    @Autowired
    ProductMapper productMapper;

    @Autowired
    AsyncServ asyncServ;

    @Override
    @Transactional
    public Object process(String reqStr) throws InterruptedException {

        super.init(reqStr, "create");

        CreateReq req = gson.fromJson(reqStr, CreateReq.class);

        Date date = new Date();
        String uId = UUID.randomUUID().toString();
        Product product = new Product();
        product.setUid(uId);
        product.setCreateDatetime(date);
        product.setUpdateDatetime(date);
        product.setStatus("0");
        product.setContent(reqStr);
        product.setProductId(req.getId());

        productMapper.insert(product);

        CreateResp resp = new CreateResp();
        resp.setUid(uId);
        asyncServ.handleData();
        return resp;
    }


}
