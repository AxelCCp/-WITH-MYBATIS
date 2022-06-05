package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import com.example.demo.models.entity.UserProfile;

@Mapper
public interface UserProfileMapper {
	
	//PARA MAPEAR LA API
	@Select("select * from UserProfile where id=#{id}")
	UserProfile get(@Param("id") String id);
	
	@Select("select * from UserProfile")
	List<UserProfile>getList();
	
	@Insert("INSERT INTO UserProfile VALUES(#{id}, #{name}, #{phone}, #{address})")
	int insertUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address")String address);
	
	@Update("UPDATE UserProfile SET name=#{name}, phone=#{phone}, address=#{address} WHERE id=#{id}")
	int updateUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address")String address);
	
	@Delete("DELETE FROM UserProfile WHERE id=#{id}")
	int deleteUserProfile(@Param("id")String id);
	
}
