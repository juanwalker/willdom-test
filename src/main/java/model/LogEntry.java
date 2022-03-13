package model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="LogEntry")
public class LogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Lob
    @Column(nullable = false)
    private String message;
    @Lob
    @Column(nullable = true)
    private String exception;
    @Column(nullable = false)
    private Date timestamp;
}
