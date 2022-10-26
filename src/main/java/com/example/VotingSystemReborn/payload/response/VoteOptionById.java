package com.example.VotingSystemReborn.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteOptionById {

    private Long id;

    private String name;

    private Integer nrOfVotes;

}
