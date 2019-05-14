package com.mongodb.utils;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

/***
 * 
 * @author yushuai
 *
 *         MongoDB工具类
 *
 *         2019年3月8日
 */
public class MongoDBUtil {

	/**
	 * 不通过认证获取连接数据库对象
	 * 
	 * @param host   主机地址
	 * @param port   端口号
	 * @param dbName 数据库名称
	 * @return
	 */
	public static MongoDatabase getMongoConnection(String host, int port, String dbName) {
		MongoDatabase mDatabase = null;

		MongoClient mClient = new MongoClient(host, port);
		mDatabase = mClient.getDatabase(dbName);

		return mDatabase;
	}

	/**
	 * 需要密码认证方式连接
	 * 
	 * @param host     主机地址
	 * @param port     端口号
	 * @param dbName   数据库名称
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public static MongoDatabase getMongoConnectionByPWD(String host, int port, String dbName, String username,
			String password) {
		MongoDatabase mDatabase = null;

		ServerAddress seed = new ServerAddress(host, port);
		List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
		MongoCredential mCredential = MongoCredential.createCredential(username, dbName, password.toCharArray());
		credentialsList.add(mCredential);
		MongoClient mClient = new MongoClient(seed, credentialsList);
		mDatabase = mClient.getDatabase(dbName);
		return mDatabase;
	}
	
	/***
	 * 关闭连接
	 * @param mClient
	 * @param mDatabase
	 */
	public static void closeMongoDB(MongoClient mClient,MongoDatabase mDatabase) {
		
		if(mDatabase != null) {
			mDatabase = null;
		}
		
		if(mClient != null) {
			mClient.close();
		}
		
		
	}

}
