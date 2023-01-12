package com.martijn.timvandersteenBackend.service;

import com.martijn.timvandersteenBackend.model.Role;

public interface RoleService {
    Role findByName(String name);
}
