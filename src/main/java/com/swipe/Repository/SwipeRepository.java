package com.swipe.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swipe.Model.Employee;
import com.swipe.Model.Swipe;
@Repository
public interface SwipeRepository extends CrudRepository<Swipe, Integer> {
	
	List<Swipe> findByDateAndEmployee(Date date,Employee employee);

}
