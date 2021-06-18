package io.github.olgazskiba.bean;

import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class Boy {
    Integer id;
    String boy;
    String boyName;
    String boyLastName;
    Timestamp timestamp;
}
