package com.example.VotingSystemReborn.repository;


import com.example.VotingSystemReborn.models.VoteForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteFormRepository extends JpaRepository<VoteForm,Long> {

}
