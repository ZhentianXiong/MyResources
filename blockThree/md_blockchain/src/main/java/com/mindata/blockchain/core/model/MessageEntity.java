package com.mindata.blockchain.core.model;

import com.mindata.blockchain.core.model.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wuweifeng wrote on 2017/10/25.
 */
@Entity
@Table(name = "message")
public class MessageEntity extends BaseEntity {
    /**
     * 内容
     */
    private String content;
    /**
     * 域名
     */
    private String domain;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 业务id
     */
    private String messageId;
    /**
     * 域名拥有者的公钥
     */
    private String owner;
    /**
     * 与该域名有关的增删改查最新一次出现的区块位置
     */
    private Long height;

    @Override
    public String toString() {
        return "MessageEntity{" +
                "content='" + content + '\'' +
                ", domain='" + domain + '\'' +
                ", ip='" + ip + '\'' +
                ", owner='" + owner + '\'' +
                ", height='" + height + '\'' +
                ", messageId='" + messageId + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }
}
