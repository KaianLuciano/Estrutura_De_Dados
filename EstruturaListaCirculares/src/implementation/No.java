package implementation;

public class No<T> {

	private T conteudo;
	private No<T> refNo;
	
	public No(T conteudo) {
		refNo = null;
		this.conteudo = conteudo;
	}

	public T getConteudo() {
		return conteudo;
	}

	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}

	public No<T> getRefNo() {
		return refNo;
	}

	public void setRefNo(No<T> refNo) {
		this.refNo = refNo;
	}

	@Override
	public String toString() {
		return "[conteudo = " + conteudo + "]";
	}
	
	
}
