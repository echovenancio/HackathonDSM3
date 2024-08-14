package model;
import bd.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Aeroporto {

    public Aeroporto() {}

    public void adicionarVoo(Voo voo) {
        var conn = Conexao.conectar();
        try {
            var sql = "INSERT INTO voos(numero, origem, destino, assentos_disp) VALUES(?, ?, ?, ?)";
            var pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, voo.getNumeroVoo());
            pstmt.setString(2, voo.getOrigem());
            pstmt.setString(3, voo.getDestino());
            pstmt.setInt(4, voo.getAssentosDisponiveis());
            pstmt.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void removerVoo(Voo voo) {
        var conn = Conexao.conectar();
        try {
            var sql = "DELETE FROM voos WHERE numero = ?";
            var pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, voo.getNumeroVoo());
            pstmt.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void exibirVoos() {
        var conn = Conexao.conectar();
        try {
            var plist = new ArrayList<Voo>();
            var sql = "SELECT numero, origem, destino, assentos_disp FROM voos";
            var pstmt = conn.prepareStatement(sql);
            ResultSet rs =  pstmt.executeQuery();
            while (rs.next()) {
                plist.add(new Voo(rs.getString("numero"), rs.getString("origem"), rs.getString("destino"), rs.getInt("assentos_disp")));
            }
            for (Voo voo: plist) {
                System.out.println(voo.toString());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}