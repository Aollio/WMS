package com.repository.dao;

import com.repository.entity.MessageEntity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Component
@Repository
@Transactional
public class MessageDao extends AbstractDao<MessageEntity> {


    public static void main(String[] args) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessageId("id66666");
        messageEntity.setMessageType("type44");
        messageEntity.setMessageContent("444444");
        messageEntity.setMessageDate(new Timestamp(System.currentTimeMillis()));
        messageEntity.setMessageReceiveId("reerer");
        messageEntity.setMessageSendId("sendid");

        MessageDao messageDao = new MessageDao();

        messageDao.save(messageEntity);
    }

    public List<MessageEntity> findByState(String recvID, MessageEntity.State state) {
        return sessionFactory.getCurrentSession()
                .createQuery("from MessageEntity e " +
                        "where e.messageReceiveId=:recvid " +
                        "and e.messageState=:state")
                .setParameter("recvid", recvID)
                .setParameter("state", state)
                .list();
    }


}
