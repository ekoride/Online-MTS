package com.prayesh.mts.entity;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "shows")
public class Show {
    @Id
    @SequenceGenerator(
        name = "show_sequence",
        sequenceName = "show_sequence",
        initialValue = 9000,
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "show_sequence"
    )
    private long showId;
    @ManyToOne
    @JoinColumn(
        name = "show_movieId",
        referencedColumnName = "movieId",
        nullable = false
    )
    //@Column(name = "show_movieId", nullable = false)
    private Movie movie;
    @Column(name = "show_date", nullable = false)
    private Date showDate;
    @Column(name = "show_timing", nullable = false)
    private String showTiming;
    @Column(name = "show_tickets", nullable = false)
    private int ticketsAvailable;
    
}
