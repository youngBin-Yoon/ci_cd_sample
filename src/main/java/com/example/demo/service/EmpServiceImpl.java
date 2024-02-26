package com.example.demo.service;

import com.example.demo.Exception.NoEmpFoundException;
import com.example.demo.entity.emp.EmpEntity;
import com.example.demo.model.Emp;
import com.example.demo.repository.emp.EmpRepository;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	EmpRepository repository;
	
	MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	
	@Override
	public List<Emp> getAllEmps() {
		List<EmpEntity> entities = repository.findAll();
		return mapperFactory.getMapperFacade().mapAsList(entities, Emp.class);
	}
	
	@Override
	public void addEmp(Emp emp) {
		EmpEntity entity = mapperFactory.getMapperFacade().map(emp, EmpEntity.class);
		repository.save(entity);
	}

	@Override
	public Emp getEmp(Long id)  {
		 Optional<EmpEntity> optional = (repository.findById(id));
		 if (optional.isPresent()) {
			 return mapperFactory.getMapperFacade().map(optional.get(), Emp.class);
		 } else {
			 throw new NoEmpFoundException();
		 }
	}

	@Override
	public void deleteEmp(Long id) {
		repository.deleteById(id);		
	}

	@Override
	public void updateEmp(Long id, Emp emp) {
		EmpEntity entity = mapperFactory.getMapperFacade().map(emp, EmpEntity.class);
		repository.save(entity);
	}
}
