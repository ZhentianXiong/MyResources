package com.mindata.blockchain.core.manager;

import com.mindata.blockchain.core.model.MessageEntity;
import com.mindata.blockchain.core.repository.MessageRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuweifeng wrote on 2018/3/28.
 */
@Component
public class MessageManager {
    @Resource
    private MessageRepository messageRepository;

    public List<MessageEntity> findAll() {
        return messageRepository.findAll();
    }

    public List<String> findAllContent() {
        return findAll().stream().map(MessageEntity::getContent).collect(Collectors.toList());
    }

    public List<String> findByDomain(String domain) {
        return messageRepository.findByDomain(domain);
    }

    public List<String> findByIp(String ip){
        return messageRepository.findByIp(ip);
    }

    public MessageEntity findByOwner(String owner){
        return messageRepository.findByOwner(owner);
    }

    public MessageEntity findById(String id) {
        return messageRepository.findByMessageId(id);
    }
}
