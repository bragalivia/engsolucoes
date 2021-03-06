package dao.impl;

import dao.ConnectionMysql;
import dao.InsumoRepository;
import model.Insumo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Livia on 12/06/2016.
 */
public class InsumoRepositoryImpl implements InsumoRepository {

    @Override
    public boolean create(final Insumo insumo) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement ps = null;
        boolean ok = false;
        try {
            String sql = "INSERT INTO insumos VALUES (" +
                    "'" + insumo.getOrigem() +"', "+ insumo.getCodigo() +", '"+
                    insumo.getDescricao() +"' )";

            conn = ConnectionMysql.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

            ok = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return ok;
    }

    @Override
    public Insumo update(final Insumo insumo) {
        return null;
    }

    @Override
    public Insumo read(final Insumo insumo) {
        Connection conn = null;
        Statement stmt = null;
        List<Insumo> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM INSUMOS";
            conn = ConnectionMysql.getConnection();
            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                list.add(builder(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return list.get(0);
    }

    @Override
    public int delete(final int codigo, final String origem) {
        return 0;
    }

    private Insumo builder(ResultSet result) throws SQLException {
        Insumo insumo = new Insumo();
        insumo.setCodigo(result.getInt("codigo"));
        insumo.setDescricao(result.getString("descricao"));
        insumo.setOrigem(result.getString("origem"));
        return insumo;
    }
}
