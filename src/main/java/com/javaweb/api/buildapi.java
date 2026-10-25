//package com.javaweb.api;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.javaweb.cofig.MolderMapperConfig;
//import com.javaweb.model.ErrorResonse;
//import com.javaweb.model.buildingbean;
//import com.javaweb.model.storebean;
//import com.javaweb.repository.entity.Buildingentity;
//import com.javaweb.service.Buildingservice;
//
//import customexeption.FieldRequeiredException;
//@RestController
//@Transactional
//public class buildapi {
//	@Autowired
//	private Buildingservice buildingservice;
//	@Autowired
//	private ModelMapper modelMapper;
//	@PersistenceContext
//	private EntityManager entityManager;
//	 @GetMapping(value = "/api/building")
//	    public List<buildingbean> getBuildingbeans(@RequestParam Map<String,Object> params,
//	    		@RequestParam (value = "typecode", required = false)List<String> typecode) {
//	    	List<buildingbean> result = buildingservice.search(params,typecode);
//	    	return result;
//	    }
//	 @PostMapping(value = "/api/building")
//	 public void postbuilding(@RequestBody buildingbean bean) {
//		 Buildingentity buildingentity = modelMapper.map(bean,Buildingentity.class);
//		 buildingentity.getName();
//		 buildingentity.getManagername();
//		 entityManager.persist(buildingentity);
//		 System.out.println("thanh cong");
//		
//	 }
//	 @PutMapping(value ="/api/building")
//	 public void updatebuilding(@RequestBody buildingbean bean) {
//		 Buildingentity buildingentity = modelMapper.map(bean, Buildingentity.class);
//		 buildingentity.setId(1L);
//		 buildingentity.setName(bean.getName());
//		 buildingentity.setManagername(bean.getManagername());
//		 entityManager.merge(buildingentity);
//		 
//	 } 
//	 public  void validate(buildingbean buildingDTO) {
//		 if(buildingDTO.getName() == null || buildingDTO.getName().equals("") || buildingDTO.getNumberofbasement() == null) {
//			 throw new FieldRequeiredException("Name or Number is null");
//		 }
//		
//	 }
//	 @DeleteMapping(value = "/api/building/{id}")
//	 public void deletebuilding(@PathVariable Long id) {
//		 Buildingentity buildingentity = entityManager.find(Buildingentity.class, id);
//		 entityManager.remove(buildingentity);
//	 }
//	 @GetMapping(value="/api/toy")
//	 public List<storebean> getStorebean(@RequestParam(value = "toy",required = false)String toy,
//			 @RequestParam(value = "sold",required = false )Integer sold,
//			 @RequestParam(value = "ward",required = false)String ward) {
//		 List<storebean> liststorebean = new ArrayList<>();
//		 
//		 storebean storebean1=new storebean();
//		 storebean1.setToy("robot");
//		 storebean1.setSold(100);
//		 storebean1.setWard("hanoi");
//		 storebean storebean2 = new storebean();
//		 storebean2.setToy("gundam");
//		 storebean2.setSold(200);
//		 storebean2.setWard("sontay");
//		 liststorebean.add(storebean2);
//		 liststorebean.add(storebean1);
//		 return liststorebean;
//	 }
//}