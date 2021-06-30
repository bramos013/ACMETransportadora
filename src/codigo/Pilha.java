package codigo;

import java.util.EmptyStackException;

public class Pilha {
    // Atributos
    private int count;
    private Carga pilha[];

    public Pilha() {
        count = 0;
        pilha = new Carga[10];
    }

    // insere o elemento no topo da pilha
    // O(1)
    public void push(Carga carga) throws FullStackException {
        if (count == pilha.length) // se o array esta cheio
            throw new FullStackException();
        pilha[count] = carga;
        count++;
    }

    // remove e retorna o elemento do topo da pilha
    //(erro se a pilha estiver vazia)
    // O(1)
    public Carga pop() {
        if (count == 0)
            throw new EmptyStackException();
        Carga num = pilha[count-1];
        pilha[count-1] = null;
        count--;
        return num;
    }

    // retorna, mas não remove, o elemento do topo da pilha
    // (erro se a pilha estiver vazia)
    // O(1)
    public Carga top() {
        if (count == 0)
            throw new EmptyStackException();
        return pilha[count-1];
    }

    // retorna o número de elementos da pilha
    // O(1)
    public int size() {
        return count;
    }

    // retorna true se a pilha estiver vazia, e false caso contrário
    // O(1)
    public boolean isEmpty() {
        return count==0;
    }

    // esvazia a pilha
    // O(1)
    public void clear() {
        count = 0;
        pilha = new Carga[10];
    }

    public static class FullStackException extends Throwable {
    }
}
