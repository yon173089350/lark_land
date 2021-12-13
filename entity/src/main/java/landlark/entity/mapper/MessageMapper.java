package landlark.entity.mapper;

import java.util.List;
import landlark.entity.model.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(String msgId);

    int insert(Message message);

    Message selectByPrimaryKey(String msgId);

    List<Message> selectAll();

    int updateByPrimaryKey(Message message);
}