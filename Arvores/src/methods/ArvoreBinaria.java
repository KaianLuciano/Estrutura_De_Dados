package methods;

public class ArvoreBinaria<T extends Comparable<T>> {

	private BinNo<T> noRaiz;
		
	public ArvoreBinaria() {
		noRaiz = null;
	}
	
	public void inserir(T conteudo) {
		BinNo<T> novoNo = new BinNo<>(conteudo);
		noRaiz = inserir(noRaiz, novoNo);
	}
	
	private BinNo<T> inserir (BinNo<T> atual, BinNo<T> novoNo){
		if(atual == null) {
			return novoNo;
		} 
		else if(novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
			atual.setNoEsquerda(inserir(atual.getNoEsquerda(), novoNo));
		}
		else {
			atual.setNoDireita(inserir(atual.getNoDireita(), novoNo));
		}
		return atual;
	}

	public void  exibirInOrdem() {
		System.out.print("\n Exibindo InOrdem ");
		exibirOrdemIn(noRaiz);
	}
	
	private void exibirOrdemIn(BinNo<T> atual) {
		if(atual != null) {
			exibirOrdemIn(atual.getNoEsquerda());
			System.out.print(atual.getConteudo() + ", ");
			exibirOrdemIn(atual.getNoDireita());
		}
	}
	
	public void  exibirPreOrdem() {
		System.out.print("\n Exibindo PreOrdem ");
		exibirOrdemPre(noRaiz);
	}
	
	private void exibirOrdemPre(BinNo<T> atual) {
		if(atual != null) {
			System.out.print(atual.getConteudo() + ", ");
			exibirOrdemPre(atual.getNoEsquerda());
			exibirOrdemPre(atual.getNoDireita());
		}
	}
	
	public void  exibirPosOrdem() {
		System.out.print("\n Exibindo PosOrdem ");
		exibirOrdemPos(noRaiz);
	}
	
	private void exibirOrdemPos(BinNo<T> atual) {
		if(atual != null) {
			exibirOrdemPos(atual.getNoEsquerda());
			exibirOrdemPos(atual.getNoDireita());
			System.out.print(atual.getConteudo() + ", ");
		}
	}
	
	public void remover(T conteudo) {
		try {
			BinNo<T> atual = noRaiz;
			BinNo<T> pai = null;
			BinNo<T> filho = null;
			BinNo<T> temp = null;

			while(atual != null && !atual.getConteudo().equals(conteudo)) {
				pai = atual;
				if(conteudo.compareTo(atual.getConteudo()) < 0) {
					atual = atual.getNoEsquerda();
				}
				else {
					atual = atual.getNoDireita();
				}
			}
			
			if(atual == null) {
				System.out.println("Conteudo nao encontrado. Bloco Catch");
			}
			
			if(pai == null) {
				if(atual.getNoDireita() == null) {
					this.noRaiz = atual.getNoEsquerda();
				} 
				else if (atual.getNoEsquerda() == null) {
					this.noRaiz = atual.getNoDireita();
				}
				else {
					for(temp = atual, filho = atual.getNoEsquerda(); filho.getNoDireita() != null; temp = filho, filho = filho.getNoEsquerda()) {
						if(filho != atual.getNoEsquerda()) {
							temp.setNoDireita(filho.getNoEsquerda());
							filho.setNoEsquerda(noRaiz.getNoEsquerda());
						}
					}
					
				}
				
				filho.setNoDireita(noRaiz.getNoDireita());
				noRaiz = filho;
			}
			else if (atual.getNoDireita() == null) {
				if(pai.getNoEsquerda() == atual) {
					pai.setNoEsquerda(atual.getNoEsquerda());
				}
				else {
					pai.setNoDireita(atual.getNoDireita());
				}
			}
			else if(atual.getNoEsquerda() == null) {
				if(pai.getNoEsquerda() == atual) {
					pai.setNoEsquerda(atual.getNoDireita());
				}
				else {
					pai.setNoDireita(atual.getNoDireita());
				}
			}
			else {
				for(temp = atual, filho = atual.getNoEsquerda(); filho.getNoDireita() != null; temp = filho, filho = filho.getNoDireita()) {
					if(filho != atual.getNoEsquerda()) {
						temp.setNoDireita(filho.getNoEsquerda());
						filho.setNoEsquerda(atual.getNoEsquerda());
					}
					filho.setNoDireita(atual.getNoDireita());
					if(pai.getNoEsquerda() == atual) {
						pai.setNoEsquerda(filho);
					}
					else {
						pai.setNoDireita(filho);
					}
				}
			}
			
		} catch (NullPointerException e) {
			System.out.println("Conteudo nao encontrado. Bloco Catch");
		}
	}
	
}