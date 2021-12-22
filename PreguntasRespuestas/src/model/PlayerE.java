/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author juanm
 */
public class PlayerE {
    private int id;
    private String name;
    private int point;
    private int category;

    public PlayerE(int id,String name, int point, int category) {
        this.id = id;
        this.name = name;
        this.point = point;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "PlayerE{" + ", id=" + id + ", name=" + name + ", point=" + point + ", category=" + category + '}';
    }
    
    
    
}
