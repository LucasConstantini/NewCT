package cleartrip.model.dao;

import cleartrip.model.base.BaseDAO;
import cleartrip.model.pojo.CategoriaDespesa;
import cleartrip.model.pojo.Despesa;
import cleartrip.model.pojo.Viagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DespesaDAO implements BaseDAO<Despesa> {
    
    public static final String CRITERION_VIAGEM = "1";
    public static final String CRITERION_USUARIO = "2";

//    public void setImagem(Connection conn, byte[] imagem) throws Exception {
//        String sql = "INSERT INTO foto(arquivo) VALUES (?);";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        int i = 0;
//        ps.setBytes(++i, imagem);
//        ps.execute();
//        ps.close();
//    }
//    public byte[] getImagem(Connection conn, Long id) throws Exception {
//        String sql = "SELECT arquivo FROM foto WHERE id=?;";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setLong(1, id);
//        ResultSet rs = ps.executeQuery();
//        byte[] imagem = null;
//        if (rs.next()) {
//            imagem = rs.getBytes("foto");
//        }
//        rs.close();
//        ps.close();
//        return imagem;
//    }
    @Override
    public void create(Despesa e, Connection conn) throws Exception {
        String sql = "INSERT INTO despesa(viagem_fk, categoria_despesa_fk, valor, nomeestabelecimento, cnpj, descritivo, valorrealautorizado, datacompra, horacompra, comprovante) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, e.getViagem().getId());
        ps.setLong(++i, e.getCategoriaDespesa().getId());
        ps.setDouble(++i, e.getValor());
        ps.setString(++i, e.getNomeEstabelecimento());
        ps.setLong(++i, e.getCnpj());
        ps.setString(++i, e.getDescritivo());
        ps.setDouble(++i, e.getValorRealAutorizado());
        ps.setString(++i, e.getDataCompra());
        ps.setString(++i, e.getHoraCompra());
        ps.setBytes(++i, e.getFoto());
        ps.execute();
        ps.close();

    }

    @Override
    public Despesa readById(Long id, Connection conn) throws Exception {
        Despesa e = new Despesa();
        return e;
    }

    @Override
    public List<Despesa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Despesa> lista = new ArrayList<Despesa>();
        String sql = "SELECT despesa.*, usuario.id as usuario_id, usuario.nome as usuario_nome, categoria_despesa.id as categoria_despesa_id, categoria_despesa.nome as categoria_despesa_nome , viagem.id as viagem_id FROM viagem right join usuario on viagem.usuario_fk = usuario.id right join despesa on despesa.viagem_fk = viagem.id right join categoria_despesa on despesa.categoria_despesa_fk = categoria_despesa.id WHERE 1=1";
        Long criterionUsuario = (Long) criteria.get(CRITERION_USUARIO);
        if (criterionUsuario != null && criterionUsuario > 0) {
            sql += " AND usuario.id = '" + criterionUsuario + "'";
        }

        Long criterionViagem = (Long) criteria.get(CRITERION_VIAGEM);
        if (criterionViagem != null && criterionViagem > 0) {
            sql += " AND viagem.id = '" + criterionViagem + "'";
        }
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while(rs.next()){
            Despesa d = new Despesa();
            d.setId(rs.getLong("id"));
            d.setFoto(rs.getBytes("comprovante"));
            d.setValor(rs.getDouble("valor"));
            d.setNomeEstabelecimento(rs.getString("nomeestabelecimento"));
            d.setDataCompra(rs.getString("datacompra"));
            d.setHoraCompra(rs.getString("horacompra"));
            d.setCnpj(rs.getLong("cnpj"));
            d.setDescritivo(rs.getString("descritivo"));
            d.setValorRealAutorizado(rs.getDouble("valorrealautorizado"));
            
            //Categoria Despesa
            CategoriaDespesa categoriaDespesa = new CategoriaDespesa();
            categoriaDespesa.setId(rs.getLong("categoria_despesa_id"));
            categoriaDespesa.setNome(rs.getString("categoria_despesa_nome"));
            d.setCategoriaDespesa(categoriaDespesa);
            
            //Viagem
            Viagem viagem = new Viagem();
            viagem.setId(rs.getLong("viagem_id"));
            d.setViagem(viagem);
            
            lista.add(d);
        }
        
        rs.close();
        s.close();

        return lista;
    }

    @Override
    public void update(Despesa e, Connection conn) throws Exception {
        String sql = "UPDATE despesa SET comprovante=?, valor=?,nomeestabelecimento=?, datacompra=?, horacompra=?, cnpj=?, descritivo=?, valorrealautorizado=?, viagem_fk=?, categoria_despesa_fk=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;

        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM despesa WHERE id = " + id + ";");
        st.close();
    }
}
