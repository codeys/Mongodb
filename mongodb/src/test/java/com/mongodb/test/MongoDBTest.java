package com.mongodb.test;

import java.util.List;

import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.bean.Number;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.utils.MongoDBUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:mongodb-context.xml"})
public class MongoDBTest {
	public static String HOST = "localhost";
	public static int PORT = 27017;
	public static String DBNAME = "test";
	
	@Test
	public void MongoDbTest() {
		
		MongoDatabase mDatabase = MongoDBUtil.getMongoConnection(HOST, PORT, DBNAME);
		System.out.println(mDatabase.getName());
		MongoCollection<Document> collection = mDatabase.getCollection("numbers");
		FindIterable<Document> iterable = collection.find();
		MongoCursor<Document> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			Document document = (Document) iterator.next();
			String json = document.toJson();
			System.out.println(json);
		}
	}
	
	@Autowired
	MongoTemplate mongoTemplate;
	@Test
	public void MongoDbTemplate() {
		List<Number> numbers = mongoTemplate.findAll(Number.class,"numbers");
		System.out.println(numbers.size());
	}

}
