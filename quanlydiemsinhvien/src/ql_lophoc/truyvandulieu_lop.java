/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ql_lophoc;

import java.util.List;
import java.util.Optional;


public interface truyvandulieu_lop <T> {
    List<T> getALL();
    Optional<T> get(int id);
    int insert(T t);
    
    boolean update(T t);
    boolean delete(T t);
    boolean delete(int id);
    
}
