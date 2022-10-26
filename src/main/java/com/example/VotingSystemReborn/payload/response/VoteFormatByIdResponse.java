package com.example.VotingSystemReborn.payload.response;

import com.example.VotingSystemReborn.models.VoteOption;
import com.example.VotingSystemReborn.payload.response.VoteOptionById;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VoteFormatByIdResponse {

    private Long id;

    private String name;

    private String description;

    private List<VoteOptionById> voteOptions;


}
