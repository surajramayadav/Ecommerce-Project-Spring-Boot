package com.adminpanel.adminpanel.repository;

import com.adminpanel.adminpanel.models.UserModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {


    @Transactional
    @Modifying
    @Query(value = "update  user ref set ref.user_age=?1,ref.phone_number=?2,ref.user_name=?3 where ref.user_id=?4 ",nativeQuery = true)
    public int updateUser(String user_age,String phone_number,String user_name,Long userId);

}
