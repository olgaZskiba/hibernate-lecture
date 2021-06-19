package io.github.olgazskiba.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student{
    @Id
    @GeneratedValue
    Integer id;
    String name;
    String gitHub;
}
