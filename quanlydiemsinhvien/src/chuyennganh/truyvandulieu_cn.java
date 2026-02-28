/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package chuyennganh;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public interface truyvandulieu_cn <T> {
    List<T> getALL();
    Optional<T> get(int id);
    int insert(T t);
    
    boolean update(T t);
    boolean delete(T t);
    boolean delete(int id);
}
