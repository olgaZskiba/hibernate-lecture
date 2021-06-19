package io.github.olgazskiba.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "beasty_boys")
public class Boy {
    @Id
    @GeneratedValue
    Integer id;
    String boy;
    String boyName;
    String boyLastName;
    @Column(name = "nickname")
    String login;
    @UpdateTimestamp
    Timestamp timestamp;
}
