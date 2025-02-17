package exercicios;

import java.util.ArrayList;
import java.util.Iterator;

public class HashTable {
	
	private ArrayList<Object>[] tabela;
	
	@SuppressWarnings("unchecked")
	public HashTable() {
		this.tabela = new ArrayList[20];
	}
	
	private int hash(int chave) {
		return chave % tabela.length;
	}
	
	public Object get(int chave) {
		int hash = hash(chave);
		return tabela[hash];
	}
	
	public void put(int chave, Object aluno) {
		int hash = hash(chave);
		
		ArrayList<Object> alunos = tabela[hash];
		if(alunos == null) {
			alunos = new ArrayList<Object>();
			alunos.add(aluno);
			this.tabela[hash] = alunos;
		} else {
			for(int i = 0; i < alunos.size(); i++) {
				if(alunos.get(i).getClass() == aluno.getClass()) {
					alunos.set(i, aluno);
				}
			}
			alunos.add(aluno);
		}
		
		
	}
	
	public Object remove(int chave) {
		int hash = hash(chave);
		ArrayList<Object> alunos = this.tabela[hash];
		
		Iterator<Object> it = alunos.iterator();
		Object aluno = null;
		
		while(it.hasNext()) {
			aluno = it.next();
			if(aluno.getClass() == chave) {
				it.remove();
			}
		}
		this.tabela[hash] = null;
		return aluno;
	}

}
