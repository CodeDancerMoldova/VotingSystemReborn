package com.example.VotingSystemReborn.repository;


import com.example.VotingSystemReborn.models.VoteOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteOptionRepository extends JpaRepository<VoteOption,Long> {

    Optional<VoteOption> findByNameAndVoteForm_Id(String optionName, Long formId);

}
