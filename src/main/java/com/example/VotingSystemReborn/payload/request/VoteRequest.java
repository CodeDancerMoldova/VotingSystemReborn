package com.example.VotingSystemReborn.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteRequest {

    private String optionName;

    private Long formId;

}
