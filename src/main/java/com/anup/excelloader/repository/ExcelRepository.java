package com.anup.excelloader.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.anup.excelloader.model.ExcelDocument;

import java.util.List;

@Repository
public interface ExcelRepository extends MongoRepository<ExcelDocument, ObjectId> {

	List<ExcelDocument> findByClientID(String clientId);

}


