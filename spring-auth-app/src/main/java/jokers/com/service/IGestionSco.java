package jokers.com.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

public interface IGestionSco<T,U,V> {
	
	//T for Object and U for type of Object
	
	public T save(T g);
	//public Etudiant findOne(U mtricle);
	public Optional<T> getOne(U mtricle);
	public Page<T> getAll(V p, V s);
	public T updateObject(T g, U mtricle);
	public boolean update(T g, U mtricle);
	public boolean delete(U mtricle);
	public Page<T> getAlls(Integer p, Integer s);
	//public Etudiant findByKeyword(String keyword);

}
