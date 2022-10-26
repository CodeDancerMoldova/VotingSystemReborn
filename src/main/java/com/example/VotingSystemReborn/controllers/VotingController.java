package com.example.VotingSystemReborn.controllers;

import com.example.VotingSystemReborn.payload.request.VoteFormListRequest;
import com.example.VotingSystemReborn.payload.request.VoteFormRequest;
import com.example.VotingSystemReborn.payload.response.VoteFormatByIdResponse;
import com.example.VotingSystemReborn.payload.request.VoteRequest;
import com.example.VotingSystemReborn.security.services.VotingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vote")
@RequiredArgsConstructor
public class VotingController {

    private final VotingService votingService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Long createVoteForm(@Valid @RequestBody VoteFormRequest voteFormRequest) {
        return votingService.createVoteForm(voteFormRequest);
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<VoteFormListRequest> findAllVoteForm() {
        return votingService.findAllVoteForms();
    }

    @GetMapping("/list-{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public VoteFormatByIdResponse findByIdVoteForm(@PathVariable Long id) {
        return votingService.findByIdVoteForm(id);
    }

    @PostMapping("/voting")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> voteFor(@RequestBody VoteRequest voteRequest) {
        votingService.voteFor(voteRequest.getOptionName(), voteRequest.getFormId());
        return ResponseEntity.ok("Success vote!");
    }
}
