package com.example.VotingSystemReborn.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "vote_option")
@Data
@NoArgsConstructor
public class VoteOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public VoteOption(String name, Integer nrOfVotes) {
        this.name = name;
        this.nrOfVotes = nrOfVotes;
    }

    private Integer nrOfVotes;

    @ManyToOne(fetch = FetchType.LAZY)
    private VoteForm voteForm;

}
