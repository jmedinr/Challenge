/*
* Rest of Questions
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
public class QuestionModel {
    
    //GET
    public static ArrayList<QuestionE> getQuestions() throws SQLException, ClassNotFoundException {
           ArrayList<QuestionE> data;
        try (Connection con = Connect.getConnection()) {
            String query = "SELECT * FROM bdpreguntas.questions";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            data = new ArrayList<>();
            while(result.next()){
                data.add(new QuestionE(result.getString(2),result.getInt(3),result.getInt(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9)));
            }
            con.close();
        }
        //System.out.println(data.toString());
        return data;
    }
    
    
    
}
