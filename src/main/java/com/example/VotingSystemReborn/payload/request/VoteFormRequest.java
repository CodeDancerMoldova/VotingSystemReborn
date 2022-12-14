package com.example.VotingSystemReborn.payload.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class VoteFormRequest {

    @NotBlank(message = "Name is mandatory!")
    private String name;

    private String description;

    private List<VoteOptionRequest> voteOptions;

}
