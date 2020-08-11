package com.lumendata.customer.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lumendata.common.entities.CustomerEntity;
/**
 * @author jeetu
 */
@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends Neo4jRepository<CustomerEntity, Long> {
    
	CustomerEntity findByGuid(String guid);
	
	@Query(value = "MATCH (customer:Customer {guid: {guid}})-[]-() RETURN customer")
	CustomerEntity findByGuidWithAllRelation(@Param("guid") String guid);
	
}
