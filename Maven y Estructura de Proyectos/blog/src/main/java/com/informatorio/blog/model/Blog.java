package com.informatorio.blog.model;

public class Blog {
	String topic;

	public Blog() {
	}

	public Blog(String topic) {
		this.topic = topic;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return this.topic;
	}
}
