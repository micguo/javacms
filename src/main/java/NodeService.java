import Service.DbConnection;
import Service.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Hao on 2016-06-12.
 */
public class NodeService
{
    private enum Options {
        OP_UPDATE,
        OP_INSERT
    }

    static public List<Node> loadAll()
    {
        String sql = "SELECT * FROM Node";
        Node n;
        List<Node> rs = new ArrayList<>();
        try {
            Statement stat = DbConnection.getConnection().createStatement();
            ResultSet dbrs = stat.executeQuery(sql);
            while(dbrs.next()) {
                n = NodeService.load(dbrs.getInt("id"));
                rs.add(n);
            }
        } catch (SQLException e) {
            Log.error(e);
        }
        return rs;
    }


    /**
     * Save a node object
     * @param Node n
     * @return interger, n
     */
    static public Integer save(Node n)
    {
        Options op;
        String sql;
        Integer nid =  n.getId();
        if (nid != null) {
            op = Options.OP_UPDATE;
        } else {
            op = Options.OP_INSERT;
        }

        switch(op) {
            case OP_INSERT:
                sql = "INSERT INTO Node (Body, Type, Created) Values (?, ?, ?)";
                try {
                    PreparedStatement preStat = DbConnection.getConnection().prepareStatement(sql);
                    preStat.setString(1, n.getBody());
                    preStat.setInt(2, n.getType());
                    java.util.Date date = new Date();
                    Timestamp timestamp = new Timestamp(date.getTime());
                    preStat.setTimestamp(3, timestamp);
                    preStat.executeUpdate();
                    System.out.println("New node saved.");
                } catch (SQLException e) {
                    Log.error(e);
                }
                break;
            case OP_UPDATE:
                sql = "Update Node SET Body = ?, Type = ? WHERE id = ?";
                try {
                    PreparedStatement preStat = DbConnection.getConnection().prepareStatement(sql);
                    preStat.setString(1, n.getBody());
                    preStat.setInt(2, n.getType());
                    preStat.setInt(3, n.getId());
                    preStat.executeUpdate();
                    System.out.print("Update node");
                } catch (SQLException e) {
                    Log.error(e);
                }
                break;
            default:
                throw new RuntimeException("System error");
        }
        return nid;
    }

    static public Node load(Integer nid)
    {
        if (nid <= 0) {
            throw new RuntimeException();
        }
        Node n = new Node();
        String sql = "SELECT * FROM Node WHERE Id = ?";
        try {
            PreparedStatement preStat = DbConnection.getConnection().prepareStatement(sql);
            preStat.setInt(1, nid);
            ResultSet rs = preStat.executeQuery();
            if (rs.next()) {
                n.setId(nid);
                n.setBody(rs.getString("Body"));
                n.setType(rs.getInt("Type"));
                n.setCreated(new Date(rs.getTimestamp("Created").getTime()));
                n.setUpdated(new Date(rs.getTimestamp("Updated").getTime()));
            } else {
                n = null;
            }
        } catch (SQLException e) {
            Log.error(e);
        }

        return n;
    }

    static public boolean delete(Integer nid)
    {
        String sql;
        Boolean rs = false;
        sql = "DELETE FROM Node WHERE id = ?";
        try {
            PreparedStatement preStat = DbConnection.getConnection().prepareStatement(sql);
            preStat.setInt(1, nid);
            if (preStat.executeUpdate() > 0) {
                rs = true;
            }
        } catch (SQLException e) {
            Log.error(e);
        }

        return rs;
    }
}
