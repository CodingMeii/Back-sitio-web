/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentcloud.cloud.app.repositories;
import com.rentcloud.cloud.app.entities.Category;
import com.rentcloud.cloud.app.repositories.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RYZEN
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository repository;
    
    /*
    Select * from
    @return retorna todos los registro de la tabla
    */
    public List<Category> getAll(){
        return (List<Category>) repository.findAll();
    }
    
    /*
    Select * from table where ID=id
    @param id
    @return retorna un registro por el ID
    */
    public Optional<Category> getCategory(int id){
        return repository.findById(id);
    }
    
    /*
    insert & update
    @param admin
    @return actualiza registro ya existente o crea un nuevo registro
    */
    public Category save (Category category){
        return repository.save(category);
    }
    
    /*
    Delete from table
    @param admin
    */
    public void delete (Category category){
        repository.delete(category);
    }
}
