package database;

import java.util.ArrayList;

import model.Author;

public class AuthorDAO implements DAOInterface<Author>{
	private ArrayList<Author> data = new ArrayList<>();

	@Override
	public ArrayList<Author> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Author> selectById(Author t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Author t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Author> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Author t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<Author> arr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Author t) {
		// TODO Auto-generated method stub
		return 0;
	}


	 
}
