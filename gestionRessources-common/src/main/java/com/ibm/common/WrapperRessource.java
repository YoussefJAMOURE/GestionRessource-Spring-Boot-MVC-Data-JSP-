package com.ibm.common;

import java.util.List;

public class WrapperRessource {
	private List<Ressource> list;

	public WrapperRessource(List<Ressource> list) {
		super();
		this.list = list;
	}
	
	public WrapperRessource() {
		super();
	}

	public List<Ressource> getList() {
		return list;
	}

	public void setList(List<Ressource> list) {
		this.list = list;
	}
	
	
}
