package database;

import java.util.ArrayList;

public interface DAOInterface<T> {
	public ArrayList<T> selectAll();
	
	public T selectById(String id);
	
	public int insert(T t);
	
	public int insertAll(ArrayList<T> arr);
	
	public int deleteById(String id);
	
	public int deleteAll(ArrayList<String> arr);
	
	public int update(T t);
}
