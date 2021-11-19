package com.sprintDemo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprintDemo.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	public User findByUserName(String userName);
	
	@Transactional
	@Modifying
	@Query("update User us set us.password=?1 where us.userName=?2")
	public void update(String password, String userName);
	
	@Query("from User u where u.userId=?1")
	public User getById(Long userId);

}
