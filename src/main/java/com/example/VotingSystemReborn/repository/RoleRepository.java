package com.example.VotingSystemReborn.repository;



import com.example.VotingSystemReborn.models.ERole;
import com.example.VotingSystemReborn.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
