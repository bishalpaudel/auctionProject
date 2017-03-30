package org.auctionproject.web.repository;

import org.auctionproject.web.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by bishal on 3/30/17.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

//    @Query("SELECT id, name FROM Role WHERE name='USER'")
    Role findRoleByName(String name);
}
