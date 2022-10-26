package com.example.VotingSystemReborn.security.services;


import com.example.VotingSystemReborn.models.VoteForm;
import com.example.VotingSystemReborn.models.VoteOption;
import com.example.VotingSystemReborn.payload.request.*;
import com.example.VotingSystemReborn.payload.response.VoteFormatByIdResponse;
import com.example.VotingSystemReborn.payload.response.VoteOptionById;
import com.example.VotingSystemReborn.repository.VoteFormRepository;
import com.example.VotingSystemReborn.repository.VoteOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VotingService {

    private final VoteFormRepository voteFormRepository;
    private final VoteOptionRepository voteOptionRepository;

    public Long createVoteForm(VoteFormRequest voteFormRequest) {
        VoteForm voteForm = new VoteForm();

        for (VoteOptionRequest voteOptionRequest : voteFormRequest.getVoteOptions()) {
            voteForm.addVoteOption(new VoteOption(voteOptionRequest.getName(), 0));
        }

        voteForm.setDescription(voteFormRequest.getDescription());
        voteForm.setName(voteFormRequest.getName());

        voteFormRepository.save(voteForm);
        return voteForm.getId();
    }

    public List<VoteFormListRequest> findAllVoteForms() {
        List<VoteForm> voteForms = voteFormRepository.findAll();
        List<VoteFormListRequest> voteFormRequests = new ArrayList<>();

        for (VoteForm voteForm : voteForms) {
            voteFormRequests.add(new VoteFormListRequest(voteForm.getId()
                    , voteForm.getName()
                    , voteForm.getDescription()));
        }
        return voteFormRequests;
    }

    public VoteFormatByIdResponse findByIdVoteForm(Long id) {
        Optional<VoteForm> formOptional = voteFormRepository.findById(id);
        VoteForm voteForm = formOptional.orElseThrow(() -> new RuntimeException("Vote form with this id: " + id));
        VoteFormatByIdResponse voteFormatByIdResponse = new VoteFormatByIdResponse();
        List<VoteOptionById> voteOptionByIds = new ArrayList<>();

        for (VoteOption voteOption : voteForm.getVoteOptions()) {
            VoteOptionById voteOptionById = new VoteOptionById();
            voteOptionById.setId(voteOption.getId());
            voteOptionById.setName(voteOption.getName());
            voteOptionById.setNrOfVotes(voteOption.getNrOfVotes());
            voteOptionByIds.add(voteOptionById);
        }

        voteFormatByIdResponse.setId(voteForm.getId());
        voteFormatByIdResponse.setVoteOptions(voteOptionByIds);
        voteFormatByIdResponse.setDescription(voteForm.getDescription());
        voteFormatByIdResponse.setName(voteForm.getName());

        return voteFormatByIdResponse;
    }

    @Transactional
    public void voteFor(String optionName, Long voteFormId) {

        Optional<VoteOption> voteOptionOptional = voteOptionRepository.findByNameAndVoteForm_Id(
                optionName, voteFormId
        );
        VoteOption voteOption = voteOptionOptional.orElseThrow(() -> new RuntimeException("Vote option does not exist!"));
        voteOption.setNrOfVotes(voteOption.getNrOfVotes() + 1);
    }

}
