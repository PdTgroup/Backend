package com.electricity.entity;

public class IndexsOfModule {
	private float allscore;
	private float datas;
	private String indexName;
	private float weight;
	public IndexsOfModule(float allscore, float datas, String indexName, float weight) {
		super();
		this.allscore = allscore;
		this.datas = datas;
		this.indexName = indexName;
		this.weight = weight;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getAllscore() {
		return allscore;
	}
	public void setAllscore(float allscore) {
		this.allscore = allscore;
	}
	public float getDatas() {
		return datas;
	}
	public void setDatas(float datas) {
		this.datas = datas;
	}
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	
	
	

}
