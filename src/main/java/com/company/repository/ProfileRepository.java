package com.company.repository;

import com.company.entity.ProfileEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ProfileRepository extends PagingAndSortingRepository<ProfileEntity,Integer> {
    Optional<ProfileEntity> findByEmail(String email);

    @Query("from ProfileEntity")
    Page<ProfileEntity>   allUsers(Pageable pageable) ;

    @Modifying
    @Transactional
    @Query("update  ProfileEntity p set p.password=:password where p.email=:email")
    void changePassword(String password, String email);

    @Modifying




    @Transactional
    @Query("update  ProfileEntity p set p.name=:name, p.surname=:surname where p.email=:email")
    void changeNameSurname(String name, String surname, String email);

    @Transactional
    @Modifying
    @Query("update ProfileEntity  p set p.tempEmail = ?1 where p.id = ?2")
    void updateEmail(String tempEmail, Integer profileId);
}
