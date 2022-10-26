package com.example.VotingSystemReborn.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class VoteFormListRequest {

    private Long id;

    private String name;

    private String description;


}
