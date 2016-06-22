package dao.impl;

import dao.ComposicoesRepository;
import dao.config.ConnectionMysql;
import rest.model.Composicao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Livia on 16/06/2016.
 */
public class ComposicoesRepositoryImpl implements ComposicoesRepository {
    public boolean create(final Composicao composicao) {
//        Statement stmt = null;
//        PreparedStatement ps = null;
//        boolean ok = false;
//        try {
//            String sql = "INSERT INTO insumos VALUES (" +
//                    "'" + composicao.getOrigem() +"', "+ composicao.getCodigo() +", '"+
//                    composicao.getDescricao() +"' )";
//
//            stmt = con.createStatement();
//            stmt.executeUpdate(sql);
//
//            ok = true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (stmt != null)
//                    stmt.close();
//                if (ps != null)
//                    ps.close();
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
//        }
//        return ok;
        return false;
    }

    public Composicao update(final Composicao insumo) {
        return null;
    }

    public Composicao read(final Composicao insumo) {
//        Connection conn = null;
//        Statement stmt = null;
//        List<Composicao> list = new ArrayList<Composicao>();
//        try {
//            String sql = "SELECT * FROM INSUMOS";
//            conn = ConnectionMysql.getConnection();
//            stmt = conn.createStatement();
//            ResultSet result = stmt.executeQuery(sql);
//            while (result.next()) {
//                list.add(builder(result));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (stmt != null)
//                    stmt.close();
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
//        }
//
//        return list.get(0);
        return null;
    }

    public int delete(final int codigo, final String origem) {
        return 0;
    }

    private Composicao builder(ResultSet result) throws SQLException {
        Composicao composicao = new Composicao();
        composicao.setCodigo(result.getInt("codigo"));
        composicao.setDescricao(result.getString("descricao"));
        composicao.setOrigem(result.getString("origem"));
        return composicao;
    }
}
