/*
* Rest of players
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author jmedinr
 */
public class PlayerModel {
    
    //POST
    public static void registerPlayer(String name, int points, int category) throws SQLException{
        try (Connection con = Connect.getConnection()) {
            String query = "INSERT INTO bdpreguntas.players (playername, points, category) VALUES (?,?,?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, points);
            ps.setInt(3, category);
            ps.executeUpdate();
            con.close();
        }
    }
    
    //GET
    public static ArrayList<PlayerE> getUser() throws SQLException, ClassNotFoundException {
           ArrayList<PlayerE> data;
        try (Connection con = Connect.getConnection()) {
            String query = "SELECT * FROM bdpreguntas.players";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            data = new ArrayList<>();
            while(result.next()){
                data.add(new PlayerE(result.getInt(1),result.getString(2),result.getInt(3),result.getInt(4)));
            }
            con.close();
        }
        return data;
    }
    
    //PUT
    public static void UpdatePlayer(int points, int category,int idplayers) throws SQLException{
        try (Connection con = Connect.getConnection()) {
            String query = "UPDATE bdpreguntas.players SET points=?, category=? WHERE idplayers=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, points);
            ps.setInt(2, category);
            ps.setInt(3, idplayers);
            ps.executeUpdate();
            con.close();
        }
    }
    

}
