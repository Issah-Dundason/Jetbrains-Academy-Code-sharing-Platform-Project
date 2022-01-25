package platform;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity(name = "Codes")
public class Code {
    @Id
    @JsonIgnore
    private String id;

    @Lob
    private String code;

    @Column(name = "load_date")
    @JsonIgnore
    private LocalDateTime loadDate;

    private int time;
    private int views;

    @JsonIgnore
    @ColumnDefault(value = "false")
    private boolean restricted = false;

    @Transient
    @JsonIgnore
    public boolean isViewsRestricted() {
        return viewsRestricted;
    }

    public void setViewsRestricted(boolean viewsRestricted) {
        this.viewsRestricted = viewsRestricted;
    }

    @Transient
    private boolean viewsRestricted;

    @Transient
    private String date;

    @PrePersist
    private void setLoadDate() {
        this.loadDate = LocalDateTime.now();
    }

    public void setId(String id) {
        this.id = id;
    }

    @PostLoad
    private void setDate() {
        String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        date = formatter.format(loadDate);
    }

    public boolean isRestricted() {
        return restricted;
    }

    public void setRestricted(boolean b) {
        this.restricted = b;
    }

    public int getTime() {
        return time;
    }

    public int getViews() {
        return views;
    }

    public LocalDateTime getLoadDate() {
        return loadDate;
    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setTime(int time) {
        this.time = time;
    }

    
}
