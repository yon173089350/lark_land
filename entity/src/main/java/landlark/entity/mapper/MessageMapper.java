package landlark.entity.mapper;

import java.util.List;
import landlark.entity.model.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(String uid);

    int insert(Message message);

    Message selectByPrimaryKey(String uid);

    List<Message> selectAll();

    int updateByPrimaryKey(Message message);

    List<Message> selectNonCompleteByMsgId(String MsgId);
}