package org.example.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalDateTimeWrapper {
    private LocalDateTime dateTime;

    public LocalDateTimeWrapper() {
        this.dateTime = LocalDateTime.now();
    }

    public LocalDateTimeWrapper(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "LocalDateTimeWrapper{" +
                "dateTime=" + dateTime +
                '}';
    }
}
