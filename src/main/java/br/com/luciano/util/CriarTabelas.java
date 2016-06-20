package br.com.luciano.util;

import javax.persistence.Persistence;

public class CriarTabelas {

	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("EnquetePU");

	}

}
