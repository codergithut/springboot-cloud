package com.domain.entity;

public class EventInfo implements GetMainId {

    /**
     * 数据id
     */
    private String id;

    /**
     * 事件信息
     */
    private String event;

    /**
     * 犯罪类型
     */
    private String tag;

    /**
     * 设备ID
     */
    private int deviceID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    @Override
    public String getMainId() {
        return id;
    }
}
