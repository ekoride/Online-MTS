package com.prayesh.mts.entity;

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
@Table(name = "Ticket")
public class Ticket {
    @Id
    @SequenceGenerator(
        name = "ticket_sequence",
        sequenceName = "ticket_sequence",
        initialValue = 7777777,
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "ticket_sequence"
    )
    private long ticketNumber;
    @ManyToOne
    @JoinColumn(
        name = "ticket_user",
        referencedColumnName = "userId"
    )
    private user ticketUser;
    @ManyToOne
    @JoinColumn(
        name = "ticket_Movie",
        referencedColumnName = "movieId"
    )
    private Movie ticketMovie;
    //private Movie ticketMovieName;
    //private Show ticketShowTiming;
    @ManyToOne
    @JoinColumn(
        name = "ticket_showId",
        referencedColumnName = "showId"
    )
    private Show ticketShowId;
    //private Show ticketShowDate;
    //private Show ticketSeats;
}
