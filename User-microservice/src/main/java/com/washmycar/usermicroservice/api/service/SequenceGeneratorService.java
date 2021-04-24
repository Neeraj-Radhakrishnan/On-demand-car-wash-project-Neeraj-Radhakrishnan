package com.washmycar.usermicroservice.api.service;

import java.util.Objects;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.washmycar.usermicroservice.api.model.SequenceGenerator;

@Service
public class SequenceGeneratorService {

	private MongoOperations mongooperations; 
	
	 @Autowired
	    public SequenceGeneratorService(MongoOperations mongoOperations) {
	        this.mongooperations = mongoOperations;
	    }
       //Method For Increasing the Value Of Sequence In SequenceGenerator Database
	    public long generateSequence(String seq) {
           // Get Sequence Number And Updates It In Users Document
	    	SequenceGenerator counter = mongooperations.findAndModify(query(where("_id").is(seq)),
	                new Update().inc("sequence",1), options().returnNew(true).upsert(true),
	                SequenceGenerator.class);
	        return !Objects.isNull(counter) ? counter.getSequence() :1;

	    }
	    
	    public void decreamentSequence(String seq) {

	        mongooperations.findAndModify(query(where("_id").is(seq)),
	                new Update().inc("sequence",-1), options().returnNew(true).upsert(true),
	                SequenceGenerator.class);

	    }

}

