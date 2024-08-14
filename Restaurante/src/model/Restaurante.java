package model;

import bd.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class Restaurante {
    private Connection conn = null;

    public Restaurante() {
        this.conn = Conexao.conectar();
    }

    public void addPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido(numero, mesa) VALUES(?, ?)";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, pedido.getNumero());
            pstmt.setInt(2, pedido.getMesa());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String fetchRowId = "SELECT ROWID FROM pedido WHERE numero = ?";
        int rowid = -1;
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(fetchRowId);
            pstmt.setInt(1, pedido.getNumero());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                rowid = rs.getInt("ROWID");
            }
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (ItemPedido item: pedido.getItems()) {

            String sqlInsertPedido = "INSERT INTO item(nome, preco, pedido_rowid) VALUES(?, ?, ?)";
            try {
                PreparedStatement pstmt = this.conn.prepareStatement(sqlInsertPedido);
                pstmt.setString(1, item.getNome());
                pstmt.setDouble(2, item.getPreco());
                pstmt.setInt(3, rowid);
                pstmt.executeUpdate();
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean removerPedido(int nPedido) {
        String sql = "DELETE FROM pedido WHERE numero = ?";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1, nPedido);
            int result = pstmt.executeUpdate();
            pstmt.close();
            return 1 == result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Pedido> getPedido(int nPedido) {
        Pedido pedido = new Pedido(0);
        String sql = "SELECT numero, mesa, ROWID FROM pedido WHERE numero = ?";
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setInt(1,nPedido);
            ResultSet rs = pstmt.executeQuery();
            pstmt.close();
            if (rs.next()) {
                pedido.setMesa(rs.getInt("mesa"));
                pedido.setNumero(rs.getInt("numero"));
                int rowid = rs.getInt("ROWID");
                String itemSql = "SELECT nome, preco, pedido_rowid FROM item WHERE pedido_rowid = ?";
                pstmt = this.conn.prepareStatement(itemSql);
                pstmt.setInt(1, rowid);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    pedido.adicionarItemPedido(new ItemPedido(rs.getString("nome"), 0, rs.getDouble("preco")));
                }
                pstmt.close();
                return Optional.of(pedido);
            } else {
               pstmt.close();
               return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void exibirPedidos() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "pedidos=" + pedidos.toString() +
                '}';
    }
}

