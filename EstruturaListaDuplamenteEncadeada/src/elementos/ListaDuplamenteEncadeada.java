package elementos;

public class ListaDuplamenteEncadeada<T> {
	
	private NoDuplo<T> primeiroNo;
	private NoDuplo<T> ultimoNo;
	
	private int tamanhoLista;
	
	public ListaDuplamenteEncadeada() {
	}
	
	public ListaDuplamenteEncadeada(int tamanhoLista) {
		primeiroNo = null;
		ultimoNo = null;
		this.tamanhoLista = tamanhoLista;
	}
	
	public void remove(int index) {
		if(index == 0) {
			primeiroNo = primeiroNo.getNoProximo();
			if(primeiroNo != null) {
				primeiroNo.setNoPrevio(null);
			}
		}
		else {
			NoDuplo<T> noAuxiliar = getNo(index);
			noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());
			if(noAuxiliar != ultimoNo) {
				noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());
			}
			else {
				ultimoNo = noAuxiliar;
			}
		}
		
		tamanhoLista--;
		
	}
	
	public void add(int index,T elemento) {
		NoDuplo<T> noAuxiliar = getNo(index);
		NoDuplo<T> novoNo = new NoDuplo<>(elemento);
		novoNo.setNoProximo(noAuxiliar);
		
		if(novoNo.getNoProximo() != null) {
			novoNo.setNoPrevio(noAuxiliar.getNoPrevio());
			novoNo.getNoProximo().setNoPrevio(novoNo);
		}
		else {
			novoNo.setNoPrevio(ultimoNo);
			ultimoNo = novoNo;
		}
		
		if(index == 0) {
			primeiroNo = novoNo;
		}
		else {
			novoNo.getNoPrevio().setNoProximo(novoNo);
		}
		
		tamanhoLista++;
		
	}
	
	public void add(T elemento) {
		NoDuplo<T> novoNo = new NoDuplo<>(elemento);
		novoNo.setNoProximo(null);
		novoNo.setNoPrevio(ultimoNo);
		if(primeiroNo == null) {
			primeiroNo = novoNo;
		}
		
		if(ultimoNo != null) {
			ultimoNo.setNoProximo(novoNo);
		}
		ultimoNo = novoNo;
		tamanhoLista++;
	}
	
	public T get(int index){
		return getNo(index).getConteudo();
	}
	
	private NoDuplo<T> getNo(int index){
		NoDuplo<T> noAuxiliar = primeiroNo;
		
		for(int contador = 0; (contador < index) && (noAuxiliar.getNoProximo() != null); contador++) {
			noAuxiliar = noAuxiliar.getNoProximo();
		}
		return noAuxiliar;
	}
	
	public int size() {
		return tamanhoLista;
	}
	
	@Override
	public String toString() {
		String strRetorno = "";
		
		NoDuplo<T> noAuxiliar = primeiroNo;
		for(int contador = 0; contador < size(); contador++) {
			strRetorno += "[No{Conteudo = " + noAuxiliar.getConteudo() + "}] ---> ";
			noAuxiliar = noAuxiliar.getNoProximo();
		}
		strRetorno += " null";
		
		return strRetorno;
	}

}
