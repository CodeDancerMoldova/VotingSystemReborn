package com.example.VotingSystemReborn.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "vote_form")
@Getter
@Setter
@NoArgsConstructor
public class VoteForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "voteForm",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<VoteOption> voteOptions = new ArrayList<>();

    public void addVoteOption(VoteOption voteOption){
        voteOptions.add(voteOption);
        voteOption.setVoteForm(this);
    }
    public void removeVoteOption(VoteOption voteOption) {
        voteOptions.remove(voteOption);
        voteOption.setVoteForm(null);
    }
}
