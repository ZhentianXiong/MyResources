package com.mindata.blockchain.core.repository;

import com.mindata.blockchain.core.model.MessageEntity;

import java.util.List;

/**
 * @author wuweifeng wrote on 2017/10/25.
 */
public interface MessageRepository extends BaseRepository<MessageEntity> {
    /**
     * 删除一条记录
     * @param messageId  messageId
     */
    void deleteByMessageId(String messageId);

    /**
     * 查询一个
     * @param messageId messageId
     * @return MessageEntity
     */
    MessageEntity findByMessageId(String messageId);

    List<String> findByDomain(String domain);

    List<String> findByIp(String ip);

    MessageEntity findByOwner(String owner);
}
