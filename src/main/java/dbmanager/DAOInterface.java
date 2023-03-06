/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import java.util.List;

/**
 *
 * @author Oalskad
 */
public interface DAOInterface<T> {
    public boolean insert(T t);
    public boolean delete(T t);
    public boolean update(T t);
    public boolean select(T t);
    public List<T> list();
    
}
