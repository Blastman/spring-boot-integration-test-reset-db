package org.torson.db.reset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.torson.db.reset.entities.ImportantUser;

import java.util.List;

public interface ImportantUserRepository extends JpaRepository<ImportantUser, Integer> {

    @Query("select user from ImportantUser user where user.firstName like %:search% or user.lastName like %:search%")
    List<ImportantUser> findByFistNameLikeOrLastNameLike(String search);

    @Query("select user from ImportantUser user where user.id = 1")
    ImportantUser selectFirstUser();

}
