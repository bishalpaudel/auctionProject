package org.auctionproject.web.service;

import org.auctionproject.web.model.Role;
import org.auctionproject.web.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.SocketPermission;

/**
 * Created by bishal on 3/30/17.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public Role getBasicRole() {
        return roleRepository.findRoleByName("USER");
    }
}
