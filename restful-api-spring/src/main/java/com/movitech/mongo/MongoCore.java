package com.movitech.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @ProjectName: restful-api-spring
 * @version create time：2019年3月20日下午4:24:52
 * @author: 周志刚
 * @ClassName: MongoCore
 * @Description: TODO
 */
public class MongoCore {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		MongoClient mc = new MongoClient("127.0.0.1", 27017);

		MongoDatabase md = mc.getDatabase("admin");
		ListCollectionsIterable<Document> listCollection = md.listCollections();
		MongoCollection<Document> collection = md.getCollection("runoob");

		Document document = new Document("title", "MongoDB").append("description", "database").append("likes", 100)
				.append("by", "Fly");
		collection.insertOne(document);

		System.out.println(md.getCollection(listCollection.first().getString("name")).find());

		mc.getDatabaseNames().forEach(System.out::println);
	}
}
