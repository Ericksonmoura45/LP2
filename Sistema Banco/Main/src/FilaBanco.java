package src;

import java.util.Arrays;

public class FilaBanco {

    private Pessoa[] pessoas;
    private int size; // quantos elementos tem
    private int capacity; // quantos elementos podem ter

    public FilaBanco(){
        this(10);
    }
    public FilaBanco (int capacity){
        pessoas = new pessoas[capacity];
        this.size = 0;
        this.capacity = capacity;
    }


    public void addPessoa(String nome, int idade){

        addPessoa(new Pessoa(nome,idade));

    }
    public void addPessoa(Pessoa pessoa){
        this.ensureCapacity();
        this.pessoas[getSize()] = pessoa;
        heapifyUp(getSize());
        size++;

    }
    private void heapifyUp(int index){
        if(hasParent(index)){
            return;
        }
        int parentIndex = getParentIndex(index);
        Pessoa node = pessoas[index];
        Pessoa pai = pessoas[parentIndex];
    }
    private boolean hasParent(int index){
        return getParentIndex(index) >= 0 && getParentIndex(index) < size;
    }

    private int getParentIndex(int index) {

        return (int) Math.floor((index - 1)/2);
    }

    private void ensureCapacity(){
        if (getSize() == capacity)
            this.pessoas = Arrays.copyOf(this.pessoas, getSize() * 2);
    }
    public int getSize(){
        return size;

    }
    public int peek(){
        if (getSize() == 0){
            return null;
        }

        return pessoas[0];

    }
    public void remove(){

    }
}
