package com.washmycar.usermicroservice.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "DatabaseSequence")
public class SequenceGenerator {
	
	 @Id
	 private String  id;
	 private int sequence;
	 
	 
	 public String getId() {
		 return id;
	}
	 public void setId(String id) {
		 this.id = id;
	}
	 public int getSequence() {
		 return sequence;
	}
	 public void setSequence(int sequence) {
		 this.sequence = sequence;
	}
	    
	    

}
