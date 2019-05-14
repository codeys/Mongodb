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
 *         MongoDB������
 *
 *         2019��3��8��
 */
public class MongoDBUtil {

	/**
	 * ��ͨ����֤��ȡ�������ݿ����
	 * 
	 * @param host   ������ַ
	 * @param port   �˿ں�
	 * @param dbName ���ݿ�����
	 * @return
	 */
	public static MongoDatabase getMongoConnection(String host, int port, String dbName) {
		MongoDatabase mDatabase = null;

		MongoClient mClient = new MongoClient(host, port);
		mDatabase = mClient.getDatabase(dbName);

		return mDatabase;
	}

	/**
	 * ��Ҫ������֤��ʽ����
	 * 
	 * @param host     ������ַ
	 * @param port     �˿ں�
	 * @param dbName   ���ݿ�����
	 * @param username �û���
	 * @param password ����
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
	 * �ر�����
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
