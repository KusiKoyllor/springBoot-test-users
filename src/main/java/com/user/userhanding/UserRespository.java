package com.user.userhanding;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<UserEntity, Long> {
}
