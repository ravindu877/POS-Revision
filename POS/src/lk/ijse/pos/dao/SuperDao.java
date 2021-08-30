package lk.ijse.pos.dao;

import java.util.ArrayList;

public interface SuperDao<T, ID> {

    public boolean add(T t) throws Exception;

    public boolean delete(ID id) throws Exception;

    public boolean update(T t) throws Exception;

    public T searchC(ID id) throws Exception;

    public ArrayList<T> getAll() throws Exception;

}
