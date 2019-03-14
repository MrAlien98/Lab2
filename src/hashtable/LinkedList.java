package hashtable;

import exceptions.NoBookException;

public class LinkedList<K, V> {

	private HashNode<K, V> first;
	
	public LinkedList(K key, V value) {
		first=new HashNode<K, V>(key, value);
	}

	public HashNode<K, V> getFirst() {
		return first;
	}

	public void setFirst(HashNode<K, V> first) {
		this.first = first;
	}
	
	public void add(K key, V value) {
		HashNode<K, V> newHashNode=new HashNode<>(key, value);
		HashNode<K, V> actual=first;
		if(first==null) {
			first=newHashNode;
		}else {
			while(actual.getNext()!=null) {
				actual=actual.getNext();
			}
			actual.setNext(newHashNode);
			newHashNode.setPrev(actual);
		}
	}
	
	public void delete(V value) throws NoBookException {
		HashNode<K, V> temp=first;
		if(first.getValue()==value) {
			first=first.getNext();
		}else {
			while(temp.getNext()!=null) {
				if(temp.getValue()==value) {
					temp.getNext().setPrev(temp.getPrev());
					temp.getPrev().setNext(temp.getNext());
					temp.setNext(null);
					temp.setPrev(null);
				}else {
					temp=temp.getNext();
				}
			}
			if(temp.getNext()==null) {
				throw new NoBookException(value);
			}
		}
	}
	
	public HashNode<K, V> find(K key) {
		HashNode<K, V> temp=first;
		if(temp.getKey().equals(key)) {
			return temp;
		}else {
			temp=temp.getNext();
			while(temp!=null) {
				if(temp.getKey().equals(key)) {
					return temp;
				}else {
					temp=temp.getNext();
				}
			}
		}
		return null;
	}
	
}
