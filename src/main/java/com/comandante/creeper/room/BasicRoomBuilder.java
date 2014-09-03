package com.comandante.creeper.room;

import com.google.common.base.Optional;

public class BasicRoomBuilder {
    private Integer roomId;
    private String roomTitle;
    private Optional<Integer> northId = Optional.absent();
    private Optional<Integer> southId = Optional.absent();
    private Optional<Integer> eastId = Optional.absent();
    private Optional<Integer> westId = Optional.absent();
    private Optional<Integer> upId = Optional.absent();
    private Optional<Integer> downId = Optional.absent();
    private String roomDescription;

    public BasicRoomBuilder setRoomId(Integer roomId) {
        this.roomId = roomId;
        return this;
    }

    public BasicRoomBuilder setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
        return this;
    }

    public BasicRoomBuilder setNorthId(Optional<Integer> northId) {
        this.northId = northId;
        return this;
    }

    public BasicRoomBuilder setSouthId(Optional<Integer> southId) {
        this.southId = southId;
        return this;
    }

    public BasicRoomBuilder setEastId(Optional<Integer> eastId) {
        this.eastId = eastId;
        return this;
    }

    public BasicRoomBuilder setWestId(Optional<Integer> westId) {
        this.westId = westId;
        return this;
    }

    public BasicRoomBuilder setUpId(Optional<Integer> upId) {
        this.upId = upId;
        return this;
    }

    public BasicRoomBuilder setDownId(Optional<Integer> downId) {
        this.downId = downId;
        return this;
    }

    public BasicRoomBuilder setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
        return this;
    }

    public BasicRoom createBasicRoom() {
        return new BasicRoom(roomId, roomTitle, northId, southId, eastId, westId, upId, downId, roomDescription);
    }
}