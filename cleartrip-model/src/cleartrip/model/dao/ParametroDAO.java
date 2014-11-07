package cleartrip.model.dao;

import cleartrip.model.base.BaseDAO;
import cleartrip.model.pojo.Empresa;
import cleartrip.model.pojo.Parametro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParametroDAO implements BaseDAO<Parametro> {
    
    public static final String CRITERION_USUARIO = "1";
    public static final String CRITERION_DATA_TERMINO = "3";
    

    @Override
    public void create(Parametro e, Connection conn) throws Exception {
        String sql = "INSERT INTO parametros(manha, tarde, noite, datatermino, datainicio, margemdeslocamento, custokm, empresa_fk) VALUES (?, ?, ?, ?, ?, ?, ?, ?)RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
       
            ps.setString(++i, e.getManha());
       
            ps.setString(++i, e.getTarde());
       
            ps.setString(++i, e.getNoite());
       
            ps.setString(++i, (String) e.getDataTermino());
       
            ps.setString(++i, (String) e.getDataInicio());
        
            ps.setInt(++i, e.getMargemDeslocamento());
        
            ps.setDouble(++i, e.getCustoKm());
       
        ps.setLong(++i, e.getEmpresa().getId());

        ps.execute();
        ps.close();

    }

    @Override
    public Parametro readById(Long id, Connection conn) throws Exception {
        Parametro e = null;
        String sql = "SELECT parametros.*, empresa.id as empresa_id, empresa.nome as empresa_nome FROM empresa right join parametros on parametros.empresa_fk = empresa.id where parametros.id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new Parametro();
            e.setId(rs.getLong("id"));
            e.setManha(rs.getString("manha"));
            e.setTarde(rs.getString("tarde"));
            e.setNoite(rs.getString("noite"));
            e.setDataInicio(rs.getString("dataInicio"));
            e.setDataTermino(rs.getString("dataTermino"));
            e.setMargemDeslocamento(rs.getInt("margemDeslocamento"));
            e.setCustoKm(rs.getDouble("custoKm"));
            
            //empresa
            Empresa empresa = new Empresa();
            empresa.setId(rs.getLong("empresa_id"));
            empresa.setNome(rs.getString("empresa_nome"));
            e.setEmpresa(empresa);

        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<Parametro> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Parametro> lista = new ArrayList<Parametro>();
        String sql = "SELECT parametros.*, empresa.id as empresa_id, empresa.nome as empresa_nome, usuario.id as usuario_id, usuario.nome as usuario_nome, usuario.empresa_fk FROM empresa right join parametros on parametros.empresa_fk = empresa.id left join usuario on empresa.id = usuario.empresa_fk WHERE 1=1";
        
        Long criterionUsuario = (Long) criteria.get(CRITERION_USUARIO);
        if (criterionUsuario != null) {
            sql += " AND usuario.id = " + criterionUsuario;
        }
        
        java.util.Date dataFim = (java.util.Date) criteria.get(CRITERION_DATA_TERMINO);

        if (dataFim != null) {
            java.sql.Date criterion_data_fim = new Date(dataFim.getTime());
            sql += " AND datatermino <= '" + criterion_data_fim + "'";
        }
        
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            Parametro e = new Parametro();
            
            e.setId(rs.getLong("id"));
            e.setManha(rs.getString("manha"));
            e.setTarde(rs.getString("tarde"));
            e.setNoite(rs.getString("noite"));
            e.setDataInicio(rs.getString("dataInicio"));
            e.setDataTermino(rs.getString("dataTermino"));
            e.setMargemDeslocamento(rs.getInt("margemDeslocamento"));
            e.setCustoKm(rs.getDouble("custoKm"));
            
            //empresa
            Empresa empresa = new Empresa();
            empresa.setId(rs.getLong("empresa_id"));
            empresa.setNome(rs.getString("empresa_nome"));
            e.setEmpresa(empresa);

            lista.add(e);
        }
        rs.close();
        s.close();

        return lista;
    }
    
    
    @Override
    public void update(Parametro e, Connection conn) throws Exception {
        String sql = "UPDATE parametros SET manha=?, tarde=?, noite=?, datatermino=?, datainicio=?, margemdeslocamento=?, custokm=?, empresa_fk=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
       
            ps.setString(++i, e.getManha());
        
            ps.setString(++i, e.getTarde());
        
            ps.setString(++i, e.getNoite());
        
            ps.setString(++i, (String) e.getDataTermino());
        
            ps.setString(++i, (String) e.getDataInicio());
       
            ps.setInt(++i, e.getMargemDeslocamento());
        
            ps.setDouble(++i, e.getCustoKm());
        
        ps.setLong(++i, e.getEmpresa().getId());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM parametros WHERE id = " + id + ";");
        st.close();
    }
}
