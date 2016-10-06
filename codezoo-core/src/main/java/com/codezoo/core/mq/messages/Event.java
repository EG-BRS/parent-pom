package com.codezoo.core.mq.messages;

import java.time.Instant;

public class Event {

    private Instant timestamp;
    private String producedBy;
    private String type;
    private String action;
    private String id;
}
