package org.tkzc.study.solr;

import java.awt.TextField;
import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

public class HelloSolr {

	public static String solrServerUrl = "http://10.1.6.198:8080/solr/core1";
	
	public static void main(String[] args) {
		addIndex();
		//queryIndex();
	}
	
	public static void addIndex() {
		SolrClient server = new HttpSolrClient(solrServerUrl);
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", "uniqueKey-doc-1");
		doc.addField("name", "骨质疏松性骨折与维生素K2的作用");
		
		try {
			UpdateResponse response = server.add(doc);
			server.commit();
			
			System.out.println("Query Time: " + response.getQTime());
			System.out.println("Elapsed Time: " + response.getElapsedTime());
			System.out.println("Status: " + response.getStatus());

			server.close();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void queryIndex() {
		String keyword = "骨质疏松";
		SolrClient server = new HttpSolrClient(solrServerUrl);
		SolrQuery param = new SolrQuery();
		param.setQuery("name:*" + keyword + "*");
		try {
			QueryResponse response = server.query(param);
			SolrDocumentList list = response.getResults();
			for(SolrDocument doc : list) {
				System.out.println(doc.get("id") + ": " + doc.get("name"));
			}
			server.close();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
