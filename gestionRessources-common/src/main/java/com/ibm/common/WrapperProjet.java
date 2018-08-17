package com.ibm.common;

import java.util.List;

public class WrapperProjet {
	private List<Projet> list;

	public WrapperProjet(List<Projet> list) {
		super();
		this.list = list;
	}
	
	public WrapperProjet() {
		super();
	}

	public List<Projet> getList() {
		return list;
	}

	public void setList(List<Projet> list) {
		this.list = list;
	}
	
	
}
