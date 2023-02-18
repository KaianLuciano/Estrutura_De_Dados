package implementation;

public class ListaCircular<T> {

	private No<T> noCauda;
	private No<T> noCabeca;
	private int tamanhoLista;
	
	public ListaCircular() {
		noCabeca = null;
		noCauda = null;
	}
	
	public void add(T conteudo) {
		No<T> novoNo = new No<T>(conteudo);
		if(tamanhoLista == 0) {
			noCabeca = novoNo;
			noCauda = noCabeca;
			noCabeca.setRefNo(noCauda);
		}
		else {
			novoNo.setRefNo(noCauda);
			noCabeca.setRefNo(novoNo);
			noCauda = novoNo;
		}
		
		tamanhoLista++;
	}
	
	public void remove(int index) {
		if(index >= tamanhoLista) {
				throw new IndexOutOfBoundsException("O indice é maior que o tamanho do vetor.");
		}
		No<T> noAuxiliar = noCauda;
		
		if(index == 0) {
			noCauda = noCauda.getRefNo();
			noCabeca.setRefNo(noCauda);
		} else if (index == 1) {
			noCauda.setRefNo(noCauda.getRefNo().getRefNo());
		} else {
			No<T> noIndex = getNo(index);
			for(int contador = 0; contador < index - 1; contador++) {
				noAuxiliar = noAuxiliar.getRefNo();
			}
			noAuxiliar.setRefNo(noIndex.getRefNo());
		}
		tamanhoLista--;
	}
	
	public T get(int index) {
		return getNo(index).getConteudo();
	}
	
	private No<T> getNo(int index){		
		if(isEmpaty()) {
			throw new IndexOutOfBoundsException("A lista está vazia !");
		}
		
		if(index > size()) {
			return null;
		}
		
		if(index == 0) {
			return noCauda;
		}
			
		No<T> noAuxiliar = noCauda;
		
		for(int contador = 0; contador < index; contador++) {
			noAuxiliar = noAuxiliar.getRefNo();
		}
		return noAuxiliar;
	}
	
	public boolean isEmpaty() {
		return tamanhoLista == 0 ? true : false;
	}
	
	public int size() {
		return tamanhoLista;
	}
	
	@Override
	public String toString() {
		String strRetorno = "";
		
		if(isEmpaty()) {
			throw new IndexOutOfBoundsException("Lista está vazia");
		}
		
		No<T> noAuxiliar = noCauda;
		for(int contador = 0; contador < size(); contador++) {
			strRetorno += "[No{Conteudo = " + noAuxiliar.getConteudo() + "}] ---> ";
			noAuxiliar = noAuxiliar.getRefNo();
		}
		
		return strRetorno;
	}
	
}
