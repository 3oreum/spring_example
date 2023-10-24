package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
	// Spring Data JPA: JpaRepository

	// save(객체)   - id 가 없으면 insert, id 가 있으면 update 둘 다 됨
	// findById()  - select
	// delete(객체)  - delete
	// findAll()   - 전제 조회
	
	// JPQL 문법  - ex02/1
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name);
	public List<StudentEntity> findByNameIn(List<String> names);
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	public List<StudentEntity> findByEmailContains(String email);
	public List<StudentEntity> findByNameStartingWith(String name);
	public List<StudentEntity> findByIdBetween(int start, int end);
	
	// ex02/2
	// 1) JPQL 디비로 안 가고 엔티티로 조회
	//@Query(value = "select st from new_student st where st.dreamJob = :dreamJob")
	
	// 2) native query로 조회
	@Query(value = "select * from `new_student` where dreamJob = :dreamJob", nativeQuery = true)
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
	
}
